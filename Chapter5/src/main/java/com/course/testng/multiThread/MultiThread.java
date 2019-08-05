package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThread {
//    测试方法在3个线程中并发执行，共被调用5次，执行超过10s
    @Test(threadPoolSize = 3,invocationCount = 5,timeOut = 10000)
    public void multiThreadTest(){
        System.out.printf("test:%s %n",Thread.currentThread().getId());
    }
}
