package com.startjava.lesson_2_3_4.array;

public class Typewriter {
    static void main() throws InterruptedException {
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
            if (!isValidText(text)) continue;
            int[] wordsRange = getWordsRange(text);
            String finalText = wordsToUppercase(text, wordsRange[0], wordsRange[1]);
            type(finalText);
            System.out.println();
        }
    }

    private static boolean isValidText(String text) {
        if (text == null || text.isBlank()) {
            System.out.println("Ошибка: Введена пустая строка");
            return false;
        }
        return true;
    }

    private static int[] getWordsRange(String text) {
        int minWordLength = 1000;
        int maxWordLength = -1;
        String minWord = "";
        String maxWord = "";
        int minWordIndex = -1;
        int maxWordIndex = -1;

        String[] rawWords = text.split(" ");

        for (String rawWord : rawWords) {
            String word = rawWord.replaceAll("^[^a-zA-Zа-яА-ЯёЁ0-9]+|[^a-zA-Zа-яА-ЯёЁ0-9+]+$", "");

            if (!hasLetter(word)) continue;

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

        return new int[]{startIndex, endIndex};
    }

    private static boolean hasLetter(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLetter(word.charAt(i))) return true;
        }
        return false;
    }

    private static String wordsToUppercase(String text, int startIndex, int endIndex) {
        return text.substring(0, startIndex) +
                text.substring(startIndex, endIndex).toUpperCase() +
                text.substring(endIndex);
    }

    private static void type(String text) throws InterruptedException {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(100);
        }
    }
}
