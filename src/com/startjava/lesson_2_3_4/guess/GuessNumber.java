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
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        shufflePlayers();
        for (Player player : players) player.clearWins();

        for (int round = 1; round <= MAX_ROUNDS; round++) {
            generateHiddenNum(random);
            for (Player player : players) player.clearAttempts();

            printRoundInfo(round, hiddenNum, MAX_ATTEMPTS);

            boolean isRoundWon = false;

            for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
                for (Player currPlayer : players) {
                    System.out.println("\nПопытка: " + attempt);
                    int playerNum = inputNum(scanner, currPlayer);

                    if (isGuessed(currPlayer, playerNum, attempt)) {
                        isRoundWon = true;
                        break;
                    }

                    checkRemainingAttempts(currPlayer, attempt);
                }
                if (isRoundWon) break;
            }
            printPlayersNums();
        }
        printGameSummary();
    }

    private void shufflePlayers() throws InterruptedException {
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

    private void generateHiddenNum(Random random) {
        hiddenNum = random.nextInt(MIN_HIDDEN_NUM, MAX_HIDDEN_NUM + 1);
    }

    private static void printRoundInfo(int round, int hiddenNum, int attempts) {
        System.out.printf("""
                    %nРаунд %d
                    Подсказка: %d
                    Раунд начался! У каждого игрока по %d попыток
                    """, round, hiddenNum, attempts);
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

    private boolean isGuessed(Player currPlayer, int playerNum, int attempt) {
        if (playerNum == hiddenNum) {
            System.out.printf("%n%s угадал число %d с %d попытки%n",
                    currPlayer.getName(), hiddenNum, attempt);
            currPlayer.incrementWins();
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

    private void checkRemainingAttempts(Player currPlayer, int attempt){
        if (attempt == MAX_ATTEMPTS) {
            System.out.printf("У %s закончились попытки!%n", currPlayer.getName());
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