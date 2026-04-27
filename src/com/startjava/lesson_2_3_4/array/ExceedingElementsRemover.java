package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class ExceedingElementsRemover {
    static void main() {
        int[] indices = {-1, 15, 0, 14};

        for (int thresholdIndex : indices) {
            float[] originalNums = generateRandomFloats();
            float[] filteredNums = resetValuesAboveThreshold(originalNums, thresholdIndex);
            printArraysWithThresholdValue(originalNums, filteredNums, thresholdIndex);
            System.out.println();
        }
    }

    private static float[] generateRandomFloats() {
        Random random = new Random();
        float[] nums = new float[15];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextFloat();
        }
        return nums;
    }

    private static float[] resetValuesAboveThreshold(float[] originalNums, int thresholdIndex) {
        if (!isValidIndex(thresholdIndex)) return null;

        float[] filteredNums = Arrays.copyOf(originalNums, originalNums.length);
        float thresholdNum = originalNums[thresholdIndex];

        for (int i = 0; i < filteredNums.length; i++) {
            if (filteredNums[i] > thresholdNum) filteredNums[i] = 0f;
        }
        return filteredNums;
    }

    private static boolean isValidIndex(int index) {
        if (index < 0 || index > 14) {
            System.out.printf("%nОшибка: указан несуществующий индекс (%d). Допустимо: 0 <= индекс <= 14",
                    index);
            return false;
        }
        return true;
    }

    private static void printArraysWithThresholdValue(float[] originalNums,
                                                      float[] filteredNums, int thresholdIndex) {
        if (originalNums == null || filteredNums == null) return;

        System.out.println("\nИсходный массив: ");
        printInRows(originalNums);

        System.out.println("\nИзменённый массив: ");
        printInRows(filteredNums);

        System.out.printf("%nЗначение ячейки по переданному индексу %d: %.3f",
                thresholdIndex, originalNums[thresholdIndex]);
    }

    private static void printInRows(float[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%.3f ", nums[i]);
            if (i == 7) System.out.println();
        }
    }
}
