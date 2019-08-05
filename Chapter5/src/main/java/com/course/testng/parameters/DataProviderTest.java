package com.course.testng.parameters;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "provider")
    public void testDataProvider(String a,int b){
        System.out.println("参数="+a+"；数字="+b);
    }
    @DataProvider(name = "provider")
    public Object[] [] providerData(){
        Object[] [] o = new Object[][]{
                {"a",1},
                {"b",2},
        };
        return o;
    }
    @Test(dataProvider = "methodData")
    public void test1 (String a,int b){
        System.out.println("参数="+a+"；数字="+b);
    }
    @Test(dataProvider = "methodData")
    public void test2(String a,int b){
        System.out.println("参数="+a+"；数字="+b);
    }
    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result=null;
        if(method.getName().equals("test1")) {
            result = new Object[][]{
                    {"aa", 11},
                    {"bb", 22}
            };
        }else if (method.getName().equals("test2")){
                result=new Object[][]{
                        {"CC",33},
                        {"dd",44}
                };
        }
        return result;
            }
        }

