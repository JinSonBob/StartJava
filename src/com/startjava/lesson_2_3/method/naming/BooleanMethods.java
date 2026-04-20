package com.startjava.lesson_2_3.method.naming;

public class BooleanMethods {
    public boolean isContinuing() {
        System.out.print("\n" + Methods.getCurrentMethodName() +
                "() -> программа выполняется далее?: ");
        return true;
    }

    public boolean hasUniqueDigit() {
        System.out.print("\n" + Methods.getCurrentMethodName() +
                "() -> последовательность содержит уникальную цифру?: ");
        return true;
    }

    public boolean isEnteredLetter() {
        System.out.print("\n" + Methods.getCurrentMethodName() +
                "() -> пользователь ввел букву?: ");
        return false;
    }

    public boolean hasEqualDigits() {
        System.out.print("\n" + Methods.getCurrentMethodName() +
                "() -> в проверяемых числах, есть равные цифры?: ");
        return false;
    }

    public boolean hasAttemptsLeft() {
        System.out.print("\n" + Methods.getCurrentMethodName() +
                "() -> в игре \"Марио\" остались попытки?: ");
        return true;
    }

    public boolean isEmptyString() {
        System.out.print("\n" + Methods.getCurrentMethodName() +
                "() -> пользователь ввёл пустую строку?: ");
        return false;
    }

    public boolean isEvenNumber() {
        System.out.print("\n" + Methods.getCurrentMethodName() +
                "() -> на кубике, который бросил компьютер, выпало четное число?: ");
        return false;
    }

    public boolean isValidPath() {
        System.out.print("\n" + Methods.getCurrentMethodName() +
                "() -> путь до файла, который вы ищите на ssd, действительный?: ");
        return false;
    }

    public boolean isExistFile() {
        System.out.print("\n" + Methods.getCurrentMethodName() +
                "() -> файл по указанному адресу существует?: ");
        return true;
    }
}