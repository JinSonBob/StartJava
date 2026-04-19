package com.startjava.lesson_1.base;

import java.util.Random;

public class CyclesTheme {
    public static void main(String[] args) {
        // 1.ВЫВОД ASCII-СИМВОЛОВ
        System.out.println("\n1.ВЫВОД ASCII-СИМВОЛОВ");

        System.out.printf("%-10s%-12s%s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");

        for (int i = 33; i <= 'z'; i += 1) {
            if ((i < '0' && i % 2 != 0) || (i >= 'a' && i <= 'z' && i % 2 == 0)) {
                System.out.printf("%4d          %-13c%s%n", i, i, Character.getName(i));
            }
        }

        // 2.ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР
        System.out.println("\n2.ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР");

        for (int i = 0; i <= 4; i++) {
            System.out.print("\n---------- ");

            for (int j = (4 - i); j >= 0; j--) {
                System.out.print("*");
            }

            System.out.print(" ");

            for (int j = 1; j <= i * 2 + 1; j++) {
                System.out.print("^");
            }
        }

        // 3.ВЫВОД ТАБЛИЦЫ УМНОЖЕНИЯ
        System.out.println("\n\n3.ВЫВОД ТАБЛИЦЫ УМНОЖЕНИЯ");

        System.out.println("""
                  |  2  3  4  5  6  7  8  9
                --+------------------------""");

        for (int i = 2; i <= 9; i++) {
            System.out.printf("%d |", i);

            for (int j = 2; j <= 9; j++) {
                System.out.printf("%3d", i * j);
            }

            System.out.println();
        }

        // 4.ВЫВОД ЧИСЕЛ В НЕСКОЛЬКО СТРОК
        System.out.println("\n4.ВЫВОД ЧИСЕЛ В НЕСКОЛЬКО СТРОК");

        int startNum = 1;
        int endNum = 24;
        int perLineNum = 5;

        int currNum = startNum % 2 == 0 ? startNum + 1 : startNum;

        for (int i = 1; currNum < endNum || i % perLineNum != 1; i++) {
            if (currNum < endNum) {
                System.out.printf("%3d", currNum);
                currNum += 2;
            } else {
                System.out.printf("%3d", 0);
            }

            if (i % perLineNum == 0) {
                System.out.println();
            }
        }

        // 5.ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX
        System.out.println("\n5.ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX");

        int firstNum = 10;
        int secondNum = 5;
        int thirdNum = -1;

        int max = firstNum;
        if (secondNum > max) max = secondNum;
        if (thirdNum > max) max = thirdNum;

        int min = firstNum;
        if (secondNum < min) min = secondNum;
        if (thirdNum < min) min = thirdNum;

        for (int i = min + 1; i < max; i++) {
            System.out.print(i + " ");
        }

        // 6.РАЗНЫЕ ОПЕРАЦИИ НАД ЧИСЛОМ
        System.out.println("\n\n6.РАЗНЫЕ ОПЕРАЦИИ НАД ЧИСЛОМ");

        int originNum = 2234321;
        int originNumCopy = originNum;
        int reverseNum = 0;
        int twoCount = 0;

        while (originNumCopy > 0) {
            reverseNum = reverseNum * 10 + originNumCopy % 10;

            if (originNumCopy % 10 == 2) {
                twoCount++;
            }

            originNumCopy /= 10;
        }
        System.out.println("Число в обратном порядке: " + reverseNum);
        System.out.printf("%d - %s с %s (%d) количеством двоек", originNum, 
                originNum == reverseNum ? "палиндром" : "не палиндром",
                twoCount % 2 == 0 ? "четным" : "нечетным",
                twoCount);

        // 7.ПРОВЕРКА СЧАСТЛИВОГО ЧИСЛА
        System.out.println("\n\n7.ПРОВЕРКА СЧАСТЛИВОГО ЧИСЛА");

        int luckyNum = 100002;
        int rightHalf = luckyNum % 1000;
        int leftHalf = luckyNum / 1000;
        int rightHalfSum = 0;
        int leftHalfSum = 0;

        for (int i = 0; i < 3; i++) {
            rightHalfSum += rightHalf % 10;
            rightHalf /= 10;
            leftHalfSum += leftHalf % 10;
            leftHalf /= 10;
        }
        
        System.out.printf("""
                %d - %s число
                Сумма цифр %03d = %d
                Сумма цифр %03d = %d""", luckyNum,
                rightHalfSum == leftHalfSum ? "счастливое" : "несчастливое",
                luckyNum % 1000, rightHalfSum, luckyNum / 1000, leftHalfSum);

        // 8.ПРОСТОЙ ГЕНЕРАТОР ПАРОЛЯ
        System.out.println("\n\n8.ПРОСТОЙ ГЕНЕРАТОР ПАРОЛЯ");

        int passLength = 8;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecChar = false;
        Random random = new Random();

        System.out.print("Пароль: ");

        for (int i = 0; i < passLength; i++) {
            char symbol = (char) random.nextInt(33, 126);

            System.out.print(symbol);

            hasLowerCase = Character.isLowerCase(symbol) ? true : hasLowerCase;
            hasUpperCase = Character.isUpperCase(symbol) ? true : hasUpperCase;
            hasDigit = Character.isDigit(symbol) ? true : hasDigit;
            hasSpecChar = !Character.isLetterOrDigit(symbol) ? true : hasSpecChar;
        }

        System.out.printf("\nНадёжность: %s",
                (passLength >= 8 && hasLowerCase && hasUpperCase && hasSpecChar) ?
                "Надежный" : ((passLength >= 8 && hasUpperCase && hasDigit) ?
                "Средний" : "Слабый"));
    }
}