package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    //用来存储cookie信息的变量
    private CookieStore store ;
    @BeforeTest
    public void beforeTest(){
        //会自动找到resource中application文件
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }
    //获取cookies信息
    @Test
    public void testGetCookies() throws IOException {
        String result;
        //从配置文件中 拼接测试的url
        String uri = bundle.getString ("getCookies.uri");
        String testUrl = this.url + uri;
        // 测试逻辑代码书写
        HttpGet get = new HttpGet(testUrl);
        //HttpClient 没有办法获取cookie信息Default
        // HttpClient client = new DefaultHttpClient();
        //CookieStore store = new BasicCookieStore();
        this.store = new BasicCookieStore();
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(store).build();
        // CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //获取cookie信息
        //CookieStore  store = client.getCookiesStore();
        //
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = " + name + ";cookie value = "+value);
        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostMethod()throws IOException {
        String uri = bundle.getString("test.post.wtih.cookies");
        //拼接最终的测试地址
        String testUrl = this.url + uri;
        //声明一个Client对象，用来进行方法的执行
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.store).build();
        //声明一个方法，这个方法就是post方法
        HttpPost post = new HttpPost(testUrl);
        //添加参数；这个也可以优化，用例里面很多参数
        JSONObject param = new JSONObject();
        param.put("name", "jane");
        param.put("age", "18");
        //设置请求头信息 设置header信息;若公用的，可以优化到一个header工具类方法中
        post.setHeader("content-type", "application/json");
        // 将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);
        //声明一个对象来进行响应结果的存储
        String result;
        //设置cookies信息
        //client.setCookieStore(this.store);
        //执行post方法
        HttpResponse response = client.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
        //处理结果，判断返回结果是否符合预期
        //将返回的响应结果字符串转化为json对象
        JSONObject resultJson = new JSONObject(result);
        //具体判断返回结果的值

        //获取到结果值
        String name = (String)resultJson.get("name");
        String status = (String)resultJson.get("status");
        Assert.assertEquals("success", name);
        Assert.assertEquals("1", status);
    }
}
