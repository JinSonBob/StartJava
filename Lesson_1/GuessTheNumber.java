public class GuessTheNumber {
    public static void main(String[] args) {
        int leftBorder = 1;
        int rightBorder = 100;
        int playerNum = 51;
        int pcNum = new java.util.Random().nextInt(1, 101);
        boolean flag = false;

        while (!flag) {
            if (playerNum == pcNum) {
                System.out.printf("\nВы победили! Загаданное число: %d", pcNum);
                flag = true;
            } else if (playerNum < pcNum) {
                System.out.printf("\n%d меньше того, что загадал компьютер", playerNum);
                leftBorder = playerNum + 1;
                playerNum = (leftBorder + rightBorder) / 2;
            } else {
                System.out.printf("\n%d больше того, что загадал компьютер", playerNum);
                rightBorder = playerNum - 1;
                playerNum = (leftBorder + rightBorder) / 2;
            }
        }
    }
}