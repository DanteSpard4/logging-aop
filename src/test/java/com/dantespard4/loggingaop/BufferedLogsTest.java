package com.dantespard4.loggingaop;

import com.dantespard4.loggingaop.annotations.BufferedLogs;
import com.dantespard4.loggingaop.util.LogBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BufferedLogsTest {
    private static final Logger log = LoggerFactory.getLogger(BufferedLogsTest.class);

    @BufferedLogs
    public void runWithLogs()  {
        LogBuffer.info("Testing BufferedLogs");
        LogBuffer.debug("This is a debug message");
        LogBuffer.warn("This is a warning message");
        LogBuffer.error("This is an error message");
        LogBuffer.error("This is an error with exception", new Exception("Test exception"));
        runWithBufferedLogs();
    }

    public void runWithBufferedLogs()  {
        LogBuffer.info("run internal method with buffered logs");
    }


    public static void main(String[] args)  {
        log.info("start logs");
        new BufferedLogsTest().runWithLogs();
        log.info("end logs");
    }
}
