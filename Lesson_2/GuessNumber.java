import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private Player firstPlayer;
    private Player secondPlayer;
    private int pcNum;
    private Scanner scanner = new Scanner(System.in);
    
    public GuessNumber(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void start() {
        pcNum = new Random().nextInt(1, 101);
        System.out.println("(Подсказка " + pcNum + ")");

        Player currPlayer = firstPlayer;
        Player nextPlayer = secondPlayer;

        boolean isGuessed = false;

        while (!isGuessed) {
            System.out.printf("%s, введите число от 1 до 100: ", currPlayer.getName());
            int input = scanner.nextInt();

            while (input < 1 || input > 100) {
                System.out.print("Неверный ввод! введите число от 1 до 100: ");
                input = scanner.nextInt();
            }

            currPlayer.setNumber(input);

            if (currPlayer.getNumber() == pcNum) {
                System.out.printf("Игрок %s победил!", currPlayer.getName());
                isGuessed = true;
            } else {
                System.out.printf("Неверно, ход переходит игроку %s%n", nextPlayer.getName());

                Player tmpPlayer = currPlayer;
                currPlayer = nextPlayer;
                nextPlayer = tmpPlayer;
            }
        }
    }
}