package com.startjava.lesson_2.animal;

public class Wolf {
    private String sex;
    private String name;
    private float weight;
    private int age;
    private String furColor;

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setAge(int age) {
        if (age > 8) {
            System.out.println("Некорректный возраст");
        } else {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    public String getFurColor() {
        return furColor;
    }
    
    public void walk() {
        System.out.println("Прошёл 1 метр");
    }

    public boolean sit() {
        System.out.println("Сел");
        return true;
    }

    public void sprint() {
        System.out.println("Пробежал 10 метров");
    }

    public String howl() {
        System.out.println("Воет");
        return "Ауууууу";
    }

    public boolean hunt() {
        System.out.println("Охотится");
        return true;
    }
}