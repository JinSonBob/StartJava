package com.startjava.lesson_2_3_4.bookshelf;

public enum Menu {
    ADD(1, "Добавить книгу"),
    FIND(2, "Найти книгу по названию"),
    REMOVE(3, "Удалить книгу по названию"),
    CLEAR(4, "Очистить шкаф"),
    EXIT(5, "Закончить работу");

    private final int optionNum;
    private final String option;

    Menu(int optionNum, String option) {
        this.optionNum = optionNum;
        this.option = option;
    }

    public int getOptionNum() {
        return optionNum;
    }

    public String getOption() {
        return option;
    }
}
