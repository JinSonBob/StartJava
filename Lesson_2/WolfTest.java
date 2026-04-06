public class WolfTest {
    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();
        wolfOne.sex = "Кабель";
        wolfOne.name = "Умка";
        wolfOne.weight = 30.7f;
        wolfOne.age = 7;
        wolfOne.furColor = "Серый";

        System.out.printf("""
                Пол: %s
                Имя: %s
                Вес: %.1f
                Возраст: %d
                Окрас: %s%n""", wolfOne.sex, wolfOne.name, wolfOne.weight,
                        wolfOne.age, wolfOne.furColor);

        wolfOne.walk();
        wolfOne.sit();
        wolfOne.sprint();
        wolfOne.howl();
        wolfOne.hunt();
    }
}