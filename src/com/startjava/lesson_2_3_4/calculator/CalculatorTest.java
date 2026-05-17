package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class CalculatorTest {
    static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String answer = "yes";

        while (!answer.equals("no")) {
            if (answer.equals("yes")) {
                System.out.print("Введите выражение из трех аргументов: ");
                String expression = scanner.nextLine();

                double result = calculator.start(expression);
                printResult(expression, result);

                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
            answer = scanner.nextLine().toLowerCase();
        }
    }

    private static void printResult(String expression, double result) {
        if (!Double.isNaN(result)) {
            DecimalFormatSymbols separator = new DecimalFormatSymbols();
            separator.setDecimalSeparator(',');
            DecimalFormat resultFormat = new DecimalFormat("#.###", separator);

            System.out.printf("%s = %s%n", expression, resultFormat.format(result));
        }
    }
}