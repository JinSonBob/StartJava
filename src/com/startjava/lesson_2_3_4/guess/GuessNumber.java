package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static final int MAX_ATTEMPTS = 10;
    public static final int MIN_HIDDEN_NUM = 1;
    public static final int MAX_HIDDEN_NUM = 100;
    private static final int MAX_ROUNDS = 3;

    private Player[] players;
    private int hiddenNum;
    
    public GuessNumber(Player[] players) {
        this.players = players;
    }

    public void start() throws InterruptedException {
        choosePlayerOrder();
        for (Player player : players) player.clearWins();

        for (int round = 1; round <= MAX_ROUNDS; round++) {
            hiddenNum = new Random().nextInt(MIN_HIDDEN_NUM, MAX_HIDDEN_NUM + 1);
            for (Player player : players) player.clearAttempts();

            System.out.println("\nРаунд " + round);
            System.out.println("(Подсказка " + hiddenNum + ")");
            System.out.println("Раунд начался! У каждого игрока по " + MAX_ATTEMPTS + " попыток");

            Scanner scanner = new Scanner(System.in);
            boolean isRoundWon = false;

            for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
                for (Player currPlayer : players) {
                    System.out.println("\nПопытка: " + attempt);
                    int attemptNum = inputNum(scanner, currPlayer);

                    if (isGuessed(attemptNum)) {
                        System.out.printf("%n%s угадал число %d с %d попытки",
                                currPlayer.getName(), hiddenNum, attempt);
                        currPlayer.addWin();
                        isRoundWon = true;
                        break;
                    }

                    if (attempt == MAX_ATTEMPTS) {
                        System.out.printf("У %s закончились попытки!%n", currPlayer.getName());
                    }
                }
                if (isRoundWon) break;
            }
            printPlayersNums();
        }
        printGameSummary();
    }

    private void choosePlayerOrder() throws InterruptedException {
        for (int i = players.length - 1; i > 0; i--) {
            int j = new Random().nextInt(i + 1);
            Player tmpPlayer = players[i];
            players[i] = players[j];
            players[j] = tmpPlayer;
        }

        for (Player player : players) {
            showSpinner(player);
        }

        System.out.print("Порядок ходов: ");
        for (Player player : players) {
            System.out.print(player.getName() + " ");
        }
        System.out.println();
    }

    private static void showSpinner(Player player) throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};
        int revolutions = spins.length * 3;

        System.out.printf("%s бросает жребий: ", player.getName());

        for (int i = 0; i < revolutions; i++) {
            System.out.print(spins[i % spins.length]);
            Thread.sleep(250);
            System.out.print("\b");
        }
        System.out.print("\r\r");
    }

    private int inputNum(Scanner scanner, Player currPlayer) {
        System.out.printf("Число вводит %s: ", currPlayer.getName());
        while (true) {
            try {
                int num = scanner.nextInt();
                currPlayer.addNum(num);
                return num;
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    private boolean isGuessed(int playerNum) {
        if (playerNum == hiddenNum) {
            return true;
        }
        System.out.printf("%d %s того, что загадал компьютер%n",
                playerNum,
                (playerNum > hiddenNum) ? "больше" : "меньше");
        return false;
    }

    private void printPlayersNums() {
        System.out.println("\nНазванные числа игроков в этом раунде:");
        for (Player player : players) {
            System.out.printf("Числа %s: %s%n",
                    player.getName(), Arrays.toString(player.getNums()));
        }
    }

    private void printGameSummary() {
        int maxWins = 0;
        Player winner = players[0];
        boolean isTie = false;

        for (Player player : players) {
            if (player.getWinsCount() > maxWins) {
                maxWins = player.getWinsCount();
                winner = player;
                isTie = false;
            } else if (player.getWinsCount() == maxWins && maxWins > 0) {
                isTie = true;
            }
        }

        if (maxWins == 0) {
            System.out.println("\nОбщий проигрыш, у всех игроков 0 побед");
            return;
        }
        if (isTie) {
            System.out.println("\nНичья, игроки набрали одинаковое количество побед");
            return;
        }
        System.out.printf("%nПобедил %s со счётом %d%n",
                winner.getName(), winner.getWinsCount());
    }
}