package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    public double start(String expression) {
        String[] expressionParts = expression.split(" ");
        int firstNum = Integer.parseInt(expressionParts[0]);
        int secondNum = Integer.parseInt(expressionParts[2]);
        char operator = expressionParts[1].charAt(0);

        return calculate(firstNum, operator, secondNum);
    }

    private double calculate(int firstNum, char operator, int secondNum) {
        if ((operator == '/' || operator == '%') && secondNum == 0) {
            System.out.print("Ошибка: деление на ноль");
            return Double.NaN;
        }

        switch (operator) {
            case '+':
                return firstNum + secondNum;
            case '-':
                return firstNum - secondNum;
            case '*':
                return firstNum * secondNum;
            case '/':
                return (double) firstNum / secondNum;
            case '^':
                return Math.pow(firstNum, secondNum);
            case '%':
                return Math.floorMod(firstNum, secondNum);
            default:
                System.out.printf("Ошибка: операция '%c' не поддерживается%n", operator);
                return Double.NaN;
        }
    }
}