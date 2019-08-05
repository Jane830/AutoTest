package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    
    @Test
    public void testCase1(){
        System.out.println("这是测试test1");
    }
    @Test
    public void testCase2(){
        System.out.println("这是测试test2");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod这是");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod这是");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass这是类运行之前的方法");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass这是类运行之后的方法");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");
    }


}
