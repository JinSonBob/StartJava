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
    private char[] secretWord;
    private StringBuilder usedLetters;
    private int errorsCount;

    public HangmanGame() {
        init();
    }

    private void init() {
        Random random = new Random();
        secretWord = secretWords[random.nextInt(secretWords.length)].toCharArray();
        usedLetters = new StringBuilder();
        errorsCount = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String answer = "yes";

        while (!answer.equals("no")) {
            if (answer.equals("yes")) {
                init();

                while (!isWin() && !isTooMuchErrors()) {
                    printInfo();
                    takeGuess(scanner);
                }

                printInfo();

                if (isWin()) {
                    System.out.println("Вы угадали слово\n");
                } else {
                    System.out.printf("Вы не угадали слово: %s%n",
                            String.valueOf(secretWord).toUpperCase());
                }

                System.out.print("Хотите продолжить игру? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }

            answer = scanner.nextLine().toLowerCase();
        }
    }

    private boolean isWin() {
        for (char letter : secretWord) {
            if (usedLetters.toString().indexOf(letter) == -1) return false;
        }
        return true;
    }

    private boolean isTooMuchErrors() {
        return errorsCount == gallows.length - 1;
    }

    private void printInfo() {
        System.out.println();
        drawGallows();
        printGuessedLetters();
        System.out.print("\nОшибочные буквы: ");
        printUsedLetters();
        System.out.printf("%nПопыток осталось: %d%n", gallows.length - errorsCount - 1);
    }

    private void drawGallows() {
        for (int i = 0; i < errorsCount; i++) {
            System.out.println(gallows[i]);
        }
        if (errorsCount == gallows.length - 1) {
            System.out.println(gallows[gallows.length - 1]);
        }
    }

    private void printGuessedLetters() {
        System.out.print("Отгадано: ");
        for (char letter : secretWord) {
            if (usedLetters.toString().indexOf(letter) != -1) {
                System.out.print(Character.toUpperCase(letter));
            } else {
                System.out.print("_");
            }
        }
    }

    private void printUsedLetters() {
        for (int i = 0; i < usedLetters.length(); i++) {
            char letter = usedLetters.charAt(i);
            if (!hasLetter(letter)) {
                System.out.print(Character.toUpperCase(letter));
            }
        }
    }

    private boolean hasLetter(char letter) {
        for (char secretLetter : secretWord) {
            if (letter == secretLetter) return true;
        }
        return false;
    }

    private void takeGuess(Scanner scanner) {
        String input;
        char letter;

        do {
            System.out.print("Введите букву: ");
            input = scanner.nextLine().toLowerCase();
        } while (!isValidInput(input) || isAlreadyUsed(input));

        letter = input.charAt(0);
        usedLetters.append(letter);

        if (hasLetter(letter)) {
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
        if (usedLetters.toString().indexOf(letter) != -1) {
            System.out.printf("Буква %s уже вводилась%n", Character.toUpperCase(letter));
            return true;
        }
        return false;
    }
}
