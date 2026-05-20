package com.startjava.lesson_2_3_4.bookshelf;

import static com.startjava.lesson_2_3_4.bookshelf.BookshelfTest.CURR_YEAR;

public class Book {
    private final String author;
    private final String title;
    private final int year;

    public Book(String author, String title, int year) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Ошибка: не указан автор книги");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Ошибка: не указано название книги");
        }
        if (year < 1800 || year > CURR_YEAR) {
            throw new IllegalArgumentException("Ошибка: год издания должен быть между 1800 и " + CURR_YEAR);
        }
        this.author = author.trim();
        this.title = title.trim();
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return (this.author + ", " + this.title + ", " + this.year);
    }
}
