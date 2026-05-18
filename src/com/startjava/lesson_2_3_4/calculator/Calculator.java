package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int EXPRESSION_PARTS_COUNT = 3;

    private Calculator() {}

    public static double calculate(String expression) {
        String[] expressionParts = expression.trim().replaceAll("\\s+", " ").split(" ");

        if (expressionParts.length != EXPRESSION_PARTS_COUNT) {
            throw new IllegalArgumentException("Ошибка: выражение должно состоять из трех частей: " +
                    "число операция число");
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

        return evaluate(firstNum, operator, secondNum);
    }

    private static double evaluate(int firstNum, char operator, int secondNum) {
        return switch (operator) {
            case '+' -> firstNum + secondNum;
            case '-' -> firstNum - secondNum;
            case '*' -> firstNum * secondNum;
            case '/', '%' -> divide(firstNum, operator, secondNum);
            case '^' -> Math.pow(firstNum, secondNum);
            default -> throw new UnsupportedOperationException("Ошибка: операция '" +
                    operator + "' не поддерживается");
        };
    }

    private static double divide(int firstNum, char operator, int secondNum) {
        if (secondNum == 0) {
            throw new ArithmeticException("Ошибка: деление на ноль");
        }
        if (operator == '/') {
            return (double) firstNum / secondNum;
        }
        return Math.floorMod(firstNum, secondNum);
    }
}