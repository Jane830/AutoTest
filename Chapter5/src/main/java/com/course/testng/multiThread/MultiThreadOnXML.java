package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnXML {
    @Test
    public void test1() {
        System.out.printf("test1 的线程:%s%n  ",  Thread.currentThread().getId() );
    }
    @Test
    public void test2() {
        System.out.printf("test2 的线程:%s%n  ",  Thread.currentThread().getId() );
    }
    @Test
    public void test3() {
        System.out.printf("test3  的线程:%s%n  ",  Thread.currentThread().getId() );
    }

}

