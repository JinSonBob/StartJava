package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionHistory {
    static void main() {
        printTransactions(new int[]{});
        printTransactions(null);
        printTransactions(new int[]{5});
        printTransactions(new int[]{6, 8, 9, 1});
        printTransactions(new int[]{13, 8, 5, 3, 2, 1, 1});
    }

    private static void printTransactions(int[] transactions) {
        if (transactions == null) {
            System.out.println("Ошибка данных: данные типа null");
            return;
        }

        int arrLength = transactions.length;

        if (arrLength == 0) {
            System.out.println("Нет истории транзакций: длина массива = 0");
            return;
        }

        System.out.println("\nИсходные транзакции: " + Arrays.toString(transactions));
        System.out.println(" В обратном порядке: " + Arrays.toString(reverseTransactions(transactions)));
    }

    private static int[] reverseTransactions(int[] transactions) {
        int arrLength = transactions.length;
        int tmpTransaction;

        for (int i = 0; i < arrLength / 2; i++) {
            tmpTransaction = transactions[i];
            transactions[i] = transactions[arrLength - i - 1];
            transactions[arrLength - i - 1] = tmpTransaction;
        }
        return transactions;
    }
}
