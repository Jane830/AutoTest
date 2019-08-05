package com.course.testng;

import org.testng.annotations.Test;

public class DependencyTest {
    @Test
    public void dependency1 (){
        System.out.println("前提1");
        throw new RuntimeException();
    }
    @Test(dependsOnMethods = { "dependency1"})
    public void dependency2 (){
        System.out.println("前提1成立，这个 才会执行");
    }
}
