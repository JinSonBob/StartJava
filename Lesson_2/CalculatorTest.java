import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String input = "yes";

        while (input.equals("yes")) {
            System.out.print("Введите первое число: ");
            calc.setFirstNum(scanner.nextLong());
            System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
            calc.setOperator(scanner.next().charAt(0));
            System.out.print("Введите второе число: ");
            calc.setSecondNum(scanner.nextLong());

            System.out.printf("Результат: %f%n", calc.calculate());

            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            input = scanner.next();

            while (!input.equals("no") && !input.equals("yes")) {
                System.out.println("Ошибка: неправильный ввод. Введите [yes/no]: ");
                input = scanner.next();
            }
        }
    }
}