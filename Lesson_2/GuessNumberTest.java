import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя первого игрока: ");
        Player firstPlayer = new Player(scanner.nextLine());

        System.out.print("Введите имя второго игрока: ");
        Player secondPlayer = new Player(scanner.nextLine());
        
        String answer = "yes";

        while (answer.equals("yes")) {
            GuessNumber game = new GuessNumber(firstPlayer, secondPlayer);
            game.start();

            answer = "";

            while (!answer.equals("no") && !answer.equals("yes")) {
                System.out.print("Хотите продолжить игру? [yes/no]: ");
                answer = scanner.next();

                if (!answer.equals("no") && !answer.equals("yes")) {
                    System.out.println("Ошибка: неправильный ввод");
                }
            }
        }
    }
}