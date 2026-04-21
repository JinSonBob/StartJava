package com.startjava.lesson_2_3_4.array;

public class Factorial {
    static void main() {
        printFactorial();
        System.out.println();
        printFactorial(null);
        System.out.println();
        printFactorial(-5);
        System.out.println();
        printFactorial(7, 0, 21);
        System.out.println();
        printFactorial(1, 20, 5, -3);
    }

    private static void printFactorial(int... args) {
        if (args == null) {
            System.out.println("Ошибка данных: данные типа null");
            return;
        }

        int arrLength = args.length;

        if (arrLength == 0) {
            System.out.println("Нет чисел: длинна массива = 0");
            return;
        }

        for (int arg : args) {
            if (arg > 20) {
                System.out.printf("Ошибка: факториал %d слишком велик (максимум 20!)%n", arg);
                return;
            } else if (arg < 0) {
                System.out.printf("Ошибка: факториал %d не определен%n", arg);
                return;
            }

            System.out.println(buildExpression(arg));
        }
    }

    private static StringBuilder buildExpression(int arg) {
        StringBuilder expression = new StringBuilder("1");

        long result = 1;

        for (int i = 2; i <= arg; i++) {
            result *= i;
            expression.append(" * ").append(i);
        }

        StringBuilder output = new StringBuilder().append(arg);

        return arg <= 1
                ? output.append("! = 1")
                : output.append("! = ").append(expression).append(" = ").append(result);
    }
}
