package com.startjava.lesson_2.method.naming;

public class NonBooleanMethods {
    public void findLongestWord() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> найдено самое длинное слово в предложении из книги по Java");
    }

    public void chooseMenuOption() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> выбран пункт меню в текстовом редакторе на macOS");
    }

    public void calculateAverageMark() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> вычисленно среднее значение оценок в школе №1234");
    }

    public void countUniqueWords() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> подсчитано количество уникальных слов в \"Война и Мир\"");
    }

    public void printErrorMessage() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> выведено сообщение об ошибке");
    }

    public void syncCloudData() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> данные синхронизированы с облачным хранилищем");
    }

    public void restoreBackup() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> восстановлены данные из резервной копии от 11.03.2024");
    }

    public void pauseDownload() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> приостановлена загрузка mp3-файла группы \"Ария\"");
    }

    public void resetSettings() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> сброшены настройки до заводских для пылесоса Mi");
    }

    public void writeToFile() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> записано содержимое в файл по указанному пути на флешку");
    }

    public void convertTemperature() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> преобразована температура из Цельсия в Фаренгейт");
    }

    public void inputMathExpression() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> введено математическое выражение с тремя аргументами");
    }

    public void chooseWinner() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> выявлен победитель среди гонщиков игры \"Need For Speed\"");
    }

    public void findBookByAuthor() {
        System.out.println(Methods.getCurrentMethodName() +
                "() -> найдена книга по имени писателя");
    }
}