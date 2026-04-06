public class Wolf {
    String sex;
    String name;
    float weight;
    int age;
    String furColor;

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

    String howl() {
        System.out.println("Воет");
        return "Ауууууу";
    }

    boolean hunt() {
        System.out.println("Охотится");
        return true;
    }
}