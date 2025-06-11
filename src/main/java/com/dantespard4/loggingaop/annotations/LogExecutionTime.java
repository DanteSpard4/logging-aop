package com.dantespard4.loggingaop.annotations;

import com.dantespard4.loggingaop.util.LogLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogExecutionTime {
    LogLevel level() default LogLevel.INFO;
    boolean logArgs() default false;
    boolean logReturnValue() default false;
}
