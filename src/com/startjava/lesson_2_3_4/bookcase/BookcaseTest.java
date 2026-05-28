package com.startjava.lesson_2_3_4.bookcase;

import static com.startjava.lesson_2_3_4.bookcase.Book.MIN_PUBLISHED_YEAR;

import com.startjava.lesson_2_3_4.bookcase.exception.EmptyBookcaseException;
import com.startjava.lesson_2_3_4.bookcase.exception.FullBookcaseException;
import com.startjava.lesson_2_3_4.bookcase.exception.InvalidMenuOptionException;
import java.time.Year;
import java.util.Scanner;

public class BookcaseTest {
    static void main() throws InterruptedException {
        printGreeting();
        Scanner scanner = new Scanner(System.in);
        Bookcase bookcase = new Bookcase();
        boolean isRunning = true;

        while (isRunning) {
            printBookshelf(bookcase);

            Menu[] currMenu = getMenuOptions(bookcase);
            printMenu(currMenu);

            System.out.print("Выберите пункт меню: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                Menu selectedOption = Menu.getChoice(choice, currMenu);
                isRunning = chooseOption(selectedOption, bookcase, scanner);
            } catch (InvalidMenuOptionException e) {
                System.out.println(e.getMessage());
                waitEnter(scanner);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: значение должно быть целым числом");
                waitEnter(scanner);
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

    private static void printBookshelf(Bookcase bookcase) {
        int booksNum = bookcase.getBooksNum();
        if (booksNum == 0) {
            System.out.println("\nШкаф пуст. Вы можете добавить в него первую книгу");
            return;
        }

        int freeShelvesNum = bookcase.getFreeShelvesNum();
        System.out.printf("В шкафу книг - %d, свободных полок - %d%n",
                booksNum, freeShelvesNum);

        Book[] allBooks = bookcase.getAllBooks();

        int maxBookLen = bookcase.getMaxBookLen();

        for (Book book : allBooks) {
            System.out.printf("|%-" + maxBookLen + "s|%n", book.toString());
            System.out.println("|" + "-".repeat(maxBookLen) + "|");
        }
        System.out.println();
    }

    private static Menu[] getMenuOptions(Bookcase bookcase) {
        if (bookcase.getBooksNum() == 0) {
            return new Menu[]{Menu.ADD, Menu.EXIT};
        }
        if (bookcase.isFull()) {
            return new Menu[]{Menu.FIND, Menu.REMOVE, Menu.CLEAR, Menu.EXIT};
        }
        return Menu.values();
    }

    private static void printMenu(Menu[] currMenu) {
        for (int i = 0; i < currMenu.length; i++) {
            System.out.printf("%d. %s%n", i + 1, currMenu[i].getOption());
        }
    }

    private static boolean chooseOption(Menu choice, Bookcase bookcase, Scanner scanner) {
        switch (choice) {
            case ADD -> addBook(bookcase, scanner);
            case FIND -> findBook(bookcase, scanner);
            case REMOVE -> removeBook(bookcase, scanner);
            case CLEAR -> clear(bookcase, scanner);
            case EXIT -> {
                System.out.println("Завершение программы");
                return false;
            }
            default -> throw new InvalidMenuOptionException("Ошибка: допустимые значения 1-5");
        }
        return true;
    }

    private static void addBook(Bookcase bookcase, Scanner scanner) {
        if (bookcase.isFull()) {
            System.out.println(("Ошибка: в шкафу закончилось место"));
            waitEnter(scanner);
            return;
        }
        try {
            String author = inputBookProperty(scanner, "автор");
            String title = inputBookProperty(scanner, "название");
            int year = inputYear(scanner);

            Book book = new Book(author, title, year);
            bookcase.addBook(book);
            System.out.println("Книга успешно добавлена");
        } catch (IllegalArgumentException | FullBookcaseException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        waitEnter(scanner);
    }

    private static int inputYear(Scanner scanner) {
        while (true) {
            System.out.print("Введите год издания: ");
            String input = scanner.nextLine().trim();
            try {
                int year = Integer.parseInt(input);
                int currYear = Year.now().getValue();
                if (year < MIN_PUBLISHED_YEAR || year > currYear) {
                    System.out.printf("Ошибка: год издания должен быть между %d и %d%n",
                            MIN_PUBLISHED_YEAR, currYear);
                    continue;
                }
                return year;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: значение должно быть целым числом");
            }
        }
    }

    private static void findBook(Bookcase bookcase, Scanner scanner) {
        String title = inputBookProperty(scanner, "название");
        try {
            Book[] foundBooks = bookcase.findBook(title);
            if (foundBooks.length > 0) {
                System.out.println("Найдены книги");
                for (Book book : foundBooks) {
                    System.out.println(book.toString());
                }
            } else {
                System.out.printf("Книга \"%s\" не найдена%n", title);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        waitEnter(scanner);
    }

    private static void removeBook(Bookcase bookcase, Scanner scanner) {
        String title = inputBookProperty(scanner, "название");
        try {
            int removedBooks = bookcase.removeBook(title);
            if (removedBooks > 0) {
                System.out.println("Удалено книг: " + removedBooks);
            } else {
                System.out.printf("Ошибка: книга \"%s\" не найдена%n", title);
            }
        } catch (EmptyBookcaseException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        waitEnter(scanner);
    }

    private static String inputBookProperty(Scanner scanner, String bookProperty) {
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

    private static void clear(Bookcase bookcase, Scanner scanner) {
        bookcase.clear();
        System.out.println("Шкаф очищен от всех книг");
        waitEnter(scanner);
    }

    private static void waitEnter(Scanner scanner) {
        System.out.println("\nДля продолжения работы нажмите клавишу <Enter>");
        scanner.nextLine();
    }
}
