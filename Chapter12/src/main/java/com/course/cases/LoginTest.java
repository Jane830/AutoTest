package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.utils.ConfigFile;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.annotations.BeforeTest;

public class LoginTest {
    @BeforeTest(groups = "loginTrue",description = "测试准备工作")
    public void beforeTest(){
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl((InterfaceName.UPDATEUSERINFO));
        //给 httpclient复制
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }
}
