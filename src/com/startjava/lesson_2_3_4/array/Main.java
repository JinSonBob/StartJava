package com.startjava.lesson_2_3_4.array;

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
                Console.printTextWithIntArray("Исходные транзакции: ", transactions);
                Console.println();

                Console.printTextWithIntArray(" В обратном порядке: ", reversedTransactions);
                Console.println();
            }
            Console.println();
        }
    }

    private static void calculateFactorials() {
        int[][] testNums = {
                {},
                null,
                {-5},
                {7, 0, 21},
                {1, 20, 5, -3}
        };

        for (int[] nums : testNums) {
            long[] factorials = Arrays.calculateFactorials(nums);

            if (factorials != null) {
                Console.printFactorialExpression(nums, factorials);
            }
            Console.println();
        }
    }

    private static void removeExceedingElements() {
        int[] indices = {-1, 15, 0, 14};
        float[] testNums = Arrays.generateRandomFloatArray(15);

        for (int thresholdIndex : indices) {
            float[] filteredNums = Arrays.resetAboveThresholdValues(testNums, thresholdIndex);

            if (filteredNums != null) {
                Console.println("Исходный массив: ");
                Console.printInRows(testNums, 8);
                Console.println();

                Console.println("Изменённый массив: ");
                Console.printInRows(filteredNums, 8);
                Console.println();

                Console.printf("%s %.3f%n", "Значение ячейки по переданному индексу:",
                        testNums[thresholdIndex]);
            }
            Console.println();
        }
    }

    private static void buildCharactersTriangle() {
        String triangle = Arrays.generateCharactersTriangle('0', '9', true);
        if (triangle != null) Console.print(triangle);
        Console.println();

        triangle = Arrays.generateCharactersTriangle('/', '!', true);
        if (triangle != null) Console.print(triangle);
        Console.println();

        triangle = Arrays.generateCharactersTriangle('A', 'J', true);
        if (triangle != null) Console.print(triangle);
        Console.println();
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
                Console.printInRows(uniqueNums, nums[2]);
            }
            Console.println();
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

            Console.printWithSpinner("Cracking password: ");

            boolean isStrong = Arrays.isStrongPassword(password);
            String strengthColor = isStrong ? Console.RED_COLOR : Console.GREEN_COLOR;

            if (isStrong) {
                Console.printColored("✗ Strong password: " + String.valueOf(password), strengthColor);
            } else {
                Console.printColored("✓ Password cracked: " + String.valueOf(password), strengthColor);
            }
            Console.println();
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
                Console.println();
                continue;
            }

            String finalText = Arrays.upperCaseBetweenMinMaxWords(text);
            Console.printTypingText(finalText);
            Console.println();
            Console.println();
        }
    }
}
