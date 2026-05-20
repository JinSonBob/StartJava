package com.startjava.lesson_2_3_4.bookshelf;

import static com.startjava.lesson_2_3_4.bookshelf.BookshelfTest.MAX_BOOKS;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Bookshelf {
    private int booksNum;
    private Book[] books = new Book[MAX_BOOKS];

    public void addBook(Book book) {
        if (booksNum == MAX_BOOKS) {
            throw new ArrayIndexOutOfBoundsException("Ошибка: в шкафу закончилось место");
        }
        books[booksNum++] = book;
    }

    public Book[] getAllBooks() {
        return Arrays.copyOf(books, booksNum);
    }

    public int getBooksNum() {
        return booksNum;
    }

    public int getFreeShelvesNum() {
        return MAX_BOOKS - booksNum;
    }

    public Book getBook(String targetTitle) {
        int bookIndex = findBookIndex(targetTitle);
        return books[bookIndex];
    }

    public void removeBook(String targetTitle) {
        int bookIndex = findBookIndex(targetTitle);

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
        throw new NoSuchElementException(String.format("Ошибка: книга %s не найдена", targetTitle));
    }

    public void clearBookShelf() {
        Arrays.fill(books, 0, booksNum, null);
        booksNum = 0;
    }
}
