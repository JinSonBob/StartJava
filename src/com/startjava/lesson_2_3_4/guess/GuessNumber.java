package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static final int MAX_ATTEMPTS = 10;
    public static final int MIN_HIDDEN_NUM = 1;
    public static final int MAX_HIDDEN_NUM = 100;
    private Player firstPlayer;
    private Player secondPlayer;
    private int hiddenNum;
    
    public GuessNumber(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.hiddenNum = new Random().nextInt(MIN_HIDDEN_NUM, MAX_HIDDEN_NUM + 1);
        firstPlayer.clear();
        secondPlayer.clear();
    }

    public void start() {
        System.out.println("(Подсказка " + hiddenNum + ")");
        System.out.println("Игра началась! У каждого игрока по " + MAX_ATTEMPTS + " попыток");

        Player currPlayer = firstPlayer;
        Scanner scanner = new Scanner(System.in);

        int round = 1;
        while (round <= MAX_ATTEMPTS) {
            System.out.println("\nПопытка: " + round);
            int attemptNumber = inputNum(scanner, currPlayer);

            if (checkWinNum(attemptNumber)) {
                printResults(currPlayer, round);
                break;
            }

            if (round == MAX_ATTEMPTS) {
                System.out.printf("У %s закончились попытки!", currPlayer.getName());
            }

            if (currPlayer == secondPlayer) round++;
            currPlayer = swapPlayer(currPlayer);
        }
    }

    private int inputNum(Scanner scanner, Player currPlayer) {
        System.out.printf("Число вводит %s: ", currPlayer.getName());
        while (true) {
            try {
                int number = scanner.nextInt();
                currPlayer.addNum(number);
                return number;
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage() + " ");
            }
        }
    }

    private boolean checkWinNum(int playerNum) {
        if (playerNum == hiddenNum) {
            return true;
        }
        System.out.printf("%d %s того, что загадал компьютер%n",
                playerNum,
                (playerNum > hiddenNum) ? "больше" : "меньше");
        return false;
    }

    private void printResults(Player winner, int attempt) {
        System.out.printf("""
                %n%s угадал число %d с %d попытки
                Числа %s: %s
                Числа %s: %s
                """, winner.getName(), hiddenNum, attempt,
                firstPlayer.getName(), Arrays.toString(firstPlayer.getNums()),
                secondPlayer.getName(), Arrays.toString(secondPlayer.getNums()));
    }

    private Player swapPlayer(Player currPlayer) {
        return (currPlayer == firstPlayer) ? secondPlayer : firstPlayer;
    }
}