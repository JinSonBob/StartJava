import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String answer = "yes";

        while (answer.equals("yes")) {
            System.out.print("Введите первое число: ");
            calc.setFirstNum(scanner.nextLong());
            System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
            calc.setOperator(scanner.next().charAt(0));
            System.out.print("Введите второе число: ");
            calc.setSecondNum(scanner.nextLong());

            System.out.printf("Результат: %f%n", calc.calculate());

            answer = "";

            while (!answer.equals("no") && !answer.equals("yes")) {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                answer = scanner.next();
                
                if (!answer.equals("no") && !answer.equals("yes")) {
                    System.out.println("Ошибка: неправильный ввод");
                }
            }
        }
    }
}