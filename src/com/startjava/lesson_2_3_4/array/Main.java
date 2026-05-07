package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class Main {
    static void main() throws InterruptedException {
        reverseTransactions();
        calculateFactorials();
        removeExceedingElements();
        buildCharactersTriangle();
        generateUniqueNums();
        crackPassword();
        typewrite();
    }

    private static void reverseTransactions() {
        int[][] testTransactions = {
                {},
                null,
                {5},
                {6, 8, 9, 1},
                {13, 8, 5, 3, 2, 1, 1}
        };

        for (int[] transactions : testTransactions) {
            int[] reversedTransactions = Arrays.reverse(transactions);

            if (reversedTransactions != null) {
                Console.printText("Исходные транзакции: ");
                Console.printIntArray(transactions);
                Console.printBlankLine();

                Console.printText(" В обратном порядке: ");
                Console.printIntArray(reversedTransactions);
                Console.printBlankLine();
            }
            Console.printBlankLine();
        }
    }

    private static void calculateFactorials() {
        int[][] testNums = {
                {},
                null,
                {-5}, {7, 0, 21},
                {1, 20, 5, -3}
        };

        for (int[] nums : testNums) {
            long[] results = Arrays.calculateFactorials(nums);

            if (results != null) {
                Console.printFactorialExpression(nums, results);
            }
            Console.printBlankLine();
        }
    }

    private static void removeExceedingElements() {
        int[] indices = {-1, 15, 0, 14};

        Random random = new Random();
        float[] originalNums = new float[15];

        for (int i = 0; i < originalNums.length; i++) {
            originalNums[i] = random.nextFloat();
        }

        for (int thresholdIndex : indices) {
            float[] filteredNums = Arrays.resetValuesAboveThreshold(originalNums, thresholdIndex);

            if (filteredNums != null) {
                Console.printNewLineText("Исходный массив: ");
                Console.printFloatArrayInRows(originalNums, 8);
                Console.printBlankLine();

                Console.printNewLineText("Изменённый массив: ");
                Console.printFloatArrayInRows(filteredNums, 8);
                Console.printBlankLine();

                Console.printFormattedFloat("Значение ячейки по переданному индексу:",
                        originalNums[thresholdIndex]);
            }
            Console.printBlankLine();
        }
    }

    private static void buildCharactersTriangle() {
        String triangle = Arrays.buildCharactersTriangle('0', '9', true);
        if (triangle != null) Console.printText(triangle);
        Console.printBlankLine();

        triangle = Arrays.buildCharactersTriangle('/', '!', true);
        if (triangle != null) Console.printText(triangle);
        Console.printBlankLine();

        triangle = Arrays.buildCharactersTriangle('A', 'J', true);
        if (triangle != null) Console.printText(triangle);
        Console.printBlankLine();
    }

    private static void generateUniqueNums() {
        int[][] testNums = {
                {-30, -10, 23},
                {10, 50, 10},
                {-34, -34, 1},
                {-1, 2, -3},
                {5, -8, 2}
        };

        for (int[] nums : testNums) {
            int[] uniqueNums = Arrays.generateUniqueNums(nums[0], nums[1]);

            if (uniqueNums != null) {
                Console.printIntArrayInRows(uniqueNums, nums[2]);
            }
            Console.printBlankLine();
        }
    }

    private static void crackPassword() throws InterruptedException {
        char[][] passwords = {
                "123456".toCharArray(),
                Arrays.generatePassword(),
                Arrays.generatePassword(),
                Arrays.generatePassword()
        };

        for (char[] password : passwords) {
            if (password == null || password.length == 0) {
                Console.printError("Пароль не может быть пустым");
                continue;
            }

            Console.showSpinner();

            boolean isStrong = Arrays.isStrongPassword(password);
            String strengthColor = isStrong ? Console.RED_COLOR : Console.GREEN_COLOR;

            if (isStrong) {
                Console.printColoredText("✗ Strong password: " + String.valueOf(password), strengthColor);
            } else {
                Console.printColoredText("✓ Password cracked: " + String.valueOf(password), strengthColor);
            }
            Console.printBlankLine();
        }
    }

    private static void typewrite() throws InterruptedException {
        String[] texts = {
                """
                Java - это C++, из которого убрали все пистолеты, ножи и дубинки.
                - James Gosling""",
                """
                Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.
                - Robert Martin""",
                null,
                ""
        };

        for (String text : texts) {
            if (text == null || text.isBlank()) {
                Console.printError("Введена пустая строка");
                Console.printBlankLine();
                continue;
            }

            String finalText = Arrays.minMaxWordRangeToUpperCase(text);
            Console.typeText(finalText);
            Console.printBlankLine();
            Console.printBlankLine();
        }
    }
}
