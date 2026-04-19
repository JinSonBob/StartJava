package com.startjava.lesson_2.method.naming;

public class Methods {
    public static String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}