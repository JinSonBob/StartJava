import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private Player firstPlayer;
    private Player secondPlayer;
    private int hiddenNum;
    
    public GuessNumber(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.hiddenNum = new Random().nextInt(1, 101);
    }

    public void start() {
        System.out.println("(Подсказка " + hiddenNum + ")");

        Player currPlayer = firstPlayer;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            currPlayer.setNumber(inputNum(scanner, currPlayer));

            if (checkWinNum(currPlayer)) break;

            currPlayer = swapPlayer(currPlayer);
        }
    }

    private int inputNum(Scanner scanner, Player currPlayer) {
        int playerNum;

        do {
            System.out.printf("%s, введите число от 1 до 100: ", currPlayer.getName());
            playerNum = scanner.nextInt();
        } while (playerNum < 1 || playerNum > 100);

        return playerNum;
    }

    private boolean checkWinNum(Player currPlayer) {
        int playerNum = currPlayer.getNumber();

        if (playerNum == hiddenNum) {
            System.out.printf("Игрок %s победил!%n", currPlayer.getName());
            return true;
        }
        System.out.printf("%d %s того, что загадал компьютер%n",
                playerNum,
                (playerNum > hiddenNum) ? "больше" : "меньше");
        return false;
    }

    private Player swapPlayer(Player currPlayer) {
        return (currPlayer == firstPlayer) ? secondPlayer : firstPlayer;
    }
}