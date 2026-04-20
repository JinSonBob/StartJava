package com.startjava.lesson_2_3.calculator;

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

            answer = checkAnswer(scanner);
        }
    }

    private static String checkAnswer(Scanner scanner) {
        String answer;

        do {
            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            answer = scanner.next();
        } while (!answer.equals("no") && !answer.equals("yes"));

        return answer;
    }
}