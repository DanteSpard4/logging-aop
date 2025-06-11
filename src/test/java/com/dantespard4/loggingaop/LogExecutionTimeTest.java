package com.dantespard4.loggingaop;

import com.dantespard4.loggingaop.annotations.LogExecutionTime;
import com.dantespard4.loggingaop.util.LogLevel;

import java.util.List;

public class LogExecutionTimeTest {

    @LogExecutionTime(level = LogLevel.WARN, logArgs = true, logReturnValue = true)
    public List<persona> testMethod(int num, String test, persona p) throws InterruptedException {
        Thread.sleep(500);
        persona p1 = new persona("Jane Doe", 25, "l","987-654-3210");
        return List.of(p, p1);
    }

    public static void main(String[] args) throws InterruptedException {
        LogExecutionTimeTest t = new LogExecutionTimeTest();
        persona p = new persona("John Doe", 30, "l","123-456-7890");
        t.testMethod(5, "Hello World", p);
    }
}
