package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class PasswordCracker {
    static void main() throws InterruptedException {
        char[][] passwords = {
                "123456".toCharArray(),
                generatePass(),
                generatePass(),
                generatePass()};

        for (char[] password : passwords) {
            boolean[] passwordMetrics = getPasswordMetrics(password);
            crackPassword(password, passwordMetrics);
        }
    }

    private static char[] generatePass() {
        Random random = new Random();
        int passLength = random.nextInt(6, 13);
        char[] password = new char[passLength];

        for (int i = 0; i < passLength; i++) {
            password[i] = (char) random.nextInt(33, 126);
        }
        return password;
    }

    private static boolean[] getPasswordMetrics(char[] password) {
        char[][] passBlacklist = {
                "array".toCharArray(),
                "qwerty".toCharArray(),
                "123456".toCharArray()};

        boolean hasDigit = false;
        boolean hasLetter = false;
        boolean hasSpecChar = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean isBlackListed = false;

        for (char passChar : password) {
            if (Character.isDigit(passChar)) hasDigit = true;
            else if (Character.isLetter(passChar)) {
                hasLetter = true;
                if (Character.isUpperCase(passChar)) hasUpperCase = true;
                if (Character.isLowerCase(passChar)) hasLowerCase = true;
            } else {
                hasSpecChar = true;
            }
        }

        for (char[] blacklistedPass : passBlacklist) {
            if (Arrays.equals(blacklistedPass, password)) {
                isBlackListed = true;
                break;
            }
        }

        return new boolean[]{hasDigit, hasLetter, hasSpecChar, hasUpperCase, hasLowerCase, isBlackListed};
    }

    private static void crackPassword(char[] password, boolean[] passwordMetrics)
            throws InterruptedException {
        String resetColor = "\u001B[0m";
        String redColor = "\u001B[31m";
        String greenColor = "\u001B[32m";

        spinner();

        if (isStrongPassword(password, passwordMetrics)) {
            System.out.printf("%s✗ Strong password: %s%s%n",
                    redColor, String.valueOf(password), resetColor);
            return;
        }
        System.out.printf("%s✓ Password cracked: %s%s%n",
                greenColor, String.valueOf(password), resetColor);
    }

    private static void spinner() throws InterruptedException {
        char[] spinnerChars = {'-', '\\', '|', '/'};
        int revolutions = spinnerChars.length * 3;

        System.out.print("\nCracking password: ");

        for (int i = 0; i <= revolutions; i++) {
            System.out.print(spinnerChars[i % spinnerChars.length]);
            Thread.sleep(250);
            System.out.print("\b");
        }
        System.out.println("\r\r");
    }

    private static boolean isStrongPassword(char[] password, boolean[] passwordMetrics) {
        final boolean hasDigit = passwordMetrics[0];
        final boolean hasLetter = passwordMetrics[1];
        final boolean hasSpecChar = passwordMetrics[2];
        final boolean hasUpperCase = passwordMetrics[3];
        final boolean hasLowerCase = passwordMetrics[4];
        final boolean isBlackListed = passwordMetrics[5];
        boolean isStrongPassword = true;

        if (isBlackListed) {
            System.out.print("""
                        Не используйте пароли из списка популярных:
                        https://nordpass.com/most-common-passwords-list
                        """);
            isStrongPassword = false;
        } else {
            if (password.length == 0) {
                System.out.println("Пароль не может быть пустым");
                isStrongPassword = false;
            }

            if (password.length < 8) {
                System.out.println("Пароль должен быть не менее 8 символов");
                isStrongPassword = false;
            }

            if (hasDigit && !hasLetter && !hasSpecChar) {
                System.out.println("Пароль содержит только цифры");
                isStrongPassword = false;
            }

            if (hasLetter && !hasDigit && !hasSpecChar) {
                System.out.println("Пароль содержит только буквы");
                isStrongPassword = false;
            }

            if (hasSpecChar && !hasLetter && !hasDigit) {
                System.out.println("Пароль содержит только спец. символы");
                isStrongPassword = false;
            }

            if (!hasSpecChar) {
                System.out.println("Пароль не содержит спец. символы");
                isStrongPassword = false;
            }

            if (!hasLowerCase && !hasUpperCase) {
                System.out.println("Пароль не содержит буквы нижнего и верхнего регистров");
                isStrongPassword = false;
            }
        }
        return isStrongPassword;
    }
}
