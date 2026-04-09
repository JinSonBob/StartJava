import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator main = new Calculator();
        Scanner scanner = new Scanner(System.in);
        boolean isContinue = true;

        while (isContinue) {
            System.out.print("Введите первое число: ");
            main.setFirstNum(scanner.nextLong());
            System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
            main.setOperator(scanner.next().charAt(0));
            System.out.print("Введите второе число: ");
            main.setSecondNum(scanner.nextLong());

            System.out.printf("Результат: %f%n", main.calculate());

            boolean isValidInput = false;

            while (!isValidInput) {
                System.out.print("Хотите продолжить вычисления? [yes/no]:");

                switch (scanner.next()) {
                    case "no":
                        isContinue = false;
                        isValidInput = true;
                        break;
                    case "yes":
                        isContinue = true;
                        isValidInput = true;
                        break;
                    default:
                        System.out.println("Ошибка: неправильный ввод");
                }
            }
        }
    }
}