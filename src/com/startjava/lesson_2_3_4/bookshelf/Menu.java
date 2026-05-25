package com.startjava.lesson_2_3_4.bookshelf;

public enum Menu {
    ADD("Добавить книгу"),
    FIND("Найти книгу по названию"),
    REMOVE("Удалить книгу по названию"),
    CLEAR("Очистить шкаф"),
    EXIT("Закончить работу");

    private final String option;

    Menu(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
