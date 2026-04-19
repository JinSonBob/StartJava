package com.startjava.lesson_1.base;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class VariablesTheme {
    public static void main(String[] args) {
        final var startTime = System.nanoTime();
        final var startLocalTime = LocalTime.now();

        // 1.ВЫВОД ASCII-ГРАФИКИ
        System.out.println("\n1.ВЫВОД ASCII-ГРАФИКИ\n");

        System.out.println(String.join("\n",
                "                     /\\",
                "   J    a  v     v  /  \\",
                "   J   a a  v   v  /_( )\\",
                "J  J  aaaaa  V V  /      \\",
                " JJ  a     a  V  /___/\\___\\"
                ));

        System.out.println("""
                         /\\            
                   J    /  \\  v     v  a
                   J   /_( )\\  v   v  a a
                J  J  /      \\  V V  aaaaa
                 JJ  /___/\\___\\  V  a     a
                """);

        // 2.РАСЧЕТ СТОИМОСТИ ТОВАРА
        System.out.println("\n2.РАСЧЕТ СТОИМОСТИ ТОВАРА\n");

        // Первый способ без округления
        System.out.println("Первый способ без округления");

        float penPrice = 105.5f;
        float bookPrice = 235.23f;
        float discount = 0.11f;

        float totalSum = penPrice + bookPrice;
        float discountSum = totalSum * discount;
        float discountPrice = totalSum - discountSum;

        System.out.println("Стоимость товаров без скидки = " + totalSum);
        System.out.println("Сумма скидки = " + discountSum);
        System.out.println("Стоимость товаров со скидкой = " + discountPrice);

        // Второй способ с BigDecimal
        System.out.println("\nВторой способ с BigDecimal");

        var penPriceBd = new BigDecimal("105.5");
        var bookPriceBd = new BigDecimal("235.23");
        var discountBd = new BigDecimal("0.11");

        var totalSumBd = penPriceBd.add(bookPriceBd).setScale(2, RoundingMode.HALF_UP);
        var discountSumBd = totalSumBd.multiply(discountBd).setScale(2, RoundingMode.HALF_UP);
        var discountPriceBd = totalSumBd.subtract(discountSumBd).setScale(2, RoundingMode.HALF_UP);

        System.out.println("Стоимость товаров без скидки = " + totalSumBd);
        System.out.println("Сумма скидки = " + discountSumBd);
        System.out.println("Стоимость товаров со скидкой = " + discountPriceBd);

        // 3.ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ
        System.out.println("\n3.ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ");

        int firstNum = 2;
        int secondNum = 5;
        int tmp = 0;

        // Метод: третья переменная
        System.out.println("\nМетод: третья переменная");
        System.out.println("Исходные: First num = " + firstNum + ", Second num = " + secondNum);

        tmp = firstNum;
        firstNum = secondNum;
        secondNum = tmp;

        System.out.println("Результат: First num = " + firstNum + ", Second num = " + secondNum);

        // Метод: Арифметические операции
        System.out.println("\nМетод: Арифметические операции");

        firstNum += secondNum;
        secondNum = firstNum - secondNum;
        firstNum -= secondNum;

        System.out.println("Результат: First num = " + firstNum + ", Second num = " + secondNum);
        
        // Метод: побитовой операции ^
        System.out.println("\nМетод: побитовой операции ^");

        firstNum ^= secondNum;
        secondNum ^= firstNum;
        firstNum ^= secondNum;

        System.out.println("Результат: First num = " + firstNum + ", Second num = " + secondNum);

        // 4.ДЕКОДИРОВАНИЕ СООБЩЕНИЯ
        System.out.println("\n4.ДЕКОДИРОВАНИЕ СООБЩЕНИЯ\n");

        int code1 = 1055;
        int code2 = 1088;
        int code3 = 1080;
        int code4 = 1074;
        int code5 = 1077;
        int code6 = 1090;

        System.out.printf("%d%8d%8d%8d%8d%8d\n", code1, code2, code3, code4, code5, code6);

        System.out.printf("%c%8c%8c%8c%8c%8c", code1, code2, code3, code4, code5, code6);

        // 5.АНАЛИЗ КОДА ТОВАРА
        System.out.println("\n\n5.АНАЛИЗ КОДА ТОВАРА\n");

        int productCode = 842;

        int productCategory = productCode / 100;
        int productSubcategory = productCode / 10 % 10;
        int packageType = productCode % 10;

        int checksum = productCategory + productSubcategory + packageType;
        int validationCode = productCategory * productSubcategory * packageType;

        System.out.println("""
                Код товара: %d
                  категория товара - %s
                  подкатегория - %s
                  тип упаковки - %s
                Контрольная сумма = %d
                Проверочный код = %d
                """.formatted(productCode, productCategory, productSubcategory, 
                        packageType, checksum, validationCode));

        // 6.ТЕСТИРОВАНИЕ ДАТЧИКОВ ПЕРЕД ЗАПУСКОМ РАКЕТЫ
        System.out.println("6.ТЕСТИРОВАНИЕ ДАТЧИКОВ ПЕРЕД ЗАПУСКОМ РАКЕТЫ\n");
        
        byte temperature = Byte.MAX_VALUE;

        System.out.printf("""
                [Температура], °C:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(temperature, ++temperature, --temperature));

        short pressure = Short.MAX_VALUE;

        System.out.printf("""
                [Давление], Па:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(pressure, ++pressure, --pressure));

        char statusCode = Character.MAX_VALUE;

        System.out.printf("""
                [Код состояния системы]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted((int) statusCode, (int) ++statusCode, (int) --statusCode));

        int traveledDistance = Integer.MAX_VALUE;

        System.out.printf("""
                [Пройденное расстояние], м:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(traveledDistance, ++traveledDistance, --traveledDistance));

        long timeSinceStart = Long.MAX_VALUE;

        System.out.printf("""
                [Время с момента старта], с:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(timeSinceStart, ++timeSinceStart, --timeSinceStart));

        // 7.ВЫВОД ПАРАМЕТРОВ JVM И ОС
        System.out.println("\n7.ВЫВОД ПАРАМЕТРОВ JVM И ОС\n");
        
        var rt = Runtime.getRuntime();
        var availableProcessors = rt.availableProcessors();
        float bytesInMb = 1024 * 1024;
        var totalMemory = (rt.totalMemory()) / bytesInMb;
        var freeMemory = (rt.freeMemory()) / bytesInMb;
        var usedMemory = totalMemory - freeMemory;
        var maxMemory = (rt.maxMemory()) / bytesInMb;

        System.out.printf("""
                Характеристики JVM:
                Доступное число ядер: %s
                Выделенная память (МБ): %.1f
                Свободная память (Мб): %.1f
                Используемая память (Мб): %.1f
                Максимально доступная для выделения память (Мб): %.1f
                """.formatted(availableProcessors, totalMemory, freeMemory, usedMemory, maxMemory));
        
        var systemDisk = System.getProperty("user.home").substring(0, 1);
        var systemVersion = System.getProperty("os.version");
        var javaVersion = System.getProperty("java.version");
        var separator = System.getProperty("file.separator");

        System.out.printf("""
                \nХарактеристики ОС:
                Системный диск: %s
                Версия ОС: %s
                Версия Java: %s
                Символ разделения пути: %s
                """.formatted(systemDisk, systemVersion, javaVersion, separator));

        // 8.ЗАМЕР ВРЕМЕНИ РАБОТЫ КОДА
        System.out.println("\n8.ЗАМЕР ВРЕМЕНИ РАБОТЫ КОДА\n");

        var finishTime = System.nanoTime();
        var endLocalTime = LocalTime.now();
        var timeElapsed = (finishTime - startTime) / 1e9;
        var dtf = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

        System.out.printf("""
                | Старт проверки | %s |
                +----------------+--------------+
                | Финиш проверки | %s |
                +----------------+--------------+
                | Время работы   | %.3f сек    |
                """.formatted(startLocalTime.format(dtf), endLocalTime.format(dtf), timeElapsed));
    }
}