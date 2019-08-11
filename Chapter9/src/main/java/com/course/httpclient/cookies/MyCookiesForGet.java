package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
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
    public void testGetWithCookies()throws IOException{
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url + uri;
        //声明一个get的方法
        HttpGet get = new HttpGet(testUrl);
        //声明一个client对象，用来进行方法的执行，并设置cookies信息
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.store).build();
        //执行get方法，并获得结果
        CloseableHttpResponse response = client.execute(get);
        //获取响应的状态码，判断返回的结果是否符合预期
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode= "+statusCode);

        if(statusCode == 200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }else {
            System.out.println("访问getwithcookies失败");
        }


    }
}
