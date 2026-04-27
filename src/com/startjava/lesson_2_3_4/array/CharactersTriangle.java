package com.startjava.lesson_2_3_4.array;

public class CharactersTriangle {
    static void main() {
        char[] triangleChars = fillChars('0', '9', true);
        String triangle = buildTriangle(triangleChars);
        printTriangle(triangle);

        triangleChars = fillChars('/', '!', false);
        triangle = buildTriangle(triangleChars);
        printTriangle(triangle);

        triangleChars = fillChars('A', 'J', false);
        triangle = buildTriangle(triangleChars);
        printTriangle(triangle);
    }

    private static char[] fillChars(char leftBorder, char rightBorder, boolean isAscending) {
        if (!isValidBorders(leftBorder, rightBorder)) return null;

        int height = rightBorder - leftBorder + 1;
        char[] triangleChars = new char[height];
        char currChar = isAscending ? leftBorder : rightBorder;

        for (int i = 0; i < height; i++) {
            triangleChars[i] = isAscending ? currChar++ : currChar--;
        }
        return triangleChars;
    }

    private static boolean isValidBorders(char leftBorder, char rightBorder) {
        if (leftBorder > rightBorder) {
            System.out.printf("%nОшибка: левая граница (%d) > правой (%d)%n",
                    (int) leftBorder, (int) rightBorder);
            return false;
        }
        return true;
    }

    private static String buildTriangle(char[] triangleChars) {
        if (triangleChars == null) return null;

        StringBuilder triangle = new StringBuilder();
        int height = triangleChars.length;

        for (int i = 0; i < height; i++) {
            triangle.append(" ".repeat(height - 1 - i));
            triangle.append(String.valueOf(triangleChars[i]).repeat(i * 2 + 1));
            triangle.append("\n");
        }

        return triangle.toString();
    }

    private static void printTriangle(String triangle) {
        if (triangle == null) return;
        System.out.println("\n" + triangle);
    }
}
