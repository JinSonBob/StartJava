package com.startjava.lesson_2_3_4.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private final String[] hangmanStages = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };

    private char[] secretWord;
    private String usedLetters = "";
    private int errorsCount = 0;

    public void startGame() {
        secretWord = randomSecretWord();
        usedLetters = "";
        errorsCount = 0;
    }

    private static char[] randomSecretWord() {
        String[] words = {
                "банан",
                "автобус",
                "машина",
                "йод",
                "шишка",
                "микрофон"
        };
        Random random = new Random();
        return words[random.nextInt(words.length)].toCharArray();
    }

    public boolean isWin() {
        for (char letter : secretWord) {
            if (usedLetters.indexOf(letter) == -1) return false;
        }
        return true;
    }

    public boolean isTooMuchErrors() {
        return errorsCount == hangmanStages.length - 1;
    }

    public void printInfo() {
        System.out.println();
        printHangman();
        printGuessedLetters(secretWord, usedLetters);
        System.out.print("\nОшибочные буквы: ");
        printUsedLetters();
        System.out.printf("%nПопыток осталось: %d%n", hangmanStages.length - errorsCount - 1);
    }

    private void printHangman() {
        for (int i = 0; i < errorsCount; i++) {
            if (i < hangmanStages.length) {
                System.out.println(hangmanStages[i]);
            }
        }
        if (errorsCount == hangmanStages.length - 1) {
            System.out.println(hangmanStages[hangmanStages.length - 1]);
        }
    }

    private static void printGuessedLetters(char[] secretWord, String usedLetters) {
        System.out.print("Отгадано: ");
        for (char letter : secretWord) {
            if (usedLetters.indexOf(letter) != -1) {
                System.out.print(Character.toUpperCase(letter));
            } else {
                System.out.print("_");
            }
        }
    }

    private void printUsedLetters() {
        for (int i = 0; i < usedLetters.length(); i++) {
            char letter = usedLetters.charAt(i);
            if (!hasLetter(letter, secretWord)) {
                System.out.print(Character.toUpperCase(letter));
            }
        }
    }

    private static boolean hasLetter(char letter, char[] secretWord) {
        for (char secretLetter : secretWord) {
            if (letter == secretLetter) return true;
        }
        return false;
    }

    public void takeGuess(Scanner scanner) {
        String input;
        char letter;

        do {
            System.out.print("Введите букву: ");
            input = scanner.nextLine().toLowerCase();
        } while (!isValidInput(input) || isAlreadyUsed(input));

        letter = input.charAt(0);
        usedLetters += letter;

        if (hasLetter(letter, secretWord)) {
            System.out.printf("Отгадана буква %s%n", Character.toUpperCase(letter));
            if (errorsCount > 0) errorsCount--;
        } else {
            System.out.printf("В слове нет буквы %s%n", Character.toUpperCase(letter));
            errorsCount++;
        }
    }

    private static boolean isValidInput(String input) {
        if (input.length() > 1) {
            System.out.println("Ошибка: введите только 1 букву");
            return false;
        }
        if (input.matches("[а-яА-ЯёЁ]")) {
            return true;
        } else {
            System.out.println("Ошибка: используйте только кириллицу");
            return false;
        }
    }

    private boolean isAlreadyUsed(String input) {
        char letter = input.charAt(0);
        if (usedLetters.indexOf(letter) != -1) {
            System.out.printf("Буква %s уже вводилась%n", Character.toUpperCase(letter));
            return true;
        }
        return false;
    }

    public String getSecretWord() {
        return String.valueOf(secretWord).toUpperCase();
    }
}
