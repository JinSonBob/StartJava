public class CyclesTheme {
    public static void main(String[] args) {
        // 1.ВЫВОД ASCII-СИМВОЛОВ
        System.out.println("\n1.ВЫВОД ASCII-СИМВОЛОВ");

        System.out.printf("%-10s%-12s%s\n", "DECIMAL", "CHARACTER", "DESCRIPTION");

        for (int i = 33; i < 48; i += 2) {
            System.out.printf("%4d          %-13c%s\n", i, (char) i, Character.getName(i));
        }

        // 2.ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР
        System.out.println("\n2.ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР");

        for (int i = 0; i <= 4; i++) {
            System.out.print("\n---------- ");

            for (int j = (4 - i); j >= 0; j -= 1) {
                System.out.print("*");
            }

            System.out.print(" ");

            for (int j = 1; j <= i * 2 + 1; j++) {
                System.out.print("^");
            }
        }

        // 3.ВЫВОД ТАБЛИЦЫ УМНОЖЕНИЯ
        System.out.println("\n\n3.ВЫВОД ТАБЛИЦЫ УМНОЖЕНИЯ");

        System.out.println("""
                  |  2  3  4  5  6  7  8  9
                --+------------------------""");

        for (int i = 2; i <= 9; i++) {
            System.out.printf("%d |", i);
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }

        // 4.ВЫВОД ЧИСЕЛ В НЕСКОЛЬКО СТРОК
        System.out.println("\n4.ВЫВОД ЧИСЕЛ В НЕСКОЛЬКО СТРОК");

        for (int i = 0; i < 3; i++) {
            for (int j = i * 10 + 1; j < (i + 1) * 10; j += 2) {
                if (j < 24) {
                    System.out.printf("%3d", j);
                } else {
                    System.out.printf("%3s", "0");
                }
            }
            System.out.println();
        }

        // 5.ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX
        System.out.println("\n5.ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX");

        int firstNum = 10;
        int secondNum = 5;
        int thirdNum = -1;
        int max = firstNum > secondNum
                ? (firstNum > thirdNum ? firstNum : thirdNum)
                : (secondNum > thirdNum ? secondNum : thirdNum);
        int min = firstNum < secondNum
                ? (firstNum < thirdNum ? firstNum : thirdNum)
                : (secondNum < thirdNum ? secondNum : thirdNum);

        for (int i = min + 1; i < max; i++) {
            System.out.print(i + " ");
        }

        // 6.РАЗНЫЕ ОПЕРАЦИИ НАД ЧИСЛОМ
        System.out.println("\n\n6.РАЗНЫЕ ОПЕРАЦИИ НАД ЧИСЛОМ");

        int startNum = 2234321;
        int tmp = startNum;
        int reverseNum = 0;
        int counter = 0;

        while (tmp > 0) {
            reverseNum = reverseNum * 10 + tmp % 10;
            if (tmp % 10 == 2) {
                counter++;
            }
            tmp /= 10;
        }
        System.out.println("Число в обратном порядке: " + reverseNum);
        System.out.printf("%d - %s с %s (%d) количеством двоек", startNum, 
                startNum == reverseNum ? "палиндром" : "не палиндром",
                counter % 2 == 0 ? "четным" : "нечетным",
                counter);

        // 7.ПРОВЕРКА СЧАСТЛИВОГО ЧИСЛА
        System.out.println("\n\n7.ПРОВЕРКА СЧАСТЛИВОГО ЧИСЛА");

        int luckyNum = 101002;
        int firstPart = luckyNum % 1000;
        int secondPart = luckyNum / 1000;
        int firstSum = 0;
        int secondSum = 0;

        while (firstPart > 0) {
            firstSum += firstPart % 10;
            firstPart /= 10;
        }
        while (secondPart > 0) {
            secondSum += secondPart % 10;
            secondPart /= 10;
        }

        System.out.printf("""
                %d - %s число
                Сумма цифр %03d = %d
                Сумма цифр %03d = %d""", luckyNum,
                firstSum == secondSum ? "счастливое" : "несчастливое",
                luckyNum % 1000, firstSum, luckyNum / 1000, secondSum);

        // 8.ПРОСТОЙ ГЕНЕРАТОР ПАРОЛЯ
        System.out.println("\n\n8.ПРОСТОЙ ГЕНЕРАТОР ПАРОЛЯ");

        int amount = 0;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecChar = false;
        java.util.Random random = new java.util.Random();

        System.out.print("Пароль: ");

        for (int i = 0; i < 8; i++) {
            amount += 1;
            char symbol = (char) random.nextInt(33, 126);
            System.out.print(symbol);
            hasLowerCase = Character.isLowerCase(symbol) ? true : hasLowerCase;
            hasUpperCase = Character.isUpperCase(symbol) ? true : hasUpperCase;
            hasDigit = Character.isDigit(symbol) ? true : hasDigit;
            hasSpecChar = !Character.isLetterOrDigit(symbol) ? true : hasSpecChar;
        }

        System.out.printf("\nНадёжность: %s",
                (amount >= 8 && hasLowerCase && hasUpperCase && hasSpecChar) ?
                "Надежный" : ((amount >= 8 && hasUpperCase && hasDigit) ?
                "Средний" : "Слабый"));
    }
}