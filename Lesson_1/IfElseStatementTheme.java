import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        // 1.ПЕРЕВОД ПСЕВДОКОДА НА ЯЗЫК JAVA
        System.out.println("\n1.ПЕРЕВОД ПСЕВДОКОДА НА ЯЗЫК JAVA");

        var sexMale = true;
        var age = 18;
        var height = 1.9f;

        if (!sexMale) {
            System.out.println("Женский пол");
        } else {
            System.out.println("Мужской пол");
        }

        if (age > 18) {
            System.out.println("Возраст > 18");
        } else {
            System.out.println("Возраст <= 18");
        }

        if (height < 1.8) {
            System.out.println("Рост < 1.8");
        } else {
            System.out.println("Рост >= 1.8");
        }

        // 2.ПОИСК БОЛЬШЕГО ЧИСЛА ШАГОВ
        System.out.println("\n2.ПОИСК БОЛЬШЕГО ЧИСЛА ШАГОВ");

        var stepsYesterday = 14574;
        var stepsToday = 7985;

        System.out.println("Количество шагов вчера: " + stepsYesterday +
                "\nКоличество шагов сегодня: " + stepsToday);

        if (stepsToday > stepsYesterday) {
            System.out.println("Сегодняшнее количество шагов больше вчерашнего");
        } else if (stepsToday < stepsYesterday) {
            System.out.println("Сегодняшнее количество шагов меньше вчерашнего");
        } else {
            System.out.println("Сегодняшнее количество шагов равно вчерашнему");
        }

        // 3.ПРОВЕРКА КОЛИЧЕСТВА ГОСТЕЙ
        System.out.println("\n3.ПРОВЕРКА КОЛИЧЕСТВА ГОСТЕЙ");

        var guestCount = -112;

        if (guestCount == 0) {
            System.out.printf("Пока никто не записался на мероприятие!");
        } else if (guestCount < 0) {
            System.out.println("Ошибка! Число посетителей отрицательно.");
        } else if (guestCount % 2 == 0) {
            System.out.println("Записалось " + guestCount + " гостей. Можно формировать пары для конкурсов.");
        } else if (guestCount % 2 != 0) {
            System.out.println("Записалось " + guestCount + " гостей. Нужны индивидуальные задания.");
        }

        // 4.ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА
        System.out.println("\n4.ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА");

        var nickname = "Andre";
        var firstChar = nickname.charAt(0);

        // С использованием диапазона кодов
        System.out.println("\nС использованием диапазона кодов");

        if (((int) firstChar >= 97) && ((int) firstChar <= 122)) {
            System.out.println("Имя " + nickname + " начинается с маленькой буквы '" + firstChar + "'");
        } else if (((int) firstChar >= 65) && ((int) firstChar <= 90)) {
            System.out.println("Имя " + nickname + " начинается с большой буквы '" + firstChar + "'");
        } else if (((int) firstChar >= 48) && ((int) firstChar <= 57)) {
            System.out.println("Имя " + nickname + " начинается с цифры '" + firstChar + "'");
        } else {
            System.out.println("Имя " + nickname + " начинается с символа '" + firstChar + "'");
        }

        // С использованием методов класса Character
        System.out.println("\nС использованием методов класса Character");

        if (Character.isLowerCase(firstChar)) {
            System.out.println("Имя " + nickname + " начинается с маленькой буквы '" + firstChar + "'");
        } else if (Character.isUpperCase(firstChar)) {
            System.out.println("Имя " + nickname + " начинается с большой буквы '" + firstChar + "'");
        } else if (Character.isDigit(firstChar)) {
            System.out.println("Имя " + nickname + " начинается с цифры '" + firstChar + "'");
        } else {
            System.out.println("Имя " + nickname + " начинается с символа '" + firstChar + "'");
        }

        // 5.ИНВЕНТАРИЗАЦИЯ
        System.out.println("\n5.ИНВЕНТАРИЗАЦИЯ");

        var baseSerialId = 189;
        var pcSerialId = 169;
        var baseSerialIdText = String.valueOf(baseSerialId);
        var pcSerialIdText = String.valueOf(pcSerialId);
        var tmp = "";
        var overlap = "";

        if (baseSerialIdText.equals(pcSerialIdText)) {
            System.out.println("[№" + pcSerialIdText + "]: компьютер на 3-м этаже в кабинете 2");
        } else if (baseSerialIdText != pcSerialIdText) {
            tmp = (pcSerialIdText.charAt(0) == baseSerialIdText.charAt(0))
                    ? pcSerialIdText.charAt(0) + "" : "_";
            overlap += tmp;
            tmp = (pcSerialIdText.charAt(1) == baseSerialIdText.charAt(1))
                    ? pcSerialIdText.charAt(1) + "" : "_";
            overlap += tmp;
            tmp = (pcSerialIdText.charAt(2) == baseSerialIdText.charAt(2))
                    ? pcSerialIdText.charAt(2) + "" : "_";
            overlap += tmp;

            if (overlap.equals("___")) {
                System.out.println("[№" + pcSerialId + "]: оборудование не идентифицировано");
            } else {
                System.out.printf("""
                        Нет полного совпадения:
                        База данных: [№%s]
                        Фактический: [№%s]
                        """.formatted(baseSerialId, overlap));
            }
        }

        // 6.ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %
        System.out.println("\n6.ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %");

        // Без округления результата с использованием float
        System.out.println("\nБез округления результата с использованием float");

        var banked = 321123.79f;
        var interest = 0f;

        if (banked < 100000) {
            interest = banked * 0.05f;
        } else if (banked <= 300000) {
            interest = banked * 0.07f;
        } else {
            interest = banked * 0.1f;
        }

        System.out.println("""
                Сумма вклада: %f
                Сумма начисленного %%: %f
                Итоговая сумма: %f
                """.formatted(banked, interest, banked + interest));

        // С округлением результата с использованием BigDecimal
        System.out.println("С округлением результата с использованием BigDecimal");

        var bankedBd = new BigDecimal("321123.79");
        var interestBd = new BigDecimal("0");

        if (bankedBd.compareTo(new BigDecimal("100000")) < 0) {
            interestBd = bankedBd.multiply(new BigDecimal("0.05")).setScale(2, RoundingMode.HALF_UP);
        } else if (bankedBd.compareTo(new BigDecimal("300000")) <= 0) {
            interestBd = bankedBd.multiply(new BigDecimal("0.07")).setScale(2, RoundingMode.HALF_UP);
        } else {
            interestBd = bankedBd.multiply(new BigDecimal("0.1")).setScale(2, RoundingMode.HALF_UP);
        }

        System.out.println("""
                Сумма вклада: %s
                Сумма начисленного %%: %s
                Итоговая сумма: %s
                """.formatted(bankedBd, interestBd, bankedBd.add(interestBd)));

        // 7.ОПРЕДЕЛЕНИЕ ОЦЕНКИ ПО ПРЕДМЕТАМ
        System.out.println("7.ОПРЕДЕЛЕНИЕ ОЦЕНКИ ПО ПРЕДМЕТАМ");

        var historyPercent = 59;
        var programingPercent = 92;

        var historyMark = historyPercent <= 60
                ? 2 : historyPercent <= 73
                ? 3 : historyPercent <= 91
                ? 4 : 5;
        var programingMark = programingPercent <= 60
                ? 2 : programingPercent <= 73
                ? 3 : programingPercent <= 91
                ? 4 : 5;

        var averageMark = ((float) programingMark + (float) historyMark) / 2;
        var averagePercent = ((float) programingPercent + (float) historyPercent) / 2;

        System.out.println("""
                Оценка по истории: %d
                Оценка по программированию: %d
                Средний балл по предметам: %.1f
                Средний %% по предметам: %.1f
                """.formatted(historyMark, programingMark, averageMark, averagePercent));

        // 8.РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ
        System.out.println("8.РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ");

        var monthlySales = new BigDecimal("13025.233");
        var rent = new BigDecimal("5123.018");
        var prodCost = new BigDecimal("9001.729");
        var months = new BigDecimal("12");
        var total = monthlySales.multiply(months);
        total = total.subtract(rent.multiply(months));
        total = total.subtract(prodCost.multiply(months)).setScale(2, RoundingMode.HALF_UP);

        if (total.compareTo(new BigDecimal("0")) > 0) {
            System.out.println("Прибыль за год: +" + total + "руб.");
        } else {
            System.out.println("Прибыль за год: " + total + "руб.");
        }
    }
}