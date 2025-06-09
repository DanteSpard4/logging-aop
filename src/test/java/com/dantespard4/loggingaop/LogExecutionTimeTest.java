package com.dantespard4.loggingaop;

import com.dantespard4.loggingaop.annotations.LogExecutionTime;

public class LogExecutionTimeTest {

    @LogExecutionTime
    public void testMethod() throws InterruptedException {
        Thread.sleep(500);
    }

    public static void main(String[] args) throws InterruptedException {
        LogExecutionTimeTest t = new LogExecutionTimeTest();
        t.testMethod();
    }
}
