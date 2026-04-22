package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionReverser {
    static void main() {
        printTransactions(new int[]{});
        printTransactions(null);
        printTransactions(new int[]{5});
        printTransactions(new int[]{6, 8, 9, 1});
        printTransactions(new int[]{13, 8, 5, 3, 2, 1, 1});
    }

    private static void printTransactions(int[] transactions) {
        if (checkTransactions(transactions)) {
            int [] reversedTransactions = reverse(transactions);
            System.out.printf("""
                    Исходные транзакции: %s
                     В обратном порядке: %s
                    """, Arrays.toString(transactions), Arrays.toString(reversedTransactions));
        }
    }

    private static boolean checkTransactions(int[] transactions) {
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

        length--;
        for (int transaction : transactions) {
            reversedTransactions[length] = transaction;
            length--;
        }
        return reversedTransactions;
    }
}
