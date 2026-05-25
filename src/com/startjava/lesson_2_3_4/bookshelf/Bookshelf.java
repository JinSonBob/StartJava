package com.startjava.lesson_2_3_4.bookshelf;

import com.startjava.lesson_2_3_4.exception.EmptyShelfException;
import com.startjava.lesson_2_3_4.exception.FullShelfException;
import java.util.Arrays;

public class Bookshelf {
    public static final int CAPACITY = 10;
    private final Book[] books = new Book[CAPACITY];
    private int booksNum;

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Ошибка: передана пустая ссылка на книгу");
        }
        if (booksNum >= CAPACITY) {
            throw new FullShelfException("Ошибка: в шкафу закончилось место");
        }
        books[booksNum++] = book;
    }

    public Book[] findBook(String targetTitle) {
        if (targetTitle == null || targetTitle.isBlank()) {
            throw new IllegalArgumentException("Ошибка: передано пустое название книги");
        }

        Book[] foundBooks = new Book[3];
        int booksCount = 0;

        for (int i = 0; i < booksNum; i++) {
            if (books[i].getTitle().equals(targetTitle)) {
                if (booksCount == foundBooks.length) {
                    foundBooks = Arrays.copyOf(foundBooks, (int) (foundBooks.length * 1.5));
                }
                foundBooks[booksCount++] = books[i];
            }
        }
        return Arrays.copyOf(foundBooks, booksCount);
    }

    public int removeBook(String targetTitle) {
        if (targetTitle == null || targetTitle.isBlank()) {
            throw new IllegalArgumentException("Ошибка: передано пустое название книги");
        }
        if (booksNum == 0) {
            throw new EmptyShelfException("Ошибка: в шкафу нету книг");
        }

        int booksCount = 0;
        for (int i = 0; i < booksNum; i++) {
            if (books[i].getTitle().equals(targetTitle)) {
                int moveBooksNum = booksNum - i - 1;
                if (moveBooksNum > 0) {
                    System.arraycopy(books, i + 1, books, i, moveBooksNum);
                }
                books[--booksNum] = null;
                booksCount++;
                i--;
            }
        }
        return booksCount;
    }

    public int getBooksNum() {
        return booksNum;
    }

    public Book[] getAllBooks() {
        return Arrays.copyOf(books, booksNum);
    }

    public int getFreeShelvesNum() {
        return CAPACITY - booksNum;
    }

    public void clear() {
        Arrays.fill(books, 0, booksNum, null);
        booksNum = 0;
    }
}
