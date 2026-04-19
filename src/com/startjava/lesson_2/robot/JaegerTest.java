package com.startjava.lesson_2.robot;

public class JaegerTest {
    public static void main(String[] args) {
        final Jaeger firstJaeger = new Jaeger("Cherno Alpha", "Mark-1", "Russia", "Destroyed", 10, 3);
        Jaeger secondJaeger = new Jaeger();

        secondJaeger.setModelName("Striker Eureka");
        secondJaeger.setMark("Mark-5");
        secondJaeger.setOrigin("Australia");
        secondJaeger.setStatus("Destroyed");
        secondJaeger.setStrength(10);
        secondJaeger.setSpeed(10);

        if (firstJaeger.getModelName() == secondJaeger.getModelName()) {
            System.out.printf("%nИмя егерей одинаковы: %s",
                    firstJaeger.getModelName());
        } else {
            System.out.printf("%nИмя егерей разные: %s и %s",
                    firstJaeger.getModelName(), secondJaeger.getModelName());
        }

        if (firstJaeger.getMark() == secondJaeger.getMark()) {
            System.out.printf("%nПоколения егерей одинаковы: %s",
                    firstJaeger.getMark());
        } else {
            System.out.printf("%nПоколения егерей разные: %s и %s",
                    firstJaeger.getMark(), secondJaeger.getMark());
        }

        if (firstJaeger.getOrigin() == secondJaeger.getOrigin()) {
            System.out.printf("%nСтраны происхождения егерей одинаковы: %s",
                    firstJaeger.getOrigin());
        } else {
            System.out.printf("%nСтраны происхождения егерей разные: %s и %s",
                    firstJaeger.getOrigin(), secondJaeger.getOrigin());
        }

        if (firstJaeger.getStatus() == secondJaeger.getStatus()) {
            System.out.printf("%nСтатусы егерей одинаковы: %s",
                    firstJaeger.getStatus());
        } else {
            System.out.printf("%nСтатусы егерей разные: %s и %s",
                    firstJaeger.getStatus(), secondJaeger.getStatus());
        }

        if (firstJaeger.getStrength() == secondJaeger.getStrength()) {
            System.out.printf("%nСила егерей одинакова: %s",
                    firstJaeger.getStrength());
        } else {
            System.out.printf("%nСила егерей разная: %s и %s",
                    firstJaeger.getStrength(), secondJaeger.getStrength());
        }

        if (firstJaeger.getSpeed() == secondJaeger.getSpeed()) {
            System.out.printf("%nСкорость егерей одинакова: %s",
                    firstJaeger.getSpeed());
        } else {
            System.out.printf("%nСкорость егерей разная: %s и %s",
                    firstJaeger.getSpeed(), secondJaeger.getSpeed());
        }
    }
}