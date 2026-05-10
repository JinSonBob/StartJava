package com.startjava.lesson_2_3_4.array;

public class Console {
    @SuppressWarnings("checkstyle:AvoidEscapedUnicodeCharacters")
    public static final String RESET_COLOR = "\u001B[0m";
    @SuppressWarnings("checkstyle:AvoidEscapedUnicodeCharacters")
    public static final String RED_COLOR = "\u001B[31m";
    @SuppressWarnings("checkstyle:AvoidEscapedUnicodeCharacters")
    public static final String GREEN_COLOR = "\u001B[32m";

    private Console() {}

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printColoredText(String text, String color) {
        System.out.println(color + text + RESET_COLOR);
    }

    public static void printError(String message) {
        System.out.println("Ошибка: " + message);
    }

    public static void printFactorialExpression(int[] nums, long[] factorials) {
        if (nums == null || factorials == null) return;

        StringBuilder expression = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            if (factorials[i] == -1) continue;

            expression.append(nums[i]);
            expression.append("! = ");

            if (nums[i] == 0 || nums[i] == 1) {
                expression.append("1");
            } else {
                for (int j = 1; j <= nums[i]; j++) {
                    expression.append(j);
                    if (j != nums[i]) expression.append(" * ");
                }
                expression.append(" = ").append(factorials[i]);
            }
            System.out.println(expression);
            expression.setLength(0);
        }
    }

    public static void printFloatArrayInRows(float[] nums, int numsPerRow) {
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%.3f ", nums[i]);
            if ((i + 1) % numsPerRow == 0) System.out.println();
        }
    }

    public static void printFormattedFloat(String message, float value) {
        System.out.printf("%s %.3f%n", message, value);
    }

    public static void printIntArrayInRows(int[] nums, int rowLength) {
        if (rowLength < 1) {
            printError("количество чисел в строке не должно быть > 1 (" + rowLength + ")");
            return;
        }

        StringBuilder uniqueNumsString = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            uniqueNumsString.append(nums[i]);
            uniqueNumsString.append(" ");

            if ((i + 1) % rowLength == 0 && i != nums.length - 1) {
                uniqueNumsString.append("\n");
            }
        }

        System.out.println(uniqueNumsString);
    }

    public static void printNewLineText(String text) {
        System.out.println(text);
    }

    public static void printText(String text) {
        System.out.print(text);
    }

    public static void printTextWithIntArray(String text, int[] nums) {
        System.out.print(text + java.util.Arrays.toString(nums));
    }

    public static void showSpinner() throws InterruptedException {
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

    public static void typeText(String text) throws InterruptedException {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(100);
        }
    }
}
