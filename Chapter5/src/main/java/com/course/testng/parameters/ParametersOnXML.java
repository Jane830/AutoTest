package com.course.testng.parameters;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersOnXML {
    @Test
    @Parameters(value = "para")
    public void parameterstest1(String a){
        System.out.println("参数值为"+a);
    }
    @Test
    @Parameters(value = "para1")
    public void parameterstest2(@Optional("0") String b){
        System.out.println("默认参数为"+b);
    }
}
