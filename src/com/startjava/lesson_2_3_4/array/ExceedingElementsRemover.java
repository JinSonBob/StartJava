package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class ExceedingElementsRemover {
    static void main() {
        float[] nums = fill();
        float[] filteredNums;
        int[] indices = new int[]{-1, 15, 0, 14};

        for (int targetIndex : indices) {
            filteredNums = removeExceeding(nums, targetIndex);
            printComparison(nums, filteredNums, targetIndex);
            System.out.println();
        }
    }

    private static float[] fill() {
        Random random = new Random();
        float[] nums = new float[15];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextFloat();
        }
        return nums;
    }

    private static float[] removeExceeding(float[] nums, int targetIndex) {
        if (!isValidIndex(targetIndex)) return null;

        float[] filteredNums = Arrays.copyOf(nums, nums.length);
        float targetNum = nums[targetIndex];

        for (int i = 0; i < filteredNums.length; i++) {
            if (filteredNums[i] > targetNum) filteredNums[i] = 0f;
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

    private static void printComparison(float[] nums, float[] filteredNums, int targetIndex) {
        if (nums == null || filteredNums == null) return;

        System.out.println("\nИсходный массив: ");
        printInRows(nums);

        System.out.println("\nИзменённый массив: ");
        printInRows(filteredNums);

        System.out.printf("%nЗначение ячейки по переданному индексу %d: %.3f",
                targetIndex, nums[targetIndex]);
    }

    private static void printInRows(float[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%.3f ", nums[i]);
            if (i == 7) System.out.println();
        }
    }
}
