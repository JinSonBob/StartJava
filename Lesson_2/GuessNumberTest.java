import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя первого игрока: ");
        Player firstPlayer = new Player(scanner.nextLine());

        System.out.print("Введите имя второго игрока: ");
        Player secondPlayer = new Player(scanner.nextLine());
        
        String input = "yes";

        while (input.equals("yes")) {
            GuessNumber game = new GuessNumber(firstPlayer, secondPlayer);
            game.start();

            System.out.print("Хотите продолжить игру? [yes/no]: ");
            input = scanner.next();

            while (!input.equals("no") && !input.equals("yes")) {
                System.out.println("Ошибка: неправильный ввод. Введите [yes/no]: ");
                input = scanner.next();
            }
        }
    }
}