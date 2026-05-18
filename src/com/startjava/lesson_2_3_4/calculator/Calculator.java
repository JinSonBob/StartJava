package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int EXPRESSION_LENGTH = 3;

    private Calculator() {}

    public static double start(String expression) {
        String[] expressionParts = expression.trim().replaceAll("\\s+", " ").split(" ");

        if (expressionParts.length != EXPRESSION_LENGTH) {
            throw new IllegalArgumentException("Ошибка: неверная длина выражения (" +
                    expressionParts.length + ") вместо 3");
        }

        int firstNum;
        int secondNum;
        try {
            firstNum = Integer.parseInt(expressionParts[0]);
            secondNum = Integer.parseInt(expressionParts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ошибка: вводимые числа должны быть целыми");
        }

        String operatorString = expressionParts[1];

        if (operatorString.length() != 1) {
            throw new UnsupportedOperationException("Ошибка: операция '" +
                    operatorString + "' не поддерживается");
        }
        char operator = operatorString.charAt(0);

        return calculate(firstNum, operator, secondNum);
    }

    private static double calculate(int firstNum, char operator, int secondNum) {
        return switch (operator) {
            case '+' -> firstNum + secondNum;
            case '-' -> firstNum - secondNum;
            case '*' -> firstNum * secondNum;
            case '/', '%' -> {
                if (secondNum == 0) {
                    throw new ArithmeticException("Ошибка: деление на ноль");
                }
                if (operator == '/') {
                    yield (double) firstNum / secondNum;
                }
                yield Math.floorMod(firstNum, secondNum);
            }
            case '^' -> Math.pow(firstNum, secondNum);
            default -> throw new UnsupportedOperationException("Ошибка: операция '" +
                    operator + "' не поддерживается");
        };
    }
}