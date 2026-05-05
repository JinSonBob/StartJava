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

    private static int[] getWordsRange(String text) {
        int minWordLength = 1000;
        int maxWordLength = -1000;
        int minWordStart = 0;
        int minWordEnd = 0;
        int maxWordStart = 0;
        int maxWordEnd = 0;

        int wordStart = -1;
        boolean hasLetter = false;
        for (int i = 0; i < text.length(); i++) {
            char currChar = text.charAt(i);
            boolean isWordChar = Character.isLetter(currChar) || currChar == '+' || currChar == '-';

            if (isWordChar) {
                if (wordStart == -1) wordStart = i;
                if (Character.isLetter(currChar)) hasLetter = true;
            }
            if (!isWordChar && wordStart != -1) {
                int currLength = i - wordStart;

                if (hasLetter) {
                    if (currLength < minWordLength) {
                        minWordLength = currLength;
                        minWordStart = wordStart;
                        minWordEnd = i;
                    }
                    if (currLength > maxWordLength) {
                        maxWordLength = currLength;
                        maxWordStart = wordStart;
                        maxWordEnd = i;
                    }
                }

                wordStart = -1;
                hasLetter = false;
            }
        }

        int startIndex = Math.min(minWordStart, maxWordStart);
        int endIndex = Math.max(minWordEnd, maxWordEnd);

        return new int[]{startIndex, endIndex};
    }

    private static String wordsToUppercase(String text, int startIndex, int endIndex) {
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
