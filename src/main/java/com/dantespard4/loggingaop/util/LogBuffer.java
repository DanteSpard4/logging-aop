package com.dantespard4.loggingaop.util;



public class LogBuffer {
    private static final ThreadLocal<StringBuilder> logBuffer = ThreadLocal.withInitial(StringBuilder::new);
    private static final ThreadLocal<LogLevel> logLevel = ThreadLocal.withInitial(() -> LogLevel.INFO);

    public static void startBuffering() {
        logBuffer.get().setLength(0);
        logBuffer.get().append("\n");
        logLevel.set(LogLevel.INFO);
    }

    public static void info(String message) {
        logBuffer.get().append(" [INFO] ").append(message).append("\n");
        updateLogLevel(LogLevel.INFO);
    }

    public static void debug(String message) {
        logBuffer.get().append(" [DEBUG] ").append(message).append("\n");
        updateLogLevel(LogLevel.DEBUG);
    }

    public static void warn(String message) {
        logBuffer.get().append(" [WARN] ").append(message).append("\n");
        updateLogLevel(LogLevel.WARN);
    }

    public static void error(String message) {
        logBuffer.get().append(" [ERROR] ").append(message).append("\n");
        updateLogLevel(LogLevel.ERROR);
    }

    public static void error(String message, Exception e) {
        logBuffer.get().append(" [ERROR] ").append(message).append(": ")
                .append(e.getMessage()).append("\n");
        StackTraceElement ste = e.getStackTrace()[0];
        logBuffer.get().append("    at ").append(ste.getClassName()).append(".").append(ste.getMethodName())
                .append("(").append(ste.getFileName()).append(":").append(ste.getLineNumber()).append(")\n");
        updateLogLevel(LogLevel.ERROR);
    }

    public static String getAndClearBuffer() {
        String logs = logBuffer.get().toString();
        logBuffer.get().setLength(0);
        return logs;
    }

    public static LogLevel getLogLevel() {
        return logLevel.get();
    }

    private static void updateLogLevel(LogLevel newLevel) {
        if(newLevel.ordinal() > logLevel.get().ordinal()) {
            logLevel.set(newLevel);
        }
    }

}
