package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class Arrays {
    private static final char[][] PASSWORD_BLACKLIST = {
            "array".toCharArray(),
            "qwerty".toCharArray(),
            "123456".toCharArray()};

    private Arrays() {}

    public static long[] calculateFactorials(int[] nums) {
        if (nums == null) {
            Console.printError("данные типа null");
            return null;
        }

        if (nums.length == 0) {
            Console.printError("длинна массива = 0");
            return null;
        }

        long[] factorials = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 20) {
                Console.printError("факториал " + num + " слишком велик (максимум 20!)");
                factorials[i] = -1;
            } else if (num < 0) {
                Console.printError("факториал " + num + " не определен");
                factorials[i] = -1;
            } else {
                factorials[i] = factorial(num);
            }
        }
        return factorials;
    }

    private static long factorial(int num) {
        if (num == 0 || num == 1) return 1;
        return num * factorial(num - 1);
    }

    public static String generateCharactersTriangle(char leftBorder, char rightBorder, boolean isAscending) {
        if (leftBorder > rightBorder) {
            Console.printError("левая граница (" + (int) leftBorder +
                    ") > правой (" + (int) rightBorder + ")");
            return null;
        }

        int height = rightBorder - leftBorder + 1;
        char[] triangleChars = new char[height];
        char currChar = isAscending ? leftBorder : rightBorder;

        for (int i = 0; i < height; i++) {
            triangleChars[i] = isAscending ? currChar++ : currChar--;
        }

        StringBuilder triangle = new StringBuilder();

        for (int i = 0; i < height; i++) {
            triangle.append(" ".repeat(height - 1 - i));
            triangle.append(String.valueOf(triangleChars[i]).repeat(i * 2 + 1));
            triangle.append("\n");
        }

        return triangle.toString();
    }

    public static char[] generatePassword() {
        Random random = new Random();
        int passwordLength = random.nextInt(6, 13);
        char[] password = new char[passwordLength];

        for (int i = 0; i < passwordLength; i++) {
            password[i] = (char) random.nextInt(33, 127);
        }
        return password;
    }

    public static float[] generateRandomFloatArray(int length) {
        Random random = new Random();
        float[] nums = new float[length];

        for (int i = 0; i < length; i++) {
            nums[i] = random.nextFloat();
        }
        return nums;
    }

    public static int[] generateUniqueNums(int leftBorder, int rightBorder) {
        if (leftBorder > rightBorder) {
            Console.printError("левая граница (" + leftBorder + ") > правой (" + rightBorder + ")");
            return null;
        }

        int length = (int) ((rightBorder - leftBorder + 1) * 0.75);
        if (length <= 0) {
            Console.printError("длина массива должна быть > 0 (" + length + ")");
            return null;
        }

        int[] uniqueNums = new int[length];
        Random random = new Random();
        int addedCount = 0;

        while (addedCount < length) {
            int currNum = random.nextInt(leftBorder, rightBorder + 1);
            boolean hasNum = false;

            for (int i = 0; i < addedCount; i++) {
                if (uniqueNums[i] == currNum) {
                    hasNum = true;
                    break;
                }
            }

            if (!hasNum) {
                uniqueNums[addedCount] = currNum;
                addedCount++;
            }
        }
        java.util.Arrays.sort(uniqueNums);
        return uniqueNums;
    }

    public static boolean isStrongPassword(char[] password) {
        boolean hasDigit = false;
        boolean hasSpecChar = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean isBlackListed = false;
        boolean isStrong = true;

        for (char passwordChar : password) {
            if (Character.isDigit(passwordChar)) {
                hasDigit = true;
            } else if (Character.isUpperCase(passwordChar)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(passwordChar)) {
                hasLowerCase = true;
            } else {
                hasSpecChar = true;
            }
        }

        for (char[] blacklistedPassword : PASSWORD_BLACKLIST) {
            if (java.util.Arrays.equals(blacklistedPassword, password)) {
                isBlackListed = true;
                break;
            }
        }

        if (isBlackListed) {
            Console.printError("""
                    Не используйте пароли из списка популярных:
                    https://nordpass.com/most-common-passwords-list""");
            isStrong = false;
        }
        if (password.length == 0) {
            Console.printError("Пароль не может быть пустым");
            isStrong = false;
        }
        if (password.length < 8) {
            Console.printError("Пароль содержит менее 8-и символов");
            isStrong = false;
        }

        if (!hasDigit) {
            Console.printError("Пароль не содержит цифры");
            isStrong = false;
        }

        if (!hasUpperCase) {
            Console.printError("Пароль не содержит буквы верхнего регистра");
            isStrong = false;
        }

        if (!hasLowerCase) {
            Console.printError("Пароль не содержит буквы нижнего регистра");
            isStrong = false;
        }

        if (!hasSpecChar) {
            Console.printError("Пароль не содержит спец. символы");
            isStrong = false;
        }
        return isStrong;
    }

    public static float[] resetAboveThresholdValues(float[] originalNums, int thresholdIndex) {
        if (originalNums == null) {
            Console.printError("исходный массив не содержит элементов");
            return null;
        }
        if (thresholdIndex < 0 || thresholdIndex > 14) {
            Console.printError("указан несуществующий индекс " + thresholdIndex +
                    ". Допустимо: 0 <= индекс <= 14");
            return null;
        }

        float[] filteredNums = java.util.Arrays.copyOf(originalNums, originalNums.length);
        float thresholdNum = originalNums[thresholdIndex];

        for (int i = 0; i < filteredNums.length; i++) {
            if (filteredNums[i] > thresholdNum) filteredNums[i] = 0f;
        }
        return filteredNums;
    }

    public static int[] reverse(int[] nums) {
        if (nums == null) {
            Console.printError("данные типа null");
            return null;
        }
        if (nums.length == 0) {
            Console.printError("длина массива = 0");
            return null;
        }

        int length = nums.length;
        int[] reversedNums = new int[length];

        for (int num : nums) {
            reversedNums[--length] = num;
        }
        return reversedNums;
    }

    public static String upperCaseBetweenMinMaxWords(String text) {
        int minWordLength = 1000;
        int maxWordLength = -1;
        String minWord = "";
        String maxWord = "";
        int minWordIndex = -1;
        int maxWordIndex = -1;

        String[] rawWords = text.split(" ");

        for (String rawWord : rawWords) {
            String word = rawWord.replaceAll("^[^a-zA-Zа-яА-ЯёЁ0-9]+|[^a-zA-Zа-яА-ЯёЁ0-9+]+$", "");

            boolean hasLetter = false;
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) {
                    hasLetter = true;
                    break;
                }
            }
            if (!hasLetter) continue;

            int currWordLength = word.length();

            if (currWordLength < minWordLength) {
                minWordLength = currWordLength;
                minWord = word;
            }
            if (currWordLength > maxWordLength) {
                maxWordLength = currWordLength;
                maxWord = word;
            }
        }

        int startSearchIndex = 0;

        for (String rawWord : rawWords) {
            if (rawWord.isEmpty()) continue;

            int currWordIndex = text.indexOf(rawWord, startSearchIndex);
            String word = rawWord.replaceAll("^[^a-zA-Zа-яА-ЯёЁ0-9]+|[^a-zA-Zа-яА-ЯёЁ0-9+]+$", "");

            if (word.equals(minWord)) {
                minWordIndex = currWordIndex + rawWord.indexOf(word);
            }
            if (word.equals(maxWord)) {
                maxWordIndex = currWordIndex + rawWord.indexOf(word);
            }

            startSearchIndex = currWordIndex + rawWord.length();
        }

        int startIndex = Math.min(minWordIndex, maxWordIndex);
        int endIndex = (minWordIndex > maxWordIndex) ?
                minWordIndex + minWordLength :
                maxWordIndex + maxWordLength;

        return text.substring(0, startIndex) +
                text.substring(startIndex, endIndex).toUpperCase() +
                text.substring(endIndex);
    }
}
