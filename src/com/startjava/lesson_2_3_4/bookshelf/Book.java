package com.startjava.lesson_2_3_4.bookshelf;

import static com.startjava.lesson_2_3_4.bookshelf.BookshelfTest.CURR_YEAR;

import java.time.Year;

public class Book {
    public static final int MIN_PUBLISHING_YEAR = 1800;

    private final String author;
    private final String title;
    private final Year publishingYear;

    public Book(String author, String title, int publishingYear) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Ошибка: не указан автор книги");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Ошибка: не указано название книги");
        }
        if (publishingYear < MIN_PUBLISHING_YEAR || publishingYear > CURR_YEAR) {
            throw new IllegalArgumentException("Ошибка: год издания должен быть между " +
                    MIN_PUBLISHING_YEAR + " и " + CURR_YEAR);
        }
        this.author = author.trim();
        this.title = title.trim();
        this.publishingYear = Year.of(publishingYear);
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Year getPublishingYear() {
        return publishingYear;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + publishingYear;
    }
}
