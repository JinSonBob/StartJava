import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private int firstPlayerNum;
    private int secondPlayerNum;
    private int pcNum;
    private Scanner scanner = new Scanner(System.in);

    public void startGame(String firstPlayerName, String secondPlayerName) {
        pcNum = new Random().nextInt(1, 101);
        System.out.println("(Подсказка " + pcNum + ")");
        boolean isGuessed = false;
        String tmpName;

        while (!isGuessed) {
            boolean isValidInput = false;

            while (!isValidInput) {
                System.out.printf("%s, введите число от 1 до 100: ", firstPlayerName);
                firstPlayerNum = scanner.nextInt();

                if (firstPlayerNum >= 1 && firstPlayerNum <= 100) {
                    isValidInput = true;
                } else {
                    System.out.println("Неверный ввод! введите число от 1 до 100");
                }
            }

            if (firstPlayerNum == pcNum) {
                System.out.printf("Игрок %s победил!", firstPlayerName);
                isGuessed = true;
            } else {
                System.out.printf("Неверно, ход переходит игроку %s%n", secondPlayerName);
                tmpName = firstPlayerName;
                firstPlayerName = secondPlayerName;
                secondPlayerName = tmpName;
            }
        }
    }
}