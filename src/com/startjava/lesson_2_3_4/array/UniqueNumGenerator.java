package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumGenerator {
    static void main() {
        int[] uniqueNums = generateUniqueNums(-30, -10);
        printNumsInRows(uniqueNums, 23);
        System.out.println();

        uniqueNums = generateUniqueNums(10, 50);
        printNumsInRows(uniqueNums, 10);
        System.out.println();

        uniqueNums = generateUniqueNums(-34, -34);
        printNumsInRows(uniqueNums, 1);
        System.out.println();

        uniqueNums = generateUniqueNums(-1, 2);
        printNumsInRows(uniqueNums, -3);
        System.out.println();

        uniqueNums = generateUniqueNums(5, -8);
        printNumsInRows(uniqueNums, 2);
        System.out.println();
    }

    private static int[] generateUniqueNums(int leftBorder, int rightBorder) {
        int length = (int) ((rightBorder - leftBorder + 1) * 0.75);
        if (!isValidRange(leftBorder, rightBorder, length)) return null;

        int[] uniqueNums = new int[length];
        Random random = new Random();

        int addedCount = 0;
        while (addedCount < length) {
            int currNum = random.nextInt(leftBorder, rightBorder + 1);

            if (hasNum(uniqueNums, currNum, addedCount)) {
                uniqueNums[addedCount] = currNum;
                addedCount++;
            }
        }
        Arrays.sort(uniqueNums);
        return uniqueNums;
    }

    private static boolean isValidRange(int leftBorder, int rightBorder, int length) {
        if (leftBorder > rightBorder) {
            System.out.printf("%nОшибка: левая граница (%d) > правой (%d)", leftBorder, rightBorder);
            return false;
        }
        if (length <= 0) {
            System.out.printf("%nОшибка: длина массива должна быть > 0 (%d)", length);
            return false;
        }
        return true;
    }

    private static boolean hasNum(int[] nums, int currNum, int addedCount) {
        for (int i = 0; i < addedCount; i++) {
            if (nums[i] == currNum) return false;
        }
        return true;
    }

    private static void printNumsInRows(int[] uniqueNums, int rowLength) {
        if (!isValidRowLength(rowLength) || uniqueNums == null) return;

        StringBuilder uniqueNumsString = new StringBuilder();

        for (int i = 0; i < uniqueNums.length; i++) {
            uniqueNumsString.append(uniqueNums[i]);
            uniqueNumsString.append(" ");

            if ((i + 1) % rowLength == 0 && i != uniqueNums.length - 1) {
                uniqueNumsString.append("\n");
            }
        }

        System.out.println(uniqueNumsString);
    }

    private static boolean isValidRowLength(int rowLength) {
        if (rowLength < 1) {
            System.out.printf("%nОшибка: количество чисел в строке не должно быть < 1 (%d)", rowLength);
            return false;
        }
        return true;
    }
}
