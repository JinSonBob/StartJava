package com.startjava.lesson_2_3_4.bookshelf;

import static com.startjava.lesson_2_3_4.bookshelf.Book.MIN_PUBLISHING_YEAR;
import static com.startjava.lesson_2_3_4.bookshelf.Bookshelf.CAPACITY;

import java.time.Year;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BookshelfTest {
    public static final int CURR_YEAR = Year.now().getValue();

    static void main() throws InterruptedException {
        printGreeting();
        Scanner scanner = new Scanner(System.in);
        Bookshelf bookshelf = new Bookshelf();
        boolean isRunning = true;

        while (isRunning) {
            printBookshelf(bookshelf);
            printMenu();
            System.out.print("Выберите пункт меню: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                isRunning = chooseOption(choice, bookshelf, scanner);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: значение должго быть целым числом");
                waitEnter();
            }
        }
    }

    private static void printGreeting() throws InterruptedException {
        String text = "Приветствуем вас в проекте \"Книжный шкаф\"";
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(100);
        }
    }

    private static void printBookshelf(Bookshelf bookshelf) {
        int booksNum = bookshelf.getBooksNum();
        if (booksNum == 0) {
            System.out.println("\nШкаф пуст. Вы можете добавить в него первую книгу");
            return;
        }

        int freeShelvesNum = bookshelf.getFreeShelvesNum();
        System.out.printf("В шкафу книг - %d, свободных полок - %d%n",
                booksNum, freeShelvesNum);

        int maxBookLen = 0;
        Book[] allBooks = bookshelf.getAllBooks();
        for (Book book : allBooks) {
            int currBookLen = book.toString().length();
            if (currBookLen > maxBookLen) maxBookLen = currBookLen;
        }

        for (int i = 0; i < booksNum; i++) {
            System.out.printf("|%-" + maxBookLen + "s|%n", allBooks[i].toString());
            System.out.println("|" + "-".repeat(maxBookLen) + "|");
        }
        System.out.println();
    }

    private static void printMenu() {
        System.out.print("""
                1. Добавить книгу
                2. Найти книгу по названию
                3. Удалить книгу по названию
                4. Очистить шкаф
                5. Закончить работу
                """);
    }

    private static boolean chooseOption(int choice, Bookshelf bookshelf, Scanner scanner) {
        switch (choice) {
            case 1 -> addBook(bookshelf, scanner);
            case 2 -> findBook(bookshelf, scanner);
            case 3 -> removeBook(bookshelf, scanner);
            case 4 -> clearBookshelf(bookshelf);
            case 5 -> {
                System.out.println("Завершение программы");
                return false;
            }
            default -> {
                System.out.printf("Ошибка: неверное значение меню (%s). Допустимые значение 1-5", choice);
                waitEnter();
            }
        }
        return true;
    }

    private static void addBook(Bookshelf bookshelf, Scanner scanner) {
        if (bookshelf.getBooksNum() == CAPACITY) {
            System.out.println(("Ошибка: в шкафу закончилось место"));
            waitEnter();
            return;
        }
        try {
            String author = nonEmptyInput(scanner, "автор");
            String title = nonEmptyInput(scanner, "название");
            int year = readYear(scanner);

            Book book = new Book(author, title, year);
            bookshelf.addBook(book);
            System.out.println("Книга успешно добавлена");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        waitEnter();
    }

    private static String nonEmptyInput(Scanner scanner, String bookProperty) {
        while (true) {
            System.out.printf("Введите %s книги: ", bookProperty);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.printf("Ошибка: не %s %s книги%n",
                    bookProperty.equals("название") ? "указано" : "указан", bookProperty);
        }
    }

    private static void findBook(Bookshelf bookshelf, Scanner scanner) {
        String title = nonEmptyInput(scanner, "название");
        try {
            Book book = bookshelf.findBook(title);
            System.out.println("Найдена книга: " + book.toString());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        waitEnter();
    }

    private static int readYear(Scanner scanner) {
        while (true) {
            System.out.print("Введите год издания: ");
            String input = scanner.nextLine().trim();
            try {
                int year = Integer.parseInt(input);
                if (year < MIN_PUBLISHING_YEAR || year > CURR_YEAR) {
                    System.out.printf("Ошибка: год издания должен быть между %d и %d%n",
                            MIN_PUBLISHING_YEAR, CURR_YEAR);
                    continue;
                }
                return year;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: значение должно быть целым числом");
            }
        }
    }

    private static void removeBook(Bookshelf bookshelf, Scanner scanner) {
        String title = nonEmptyInput(scanner, "название");
        try {
            bookshelf.removeBook(title);
            System.out.println("Книга успешно удалена");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        waitEnter();
    }

    private static void clearBookshelf(Bookshelf bookshelf) {
        bookshelf.clearBookShelf();
        System.out.println("Шкаф очищен от всех книг");
        waitEnter();
    }

    private static void waitEnter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nДля продолжения работы нажмите клавишу <Enter>");
        scanner.nextLine();
    }
}
