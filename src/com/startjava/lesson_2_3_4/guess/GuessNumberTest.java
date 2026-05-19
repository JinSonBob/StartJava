package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Player[] players = new Player[3];

        for (int i = 1; i < 4; i++) {
            System.out.print("Введите имя " + i + " игрока: ");
            players[i - 1] = new Player(scanner.nextLine());
        }

        String answer = "yes";
        while (!answer.equals("no")) {
            if (answer.equals("yes")) {
                GuessNumber game = new GuessNumber(players);
                game.start();

                System.out.print("Хотите продолжить игру? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
            answer = scanner.nextLine().toLowerCase();
        }
    }
}