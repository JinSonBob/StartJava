package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.EmptyBookcaseException;
import com.startjava.lesson_2_3_4.bookcase.exception.FullBookcaseException;
import java.util.Arrays;
import java.util.Objects;

public class Bookcase {
    private static final int CAPACITY = 10;
    private static final int STARTING_FOUND_BOOKS_LEN = 3;
    private final Book[] books = new Book[CAPACITY];
    private int booksNum;
    private int maxBookLen;

    public void addBook(Book book) {
        Objects.requireNonNull(book, "Ошибка: книга не может быть null");
        if (isFull()) {
            throw new FullBookcaseException("Ошибка: кинга не сохранена. В шкафу закончилось место");
        }
        books[booksNum++] = book;

        int currBookLen = book.toString().length();
        if (currBookLen > maxBookLen) {
            maxBookLen = currBookLen;
        }
    }

    public boolean isFull() {
        return booksNum >= CAPACITY;
    }

    public Book[] findBook(String targetTitle) {
        Objects.requireNonNull(targetTitle, "Ошибка: название книги не может быть null");
        if (targetTitle.isBlank()) {
            throw new IllegalArgumentException("Ошибка: передано пустое название книги");
        }

        Book[] foundBooks = new Book[STARTING_FOUND_BOOKS_LEN];
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
        Objects.requireNonNull(targetTitle, "Ошибка: название книги не может быть null");
        if (targetTitle.isBlank()) {
            throw new IllegalArgumentException("Ошибка: передано пустое название книги");
        }
        if (booksNum == 0) {
            throw new EmptyBookcaseException("Ошибка: в шкафу нету книг");
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

        if (booksCount > 0) {
            calculateMaxBookLen();
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

    public int getMaxBookLen() {
        return maxBookLen;
    }

    public void calculateMaxBookLen() {
        maxBookLen = 0;
        for (int i = 0; i < booksNum; i++) {
            int currLen = books[i].toString().length();
            if (currLen > maxBookLen) {
                maxBookLen = currLen;
            }
        }
    }

    public void clear() {
        Arrays.fill(books, 0, booksNum, null);
        booksNum = 0;
    }
}
