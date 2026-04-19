package com.startjava.lesson_1.final_;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    public static void main(String[] args) {
        var firstNum = BigDecimal.valueOf(100000);
        var secondNum = BigDecimal.valueOf(15);
        char operation = '/';
        var result = BigDecimal.ZERO;

        if (operation == '+') {
            result = firstNum.add(secondNum);
        } else if (operation == '-') {
            result = firstNum.subtract(secondNum);
        } else if (operation == '*') {
            result = firstNum.multiply(secondNum);
        } else if (operation == '/') {
            result = firstNum.divide(secondNum, 2, java.math.RoundingMode.HALF_UP);
        } else if (operation == '%') {
            result = firstNum.remainder(secondNum);
        } else if (operation == '^') {
            result = BigDecimal.ONE;
            for (int i = 0; i < secondNum.intValue(); i++) {
                result = result.multiply(firstNum);
            }
        }

        System.out.printf("%s %s %s = %s", firstNum, operation, secondNum, result);
    }
}