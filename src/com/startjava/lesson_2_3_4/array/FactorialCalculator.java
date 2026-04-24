package com.startjava.lesson_2_3_4.array;

public class FactorialCalculator {
    static void main() {
        int[] numbers = {};
        long[] factorials = calculateFactorials(numbers);
        printFactorials(numbers, factorials);
        System.out.println();

        numbers = null;
        factorials = calculateFactorials(numbers);
        printFactorials(numbers, factorials);
        System.out.println();

        numbers = new int[]{-5};
        factorials = calculateFactorials(numbers);
        printFactorials(numbers, factorials);
        System.out.println();

        numbers = new int[]{7, 0, 21};
        factorials = calculateFactorials(numbers);
        printFactorials(numbers, factorials);
        System.out.println();

        numbers = new int[]{1, 20, 5, -3};
        factorials = calculateFactorials(numbers);
        printFactorials(numbers, factorials);
        System.out.println();
    }

    private static long[] calculateFactorials(int... numbers) {
        if (!isValidInput(numbers)) return null;

        long[] factorials = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            factorials[i] = isValidNum(numbers[i]) ? calculate(numbers[i]) : -1;
        }
        return factorials;
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

    private static boolean isValidNum(int number) {
        if (number > 20) {
            System.out.printf("Ошибка: факториал %d слишком велик (максимум 20!)%n", number);
            return false;
        }
        if (number < 0) {
            System.out.printf("Ошибка: факториал %d не определен%n", number);
            return false;
        }
        return true;
    }

    private static long calculate(int number) {
        long result = 1;

        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    private static void printFactorials(int[] numbers, long[] factorials) {
        if (numbers == null || factorials == null) {
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (factorials[i] != -1) {
                System.out.println(buildExpression(numbers[i], factorials[i]));
            }
        }
    }

    private static StringBuilder buildExpression(int number, long factorial) {
        StringBuilder expression = new StringBuilder().append(number);
        expression.append("! = ");

        if (number == 0 || number == 1) {
            expression.append("1");
        } else {
            for (int i = 1; i <= number; i++) {
                expression.append(i);
                if (i != number) expression.append(" * ");
            }
            expression.append(" = ").append(factorial);
        }
        return expression;
    }
}
