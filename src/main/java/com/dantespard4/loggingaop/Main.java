package com.dantespard4.loggingaop;


import com.dantespard4.loggingaop.annotations.LogExecutionTime;

public class Main {

    @LogExecutionTime
    public void exampleMethod()  {
        System.out.println("Executing exampleMethod...");
        anotherExampleMethod();
    }

    @LogExecutionTime
    public void anotherExampleMethod() {
        System.out.println("Executing anotherExampleMethod....");
        anotherExampleMethod2();
    }

    @LogExecutionTime
    public void anotherExampleMethod2() {
        System.out.println("Executing anotherExampleMethod2...");
    }

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        Main main = new Main();
        main.exampleMethod();
    }
}
