package com.startjava.lesson_2_3_4.bookshelf;

import java.util.Arrays;
import java.util.NoSuchElementException;

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

    public Book findBook(String targetTitle) {
        if (targetTitle == null || targetTitle.isBlank()) {
            throw new IllegalArgumentException("Ошибка: передано пустое название книги");
        }

        int bookIndex = findBookIndex(targetTitle);
        if (bookIndex == -1) {
            throw new NoSuchElementException(String.format("Ошибка: книга %s не найдена", targetTitle));
        }
        return books[bookIndex];
    }

    public void removeBook(String targetTitle) {
        if (targetTitle == null || targetTitle.isBlank()) {
            throw new IllegalArgumentException("Ошибка: передано пустое название книги");
        }

        int bookIndex = findBookIndex(targetTitle);
        if (bookIndex == -1) {
            throw new NoSuchElementException(String.format("Ошибка: книга %s не найдена", targetTitle));
        }

        int moveBooksNum = booksNum - bookIndex - 1;
        if (moveBooksNum > 0) {
            System.arraycopy(books, bookIndex + 1, books, bookIndex, moveBooksNum);
        }
        books[--booksNum] = null;
    }

    private int findBookIndex(String targetTitle) {
        for (int i = 0; i < booksNum; i++) {
            if (books[i].getTitle().equals(targetTitle)) {
                return i;
            }
        }
        return -1;
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
