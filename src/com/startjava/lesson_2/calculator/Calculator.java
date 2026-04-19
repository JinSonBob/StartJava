package com.startjava.lesson_2.calculator;

public class Calculator {
    private long firstNum;
    private long secondNum;
    private char operator;

    public void setFirstNum(long firstNum) {
        this.firstNum = firstNum;
    }

    public void setSecondNum(long secondNum) {
        this.secondNum = secondNum;
    }

    public void setOperator(char operator) {
        switch (operator) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '%':
                this.operator = operator;
                break;
            default:
                System.out.printf("Ошибка: операция '%c' не поддерживается%n", operator);
                break;
        }
    }

    public double calculate() {
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
                } else {
                    System.out.println("Ошибка: деление на ноль запрещено");
                    return 0;
                }
            case '^':
                return Math.pow(firstNum, secondNum);
            case '%':
                if (secondNum != 0) {
                    return firstNum % secondNum;
                } else {
                    System.out.println("Ошибка: деление по модулю на ноль");
                    return 0;
                }
            default:
                return 0;
        }
    }
}