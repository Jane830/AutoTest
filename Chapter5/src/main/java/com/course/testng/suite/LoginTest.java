package com.course.testng.suite;

import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void payTest() {
        System.out.println("登录成功了");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divisionWithException()
    {
        int i = 1 / 0;
        System.out.println("After division the value of i is :"+ i);
    }

}
