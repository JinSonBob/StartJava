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

    private static void printFactorial(int... numbers) {
        if (!isValidInput(numbers)) return;
        long[] results = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (isValidNum(numbers[i])) {
                results[i] = calculate(numbers[i]);
            } else {
                results[i] = -1;
            }
        }
        printExpression(numbers, results);
    }

    private static boolean isValidInput(int[] input) {
        if (input == null) {
            System.out.println("Ошибка данных: данные типа null");
            return false;
        }

        if (input.length == 0) {
            System.out.println("Нет чисел: длинна массива = 0");
            return false;
        }
        return true;
    }

    private static boolean isValidNum(int num) {
        if (num > 20) {
            System.out.printf("Ошибка: факториал %d слишком велик (максимум 20!)%n", num);
            return false;
        } else if (num < 0) {
            System.out.printf("Ошибка: факториал %d не определен%n", num);
            return false;
        }
        return true;
    }

    private static long calculate(int num) {
        long result = 1;

        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    private static void printExpression(int[] numbers, long[] results) {
        for (int i = 0; i < numbers.length; i++) {
            if (results[i] != -1) {
                System.out.println(buildExpression(numbers[i], results[i]));
            }
        }
    }

    private static StringBuilder buildExpression(int num, long result) {
        StringBuilder expression = new StringBuilder().append(num);
        expression.append("! = ");

        if (num == 0 || num == 1) {
            expression.append("1");
        } else {
            for (int i = 1; i < num; i++) {
                expression.append(i).append(" * ");
            }
            expression.append(" = ").append(result);
        }
        return expression;
    }
}
