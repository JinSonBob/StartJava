package com.startjava.lesson_2.animal;

public class WolfTest {
    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();
        wolfOne.setSex("Кабель");
        wolfOne.setName("Умка");
        wolfOne.setWeight(30.7f);
        wolfOne.setAge(7);
        wolfOne.setFurColor("Серый");

        System.out.printf("""
                Пол: %s
                Имя: %s
                Вес: %.1f
                Возраст: %d
                Окрас: %s%n""", wolfOne.getSex(), wolfOne.getName(), wolfOne.getWeight(),
                        wolfOne.getAge(), wolfOne.getFurColor());

        wolfOne.walk();
        wolfOne.sit();
        wolfOne.sprint();
        wolfOne.howl();
        wolfOne.hunt();
    }
}