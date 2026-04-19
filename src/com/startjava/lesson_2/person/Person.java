package com.startjava.lesson_2.person;

public class Person {
    String sex = "Мужчина";
    String firstName = "Александр";
    float height = 169.1f;
    float weight = 72.2f;
    int age = 19;

    void walk() {
        System.out.println("Прошёл 1 метр");
    }

    boolean sit() {
        System.out.println("Сел");
        return true;
    }

    void sprint() {
        System.out.println("Пробежал 10 метров");
    }

    String speak() {
        System.out.println("Что-то сказал");
        return "Что-то";
    }

    boolean learnJava() {
        System.out.println("Учит Java");
        return true;
    }
}