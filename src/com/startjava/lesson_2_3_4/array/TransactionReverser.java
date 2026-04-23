package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionReverser {
    static void main() {
        int[] transactions1 = new int[]{};
        if (isValidTransactions(transactions1)) {
            int[] reversedTransactions1 = reverse(transactions1);
            printTransactions(transactions1, reversedTransactions1);
        }

        int[] transactions2 = null;
        if (isValidTransactions(transactions2)) {
            int[] reversedTransactions2 = reverse(transactions2);
            printTransactions(transactions2, reversedTransactions2);
        }

        int[] transactions3 = new int[]{5};
        if (isValidTransactions(transactions3)) {
            int[] reversedTransactions3 = reverse(transactions3);
            printTransactions(transactions3, reversedTransactions3);
        }

        int[] transactions4 = new int[]{6, 8, 9, 1};
        if (isValidTransactions(transactions4)) {
            int[] reversedTransactions4 = reverse(transactions4);
            printTransactions(transactions4, reversedTransactions4);
        }

        int[] transactions5 = new int[]{13, 8, 5, 3, 2, 1, 1};
        if (isValidTransactions(transactions5)) {
            int[] reversedTransactions5 = reverse(transactions5);
            printTransactions(transactions5, reversedTransactions5);
        }
    }

    private static boolean isValidTransactions(int[] transactions) {
        if (transactions == null) {
            System.out.println("Ошибка данных: данные типа null");
            return false;
        }

        if (transactions.length == 0) {
            System.out.println("Нет истории транзакций: длина массива = 0");
            return false;
        }
        return true;
    }

    private static int[] reverse(int[] transactions) {
        int length = transactions.length;
        int[] reversedTransactions = new int[length];

        for (int transaction : transactions) {
            reversedTransactions[--length] = transaction;
        }
        return reversedTransactions;
    }

    private static void printTransactions(int[] transactions, int[] reversedTransactions) {
        System.out.printf("""
                Исходные транзакции: %s
                 В обратном порядке: %s
                """, Arrays.toString(transactions), Arrays.toString(reversedTransactions));
    }
}
