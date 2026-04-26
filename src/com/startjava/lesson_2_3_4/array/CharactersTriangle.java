package com.startjava.lesson_2_3_4.array;

public class CharactersTriangle {
    static void main() {
        String[] triangleRows = fillArrayWithTriangleRows('0', '9', true);
        printTriangle(triangleRows);

        triangleRows = fillArrayWithTriangleRows('/', '!', false);
        printTriangle(triangleRows);

        triangleRows = fillArrayWithTriangleRows('A', 'J', false);
        printTriangle(triangleRows);
    }

    public static String[] fillArrayWithTriangleRows(char leftBorder, char rightBorder, boolean isAscending) {
        if (!isValidBorders(leftBorder, rightBorder)) return null;

        int height = rightBorder - leftBorder + 1;
        String[] triangleRows = new String[height];
        char currChar = isAscending ? leftBorder : rightBorder;

        for (int i = 0; i < height; i++) {
            triangleRows[i] = buildTriangleRow(currChar, i, height);
            if (isAscending) currChar++;
            else currChar--;
        }
        return triangleRows;
    }

    public static boolean isValidBorders(char leftBorder, char rightBorder) {
        if (leftBorder > rightBorder) {
            System.out.printf("%nОшибка: левая граница (%d) > правой (%d)%n",
                    (int) leftBorder, (int) rightBorder);
            return false;
        }
        return true;
    }

    public static String buildTriangleRow(char rowChar, int rowIndex, int height) {
        StringBuilder triangleRow = new StringBuilder();

        triangleRow.append(" ".repeat(height - 1 - rowIndex));
        triangleRow.append(String.valueOf(rowChar).repeat(rowIndex * 2 + 1));

        return triangleRow.toString();
    }

    public static void printTriangle(String[] triangleRows) {
        if (triangleRows == null) return;

        System.out.println();
        for (String row : triangleRows) {
            System.out.println(row);
        }
        System.out.println();
    }
}
