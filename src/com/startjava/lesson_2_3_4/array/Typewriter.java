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
            String[] words = splitWords(text);
            String[] wordsRange = getWordsRange(words);
            String finalText = wordsToUppercase(text, wordsRange[0], wordsRange[1]);
            typewrite(finalText);
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

    private static String[] splitWords(String text) {
        return text.split("[^a-zA-Zа-яА-Я0-9+-]+");
    }

    private static String[] getWordsRange(String[] words) {
        int minWordLength = 1000;
        String minWord = "";
        int maxWordLength = -1000;
        String maxWord = "";

        for (String word : words) {
            if (!isValidWord(word)) continue;

            int wordLength = word.length();

            if (wordLength < minWordLength) {
                minWordLength = wordLength;
                minWord = word;
            }

            if (wordLength > maxWordLength) {
                maxWordLength = wordLength;
                maxWord = word;
            }
        }
        return new String[]{minWord, maxWord};
    }

    private static boolean isValidWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLetterOrDigit(word.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static String wordsToUppercase(String text, String minWord, String maxWord) {
        int minWordIndex = text.indexOf(minWord);
        int maxWordIndex = text.indexOf(maxWord);

        int startIndex = Math.min(minWordIndex, maxWordIndex);
        int endIndex = minWordIndex > maxWordIndex ?
                minWordIndex + minWord.length() :
                maxWordIndex + maxWord.length();

        return text.substring(0, startIndex) +
                text.substring(startIndex, endIndex).toUpperCase() +
                text.substring(endIndex);
    }

    private static void typewrite(String text) throws InterruptedException {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(100);
        }
    }
}
