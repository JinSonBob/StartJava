import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player firstPlayer = new Player();
        System.out.print("Введите имя первого игрока: ");
        firstPlayer.setName(scanner.nextLine());

        Player secondPlayer = new Player();
        System.out.print("Введите имя второго игрока: ");
        secondPlayer.setName(scanner.nextLine());
        
        boolean isContinue = true;
        while (isContinue) {
            GuessNumber main = new GuessNumber();
            main.startGame(firstPlayer.getName(), secondPlayer.getName());

            boolean isValidInput = false;

            while (!isValidInput) {
                System.out.print("\nХотите продолжить игру? [yes/no]: ");

                switch (scanner.next()) {
                    case "no":
                        isContinue = false;
                        isValidInput = true;
                        break;
                    case "yes":
                        isContinue = true;
                        isValidInput = true;
                        break;
                    default:
                        System.out.println("Ошибка: неправильный ввод");
                }
            }
        }
    }
}