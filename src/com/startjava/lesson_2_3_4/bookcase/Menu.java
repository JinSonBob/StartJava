package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.InvalidMenuOptionException;

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

    public static Menu getChoice(int choice, Menu[] currMenu) {
        if (choice < 1 || choice > currMenu.length) {
            throw new InvalidMenuOptionException(
                    String.format("Ошибка: неверное значение меню (%d). Допустимые значения: 1-%d",
                            choice, currMenu.length)
            );
        }
        return currMenu[choice - 1];
    }
}
