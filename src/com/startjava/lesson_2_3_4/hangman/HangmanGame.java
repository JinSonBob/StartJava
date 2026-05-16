package com.startjava.lesson_2_3_4.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private final String[] gallows = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };
    private final String[] secretWords = {
            "банан",
            "автобус",
            "машина",
            "йод",
            "шишка",
            "микрофон"
    };
    private String secretWord;
    private StringBuilder wrongLetters;
    private StringBuilder wordMask;
    private int errorsCount;

    public HangmanGame() {
        Random random = new Random();
        secretWord = secretWords[random.nextInt(secretWords.length)].toUpperCase();
        wordMask = new StringBuilder("_".repeat(secretWord.length()));
        wrongLetters = new StringBuilder();
        errorsCount = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (!isWin() && !hasAttempt()) {
            printState();
            takeGuess(scanner);
        }

        printState();

        if (isWin()) {
            System.out.println("Вы угадали слово\n");
        } else {
            System.out.printf("Вы не угадали слово: %s%n", secretWord);
        }
    }

    private boolean isWin() {
        return secretWord.contentEquals(wordMask);
    }

    private boolean hasAttempt() {
        return errorsCount == gallows.length - 1;
    }

    private void printState() {
        System.out.println();
        drawGallows();
        printGuessedLetters();
        System.out.print("\nОшибочные буквы: ");
        printWrongLetters();
        System.out.printf("%nПопыток осталось: %d%n", gallows.length - errorsCount - 1);
    }

    private void drawGallows() {
        for (int i = 0; i <= errorsCount; i++) {
            System.out.println(gallows[i]);
        }
    }

    private void printGuessedLetters() {
        System.out.printf("Отгадано: %s", wordMask);
    }

    private void printWrongLetters() {
        System.out.print(wrongLetters);
    }

    private void takeGuess(Scanner scanner) {
        String input;
        char letter;

        do {
            System.out.print("Введите букву: ");
            input = scanner.nextLine().toUpperCase();
        } while (!isValidInput(input) || isAlreadyUsed(input));

        letter = input.charAt(0);

        if (hasLetter(letter)) {
            System.out.printf("Отгадана буква %s%n", letter);
            updateWordMask(letter);
            if (errorsCount > 0) errorsCount--;
        } else {
            System.out.printf("В слове нет буквы %s%n", letter);
            wrongLetters.append(letter);
            errorsCount++;
        }
    }

    private static boolean isValidInput(String input) {
        if (input.length() > 1) {
            System.out.println("Ошибка: введите только 1 букву");
            return false;
        }
        if (!input.matches("[а-яА-ЯёЁ]")) {
            System.out.println("Ошибка: используйте только кириллицу");
            return false;
        }
        return true;
    }

    private boolean isAlreadyUsed(String letter) {
        if (wrongLetters.indexOf(letter) != -1 || wordMask.indexOf(letter) != -1) {
            System.out.printf("Буква %s уже вводилась%n", letter);
            return true;
        }
        return false;
    }

    private boolean hasLetter(char letter) {
        return secretWord.indexOf(letter) != -1;
    }

    private void updateWordMask(char letter) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                wordMask.setCharAt(i, letter);
            }
        }
    }
}
