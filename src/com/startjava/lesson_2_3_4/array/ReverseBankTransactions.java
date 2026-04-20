package com.startjava.lesson_2_3_4.array;

public class ReverseBankTransactions {
    static void main() {
        printInReverse(new int[]{});
        printInReverse(null);
        printInReverse(new int[]{5});
        printInReverse(new int[]{6, 8, 9, 1});
        printInReverse(new int[]{13, 8, 5, 3, 2, 1, 1});
    }

    private static void printInReverse(int[] transactions) {
        if (transactions == null) {
            System.out.println("Ошибка данных: данные типа null");
            return;
        }

        int arrLength = transactions.length;

        if (arrLength == 0) {
            System.out.println("Нет истории транзакций: длина массива = 0");
            return;
        }

        System.out.print("\nИсходные транзакции: [");
        for (int i = 0; i < arrLength; i++) {
            System.out.print(transactions[i]);
            if (i < arrLength - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");

        System.out.print("\n В обратном порядке: [");
        for (int i = arrLength - 1; i >= 0; i--) {
            System.out.print(transactions[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
