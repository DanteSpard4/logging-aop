package com.dantespard4.loggingaop.aspects;

import com.dantespard4.loggingaop.annotations.LogExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
public class LogExecutionTimeAspect {

    private static final Logger log = LoggerFactory.getLogger(LogExecutionTimeAspect.class);

    @Around("execution(@com.dantespard4.loggingaop.annotations.LogExecutionTime * *(..)) && @annotation(logExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;

        String message = String.format("Method %s executed in %dms", joinPoint.getSignature(), executionTime);

        if (logExecutionTime.logArgs()){
            Object[] args = joinPoint.getArgs();
            message += String.format(" | Args: %s", args.length > 0 ? java.util.Arrays.toString(args) : "No arguments");
        }

        if (logExecutionTime.logReturnValue()) {
            message += String.format(" | Return: %s", proceed);
        }

        switch (logExecutionTime.level()) {
            case DEBUG -> log.debug(message);
            case WARN -> log.warn(message);
            case ERROR -> log.error(message);
            case TRACE -> log.trace(message);
            case INFO -> log.info(message);
        }

        return proceed;
    }
}
