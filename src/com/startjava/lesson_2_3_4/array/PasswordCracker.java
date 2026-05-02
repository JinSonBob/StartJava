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
            boolean isPasswordStrong = getPasswordWeaknesses(password);
            crackPassword(password, isPasswordStrong);
            System.out.println();
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

    private static boolean getPasswordWeaknesses(char[] password) {
        char[][] passBlacklist = {
                "array".toCharArray(),
                "qwerty".toCharArray(),
                "123456".toCharArray()};

        boolean hasDigit = false;
        boolean hasSpecChar = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean isBlackListed = false;
        boolean isStrongPassword = true;

        for (char passChar : password) {
            if (Character.isDigit(passChar)) hasDigit = true;
            else if (Character.isLetter(passChar)) {
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

            if (!hasDigit) {
                System.out.println("Пароль не содержит цифры");
                isStrongPassword = false;
            }

            if (!hasUpperCase) {
                System.out.println("Пароль не содержит буквы верхнего регистра");
                isStrongPassword = false;
            }

            if (!hasLowerCase) {
                System.out.println("Пароль не содержит буквы нижнего регистра");
                isStrongPassword = false;
            }

            if (!hasSpecChar) {
                System.out.println("Пароль не содержит спец. символы");
                isStrongPassword = false;
            }
        }
        return isStrongPassword;
    }

    private static void crackPassword(char[] password, boolean isPasswordStrong)
            throws InterruptedException {
        String resetColor = "\u001B[0m";
        String redColor = "\u001B[31m";
        String greenColor = "\u001B[32m";

        showSpinner();

        if (isPasswordStrong) {
            System.out.printf("%s✗ Strong password: %s%s%n",
                    redColor, String.valueOf(password), resetColor);
            return;
        }
        System.out.printf("%s✓ Password cracked: %s%s%n",
                greenColor, String.valueOf(password), resetColor);
    }

    private static void showSpinner() throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};
        int revolutions = spins.length * 3;

        System.out.print("Cracking password: ");

        for (int i = 0; i <= revolutions; i++) {
            System.out.print(spins[i % spins.length]);
            Thread.sleep(250);
            System.out.print("\b");
        }
        System.out.print("\r\r");
    }
}
