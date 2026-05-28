package com.startjava.lesson_2_3_4.bookcase;

import java.time.Year;
import java.util.Objects;

public class Book {
    public static final int MIN_PUBLISHED_YEAR = 1800;

    private final String author;
    private final String title;
    private final Year publishedYear;

    public Book(String author, String title, int publishedYear) {
        Objects.requireNonNull(author, "Ошибка: автор книги не может быть null");
        if (author.isBlank()) {
            throw new IllegalArgumentException("Ошибка: не указан автор книги");
        }

        Objects.requireNonNull(title, "Ошибка: название книги не может быть null");
        if (title.isBlank()) {
            throw new IllegalArgumentException("Ошибка: не указано название книги");
        }

        int currYear = Year.now().getValue();
        if (publishedYear < MIN_PUBLISHED_YEAR || publishedYear > currYear) {
            throw new IllegalArgumentException("Ошибка: год издания должен быть между " +
                    MIN_PUBLISHED_YEAR + " и " + currYear);
        }

        this.author = author.trim();
        this.title = title.trim();
        this.publishedYear = Year.of(publishedYear);
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Year getPublishedYear() {
        return publishedYear;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + publishedYear;
    }
}
