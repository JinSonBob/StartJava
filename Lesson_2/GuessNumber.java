import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private Player firstPlayer;
    private Player secondPlayer;
    private int hiddenNum;
    
    public GuessNumber(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void start() {
        hiddenNum = new Random().nextInt(1, 101);
        System.out.println("(Подсказка " + hiddenNum + ")");

        Player currPlayer = firstPlayer;
        Scanner scanner = new Scanner(System.in);

        while (currPlayer.getNumber() != hiddenNum) {
            System.out.printf("%s, введите число от 1 до 100: ", currPlayer.getName());
            int answer = scanner.nextInt();

            while (answer < 1 || answer > 100) {
                System.out.print("Неверный ввод! введите число от 1 до 100: ");
                answer = scanner.nextInt();
            }

            currPlayer.setNumber(answer);

            if (currPlayer.getNumber() == hiddenNum) {
                System.out.printf("Игрок %s победил!%n", currPlayer.getName());
            } else {
                System.out.printf("Неверно, ход переходит другому игроку%n");

                currPlayer = (currPlayer == firstPlayer) ? secondPlayer : firstPlayer;
            }
        }
    }
}