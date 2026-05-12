package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        HangmanGame game = new HangmanGame();
        String answer = "yes";

        while (!answer.equals("no")) {
            if (answer.equals("yes")) {
                game.startGame();

                while (!game.isWin() && !game.isTooMuchErrors()) {
                    game.printInfo();
                    game.takeGuess(scanner);
                }

                game.printInfo();

                if (game.isWin()) {
                    System.out.println("Вы угадали слово\n");
                } else {
                    System.out.printf("Вы не угадали слово: %s%n", game.getSecretWord());
                }

                System.out.print("Хотите продолжить игру? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }

            answer = scanner.nextLine().toLowerCase();
        }
    }
}
