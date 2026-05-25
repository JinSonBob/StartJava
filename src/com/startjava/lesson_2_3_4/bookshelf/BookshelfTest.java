package com.startjava.lesson_2_3_4.bookshelf;

import static com.startjava.lesson_2_3_4.bookshelf.Book.MIN_PUBLISHED_YEAR;
import static com.startjava.lesson_2_3_4.bookshelf.Bookshelf.CAPACITY;

import com.startjava.lesson_2_3_4.exception.EmptyShelfException;
import com.startjava.lesson_2_3_4.exception.FullShelfException;
import com.startjava.lesson_2_3_4.exception.InvalidMenuOptionException;
import java.time.Year;
import java.util.Scanner;

public class BookshelfTest {
    private static int maxBookLen = 0;
    private static boolean isShelfChanged = true;

    static void main() throws InterruptedException {
        printGreeting();
        Scanner scanner = new Scanner(System.in);
        Bookshelf bookshelf = new Bookshelf();
        boolean isRunning = true;

        while (isRunning) {
            printBookshelf(bookshelf);

            Menu[] currMenu = getMenuOptions(bookshelf);
            printMenu(currMenu);

            System.out.print("Выберите пункт меню: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                if (choice < 1 || choice > currMenu.length) {
                    throw new ArrayIndexOutOfBoundsException(
                            String.format("Ошибка: неверное значение меню (%d). Допустимые значения: 1-%d",
                                    choice, currMenu.length)
                    );
                }
                Menu selectedOption = currMenu[choice - 1];
                isRunning = chooseOption(selectedOption, bookshelf, scanner);
            } catch (InvalidMenuOptionException | ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                waitEnter();
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: значение должно быть целым числом");
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

        Book[] allBooks = bookshelf.getAllBooks();

        if (isShelfChanged) {
            maxBookLen = 0;
            for (Book book : allBooks) {
                int currBookLen = book.toString().length();
                if (currBookLen > maxBookLen) maxBookLen = currBookLen;
            }
            isShelfChanged = false;
        }

        for (Book book : allBooks) {
            System.out.printf("|%-" + maxBookLen + "s|%n", book.toString());
            System.out.println("|" + "-".repeat(maxBookLen) + "|");
        }
        System.out.println();
    }

    private static Menu[] getMenuOptions(Bookshelf bookshelf) {
        if (bookshelf.getBooksNum() == 0) {
            return new Menu[]{Menu.ADD, Menu.EXIT};
        } else if (bookshelf.getBooksNum() == CAPACITY) {
            return new Menu[]{Menu.FIND, Menu.REMOVE, Menu.CLEAR, Menu.EXIT};
        } else {
            return Menu.values();
        }
    }

    private static void printMenu(Menu[] currMenu) {
        for (int i = 0; i < currMenu.length; i++) {
            System.out.printf("%d. %s%n", i + 1, currMenu[i].getOption());
        }
    }

    private static boolean chooseOption(Menu choice, Bookshelf bookshelf, Scanner scanner) {
        switch (choice) {
            case ADD -> addBook(bookshelf, scanner);
            case FIND -> findBook(bookshelf, scanner);
            case REMOVE -> removeBook(bookshelf, scanner);
            case CLEAR -> clear(bookshelf);
            case EXIT -> {
                System.out.println("Завершение программы");
                return false;
            }
            default -> throw new InvalidMenuOptionException("Ошибка: допустимые значения 1-5");
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
            String author = inputBookProperty(scanner, "автор");
            String title = inputBookProperty(scanner, "название");
            int year = inputYear(scanner);

            Book book = new Book(author, title, year);
            bookshelf.addBook(book);
            System.out.println("Книга успешно добавлена");

            isShelfChanged = true;
        } catch (IllegalArgumentException | FullShelfException e) {
            System.out.println(e.getMessage());
        }
        waitEnter();
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

    private static void findBook(Bookshelf bookshelf, Scanner scanner) {
        String title = inputBookProperty(scanner, "название");
        try {
            Book[] foundBooks = bookshelf.findBook(title);
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
        waitEnter();
    }

    private static void removeBook(Bookshelf bookshelf, Scanner scanner) {
        String title = inputBookProperty(scanner, "название");
        try {
            int removedBooks = bookshelf.removeBook(title);
            if (removedBooks > 0) {
                System.out.println("Удалено книг: " + removedBooks);
                isShelfChanged = true;
            } else {
                System.out.printf("Ошибка: книга \"%s\" не найдена%n", title);
            }
        } catch (EmptyShelfException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        waitEnter();
    }

    private static void clear(Bookshelf bookshelf) {
        bookshelf.clear();
        System.out.println("Шкаф очищен от всех книг");
        isShelfChanged = true;
        waitEnter();
    }

    private static void waitEnter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nДля продолжения работы нажмите клавишу <Enter>");
        scanner.nextLine();
    }
}
