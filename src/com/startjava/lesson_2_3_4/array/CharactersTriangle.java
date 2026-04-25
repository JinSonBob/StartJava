package com.startjava.lesson_2_3_4.array;

public class CharactersTriangle {
    static void main() {
        printTriangle('0', '9', true);
        printTriangle('/', '!', false);
        printTriangle('A', 'J', false);
    }

    public static void printTriangle(char leftBorder, char rightBorder, boolean direction) {
        if (!isValidBorders(leftBorder, rightBorder)) return;

        int height = rightBorder - leftBorder + 1;

        if (direction) System.out.println(buildTriangle(leftBorder, height, direction));
        else System.out.println(buildTriangle(rightBorder, height, direction));
    }

    public static boolean isValidBorders(char leftBorder, char rightBorder) {
        if (leftBorder > rightBorder) {
            System.out.printf("%nОшибка: левая граница (%d) > правой (%d)%n",
                    (int) leftBorder, (int) rightBorder);
            return false;
        }
        return true;
    }

    public static StringBuilder buildTriangle(char firstChar, int height, boolean direction) {
        StringBuilder triangle = new StringBuilder().append("\n");

        for (int i = 0; i < height; i++) {
            String charRepeat = String.valueOf(firstChar);

            triangle.append(" ".repeat(height - 1 - i));
            triangle.append(charRepeat.repeat(i * 2 + 1));
            triangle.append("\n");

            if (direction) firstChar++;
            else firstChar--;
        }

        return triangle;
    }
}
