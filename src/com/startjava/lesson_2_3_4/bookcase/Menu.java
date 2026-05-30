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

    public static Menu getChoice(int menuNum, Menu[] currMenuItems) {
        if (menuNum < 1 || menuNum > currMenuItems.length) {
            throw new InvalidMenuOptionException(
                    String.format("Ошибка: неверное значение меню (%d). Допустимые значения: 1-%d",
                            menuNum, currMenuItems.length)
            );
        }
        return currMenuItems[menuNum - 1];
    }
}
