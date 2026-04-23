package com.startjava.lesson_2_3_4.array;

public class Factorial {
    static void main() {
        int[] numbers1 = new int[]{};
        if (isValidInput(numbers1)) {
            long[] results1 = getFactorials(numbers1);
            printFactorials(numbers1, results1);
        }
        System.out.println();

        int[] numbers2 = null;
        if (isValidInput(numbers2)) {
            long[] results2 = getFactorials(numbers2);
            printFactorials(numbers2, results2);
        }
        System.out.println();

        int[] numbers3 = new int[]{-5};
        if (isValidInput(numbers3)) {
            long[] results3 = getFactorials(numbers3);
            printFactorials(numbers3, results3);
        }
        System.out.println();

        int[] numbers4 = new int[]{7, 0, 21};
        if (isValidInput(numbers4)) {
            long[] results4 = getFactorials(numbers4);
            printFactorials(numbers4, results4);
        }
        System.out.println();

        int[] numbers5 = new int[]{1, 20, 5, -3};
        if (isValidInput(numbers5)) {
            long[] results5 = getFactorials(numbers5);
            printFactorials(numbers5, results5);
        }
        System.out.println();
    }

    private static boolean isValidInput(int... input) {
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

    private static long[] getFactorials(int... numbers) {
        long[] results = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            results[i] = isValidNum(numbers[i]) ? calculate(numbers[i]) : -1;
        }
        return results;
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

    private static void printFactorials(int[] numbers, long[] results) {
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
            for (int i = 1; i <= num; i++) {
                expression.append(i);
                if (i != num) expression.append(" * ");
            }
            expression.append(" = ").append(result);
        }
        return expression;
    }
}
