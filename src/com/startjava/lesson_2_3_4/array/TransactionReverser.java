package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionReverser {
    static void main() {
        int[] transactions = {};
        int[] reversedTransactions = reverse(transactions);
        printTransactions(transactions, reversedTransactions);
        System.out.println();

        transactions = null;
        reversedTransactions = reverse(transactions);
        printTransactions(transactions, reversedTransactions);
        System.out.println();

        transactions = new int[]{5};
        reversedTransactions = reverse(transactions);
        printTransactions(transactions, reversedTransactions);
        System.out.println();

        transactions = new int[]{6, 8, 9, 1};
        reversedTransactions = reverse(transactions);
        printTransactions(transactions, reversedTransactions);
        System.out.println();

        transactions = new int[]{13, 8, 5, 3, 2, 1, 1};
        reversedTransactions = reverse(transactions);
        printTransactions(transactions, reversedTransactions);
        System.out.println();
    }

    private static int[] reverse(int[] transactions) {
        if (!isValidTransactions(transactions)) return null;

        int length = transactions.length;
        int[] reversedTransactions = new int[length];

        for (int transaction : transactions) {
            reversedTransactions[--length] = transaction;
        }
        return reversedTransactions;
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

    private static void printTransactions(int[] originalTransactions, int[] reversedTransactions) {
        if (originalTransactions == null || reversedTransactions == null) return;

        System.out.printf("""
                Исходные транзакции: %s
                 В обратном порядке: %s
                """, Arrays.toString(originalTransactions), Arrays.toString(reversedTransactions));
    }
}
