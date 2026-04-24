package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class ExceedingElementsRemover {
    static void main() {
        float[] originalArray = fillArray();
        float[] processedArray;
        int[] indices = new int[]{-1, 15, 0, 14};

        for (int index : indices) {
            processedArray = removeExceeding(originalArray, index);
            printResult(originalArray, processedArray, index);
            System.out.println();
        }
    }

    private static float[] fillArray() {
        Random random = new Random();
        float[] array = new float[15];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextFloat();
        }
        return array;
    }

    private static float[] removeExceeding(float[] array, int minNumIndex) {
        if (!isValidIndex(minNumIndex)) return null;

        float[] arrayCopy = Arrays.copyOf(array, array.length);
        float minNum = array[minNumIndex];

        for (int i = 0; i < arrayCopy.length; i++) {
            if (arrayCopy[i] > minNum) arrayCopy[i] = 0f;
        }
        return arrayCopy;
    }

    private static boolean isValidIndex(int index) {
        if (index < 0 || index > 14) {
            System.out.printf("%nОшибка: указан несуществующий индекс (%d). Допустимо: 0 <= индекс <= 14",
                    index);
            return false;
        }
        return true;
    }

    private static void printResult(float[] originalArray, float[] processedArray, int index) {
        if (originalArray == null || processedArray == null) return;

        System.out.println("\nИсходный массив: ");
        printInRows(originalArray);

        System.out.println("\nИзменённый массив: ");
        printInRows(processedArray);

        System.out.printf("%nЗначение ячейки по переданному индексу %d: %.3f", index, originalArray[index]);
    }

    private static void printInRows(float[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.3f ", array[i]);
            if (i == 7) System.out.println();
        }
    }
}
