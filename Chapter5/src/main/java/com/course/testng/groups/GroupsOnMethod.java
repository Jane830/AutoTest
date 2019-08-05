package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "1")
    public void method1(){
        System.out.println("组1的method1");
    }
    @Test(groups = "1")
    public void method2(){
        System.out.println("组1的method2");
    }
    @Test(groups = "3")
    public void method3(){
        System.out.println("组2的method3");
    }
    @BeforeGroups("1")
        public void beforegroup1(){
        System.out.println("before groups1 执行");
    }
    @AfterGroups("1")
    public void aftergroup1(){
        System.out.println("after group1 执行");
    }

}
