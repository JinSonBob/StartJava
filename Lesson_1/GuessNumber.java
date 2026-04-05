import java.util.Random;

public class GuessNumber {
    public static void main(String[] args) {
        int leftBorder = 1;
        int rightBorder = 100;
        int playerNum = 51;
        int pcNum = new Random().nextInt(1, 101);

        while (playerNum != pcNum) {
            if (playerNum < pcNum) {
                System.out.printf("\n%d меньше того, что загадал компьютер", playerNum);
                leftBorder = ++playerNum;
            } else {
                System.out.printf("\n%d больше того, что загадал компьютер", playerNum);
                rightBorder = --playerNum;
            }
            playerNum = (leftBorder + rightBorder) / 2;
        }

        System.out.printf("\nВы победили! Загаданное число: %d", pcNum);
    }
}