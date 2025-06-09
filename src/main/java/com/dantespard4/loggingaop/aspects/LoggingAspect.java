package com.dantespard4.loggingaop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    @Around("execution(@com.dantespard4.loggingaop.annotations.LogExecutionTime * *(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("hola");
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;

        System.out.println("Method " + joinPoint.getSignature() + " executed in " + executionTime + "ms");

        return proceed;
    }
}
