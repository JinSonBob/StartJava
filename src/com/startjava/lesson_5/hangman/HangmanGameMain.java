package com.startjava.lesson_5.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        HangmanGame game = new HangmanGame();
        String answer;

        do {
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

            answer = checkAnswer(scanner);
        } while (answer.equals("yes"));
    }

    private static String checkAnswer(Scanner scanner) {
        String answer;

        do {
            System.out.print("Хотите продолжить игру? [yes/no]: ");
            answer = scanner.nextLine().toLowerCase();
        } while (!answer.equals("no") && !answer.equals("yes"));
        return answer;
    }
}
