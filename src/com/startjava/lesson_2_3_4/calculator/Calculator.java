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
        switch (operator) {
            case '+':
                return firstNum + secondNum;
            case '-':
                return firstNum - secondNum;
            case '*':
                return firstNum * secondNum;
            case '/':
                if (secondNum != 0) {
                    return (double) firstNum / secondNum;
                }
                System.out.println("Ошибка: деление на ноль запрещено");
                return Double.NaN;
            case '^':
                return Math.pow(firstNum, secondNum);
            case '%':
                if (secondNum != 0) {
                    return Math.floorMod(firstNum, secondNum);
                }
                System.out.println("Ошибка: деление по модулю на ноль");
                return Double.NaN;
            default:
                System.out.println("Ошибка: неверный оператор");
                return Double.NaN;
        }
    }
}