package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class PasswordCracker {
    private static final char[][] PASSWORD_BLACKLIST = {
            "array".toCharArray(),
            "qwerty".toCharArray(),
            "123456".toCharArray()};
    @SuppressWarnings("checkstyle:AvoidEscapedUnicodeCharacters")
    private static final String RESET_COLOR = "\u001B[0m";
    @SuppressWarnings("checkstyle:AvoidEscapedUnicodeCharacters")
    private static final String RED_COLOR = "\u001B[31m";
    @SuppressWarnings("checkstyle:AvoidEscapedUnicodeCharacters")
    private static final String GREEN_COLOR = "\u001B[32m";

    static void main() throws InterruptedException {
        char[][] passwords = {
                "123456".toCharArray(),
                generatePassword(),
                generatePassword(),
                generatePassword()};

        for (char[] password : passwords) {
            boolean isStrong = isStrongPassword(password);
            crackPassword(password, isStrong);
            System.out.println();
        }
    }

    private static char[] generatePassword() {
        Random random = new Random();
        int passwordLength = random.nextInt(6, 13);
        char[] password = new char[passwordLength];

        for (int i = 0; i < passwordLength; i++) {
            password[i] = (char) random.nextInt(33, 127);
        }
        return password;
    }

    private static boolean isStrongPassword(char[] password) {
        boolean hasDigit = false;
        boolean hasSpecChar = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean isBlackListed = false;
        boolean isStrong = true;

        for (char passwordChar : password) {
            if (Character.isDigit(passwordChar)) {
                hasDigit = true;
            } else if (Character.isUpperCase(passwordChar)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(passwordChar)) {
                hasLowerCase = true;
            } else {
                hasSpecChar = true;
            }
        }

        for (char[] blacklistedPassword : PASSWORD_BLACKLIST) {
            if (Arrays.equals(blacklistedPassword, password)) {
                isBlackListed = true;
                break;
            }
        }

        if (isBlackListed) {
            System.out.print("""
                    Не используйте пароли из списка популярных:
                    https://nordpass.com/most-common-passwords-list
                    """);
            isStrong = false;
        }
        if (password.length == 0) {
            System.out.println("Пароль не может быть пустым");
            isStrong = false;
        }
        if (password.length < 8) {
            System.out.println("Пароль содержит менее 8-и символов");
            isStrong = false;
        }

        if (!hasDigit) {
            System.out.println("Пароль не содержит цифры");
            isStrong = false;
        }

        if (!hasUpperCase) {
            System.out.println("Пароль не содержит буквы верхнего регистра");
            isStrong = false;
        }

        if (!hasLowerCase) {
            System.out.println("Пароль не содержит буквы нижнего регистра");
            isStrong = false;
        }

        if (!hasSpecChar) {
            System.out.println("Пароль не содержит спец. символы");
            isStrong = false;
        }
        return isStrong;
    }

    private static void crackPassword(char[] password, boolean isStrong)
            throws InterruptedException {
        showSpinner();

        if (isStrong) {
            System.out.printf("%s✗ Strong password: %s%s%n",
                    RED_COLOR, String.valueOf(password), RESET_COLOR);
            return;
        }
        System.out.printf("%s✓ Password cracked: %s%s%n",
                GREEN_COLOR, String.valueOf(password), RESET_COLOR);
    }

    private static void showSpinner() throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};
        int revolutions = spins.length * 3;

        System.out.print("Cracking password: ");

        for (int i = 0; i < revolutions; i++) {
            System.out.print(spins[i % spins.length]);
            Thread.sleep(250);
            System.out.print("\b");
        }
        System.out.print("\r\r");
    }
}
