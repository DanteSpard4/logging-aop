package com.dantespard4.loggingaop;

public class persona {
    private final String name;
    private final int age;
    private final String email;
    private final String phoneNumber;

    public persona(String name, int age, String email, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "persona{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
