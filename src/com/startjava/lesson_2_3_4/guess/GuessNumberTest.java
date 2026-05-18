package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя первого игрока: ");
        Player firstPlayer = new Player(scanner.nextLine());

        System.out.print("Введите имя второго игрока: ");
        Player secondPlayer = new Player(scanner.nextLine());

        String answer = "yes";
        while (!answer.equals("no")) {
            if (answer.equals("yes")) {
                GuessNumber game = new GuessNumber(firstPlayer, secondPlayer);
                game.start();

                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
            answer = scanner.nextLine().toLowerCase();
        }
    }
}