package com.dantespard4.loggingaop.aspects;


import com.dantespard4.loggingaop.annotations.BufferedLogs;
import com.dantespard4.loggingaop.util.LogBuffer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
public class BufferedLogsAspect {

    private static final Logger log = LoggerFactory.getLogger(BufferedLogsAspect.class);

    @Around("execution(@com.dantespard4.loggingaop.annotations.BufferedLogs * *(..)) && @annotation(bufferedLogs)")
    public Object aroundBufferedLogs(ProceedingJoinPoint joinPoint, BufferedLogs bufferedLogs) throws Throwable {

        LogBuffer.startBuffering();

        try {
            return joinPoint.proceed();
        } catch (Exception e) {
            LogBuffer.error("Excepción durante la ejecución del método",e);
            throw e;
        } finally {
            String bufferedOutput = LogBuffer.getAndClearBuffer();

            switch (LogBuffer.getLogLevel()) {
                case DEBUG -> log.debug(bufferedOutput);
                case WARN -> log.warn(bufferedOutput);
                case ERROR -> log.error(bufferedOutput);
                case TRACE -> log.trace(bufferedOutput);
                case INFO -> log.info(bufferedOutput);
            }
        }
    }
}
