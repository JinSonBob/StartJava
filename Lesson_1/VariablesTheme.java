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

        var penPrice = 105.5f;
        var bookPrice = 235.23f;
        var discoint = 0.11f;

        var totalSum = penPrice + bookPrice;
        var discountSum = totalSum * discoint;
        var totalCost = totalSum - discountSum;

        System.out.println("Стоимость товаров без скидки = " + totalSum);
        System.out.println("Сумма скидки = " + discountSum);
        System.out.println("Стоимость товаров со скидкой = " + totalCost);

        // Второй способ с BigDecimal
        System.out.println("\nВторой способ с BigDecimal");

        var penPriceBd = new BigDecimal("105.5");
        var bookPriceBd = new BigDecimal("235.23");
        var discointBd = new BigDecimal("0.11");

        var totalSumBd = penPriceBd.add(bookPriceBd).setScale(2, RoundingMode.HALF_UP);
        var discountSumBd = totalSumBd.multiply(discointBd).setScale(2, RoundingMode.HALF_UP);
        var totalCostBd = totalSumBd.subtract(discountSumBd).setScale(2, RoundingMode.HALF_UP);

        System.out.println("Стоимость товаров без скидки = " + totalSumBd);
        System.out.println("Сумма скидки = " + discountSumBd);
        System.out.println("Стоимость товаров со скидкой = " + totalCostBd);

        // 3.ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ
        System.out.println("\n3.ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ");

        var firstNum = 2;
        var secondNum = 5;
        var tmp = 0;

        // Метод: третья переменная
        System.out.println("\nМетод: третья переменная");
        System.out.println("Исходные: First num = " + firstNum + ", Second num = " + secondNum);

        tmp = firstNum;
        firstNum = secondNum;
        secondNum = tmp;

        System.out.println("Результат: First num = " + firstNum + ", Second num = " + secondNum);

        // Метод: Арифметические операции
        System.out.println("\nМетод: Арифметические операции");
        System.out.println("Исходные: First num = " + firstNum + ", Second num = " + secondNum);

        firstNum += secondNum;
        secondNum = firstNum - secondNum;
        firstNum -= secondNum;

        System.out.println("Результат: First num = " + firstNum + ", Second num = " + secondNum);
        
        // Метод: побитовой операции ^
        System.out.println("\nМетод: побитовой операции ^");
        System.out.println("Исходные: First num = " + firstNum + ", Second num = " + secondNum);

        firstNum ^= secondNum;
        secondNum ^= firstNum;
        firstNum ^= secondNum;

        System.out.println("Результат: First num = " + firstNum + ", Second num = " + secondNum);

        // 4.ДЕКОДИРОВАНИЕ СООБЩЕНИЯ
        System.out.println("\n4.ДЕКОДИРОВАНИЕ СООБЩЕНИЯ\n");

        var code1 = 1055;
        var code2 = 1088;
        var code3 = 1080;
        var code4 = 1074;
        var code5 = 1077;
        var code6 = 1090;

        System.out.printf("%8d%8d%8d%8d%8d%8d\n", code1, code2, code3, code4, code5, code6);

        var char1 = (char) code1;
        var char2 = (char) code2;
        var char3 = (char) code3;
        var char4 = (char) code4;
        var char5 = (char) code5;
        var char6 = (char) code6;

        System.out.printf("%8c%8c%8c%8c%8c%8c", char1, char2, char3, char4, char5, char6);

        // 5.АНАЛИЗ КОДА ТОВАРА
        System.out.println("\n\n5.АНАЛИЗ КОДА ТОВАРА\n");

        var productCode = 842;

        var productCategory = productCode / 100;
        var productSubcategory = productCode / 10 % 10;
        var packageType = productCode % 10;

        var controlSum = productCategory + productSubcategory + packageType;
        var validationCode = productCategory * productSubcategory * packageType;

        System.out.println("""
                Код товара: %d
                  категория товара - %s
                  подкатегория - %s
                  тип упаковки - %s
                Контрольная сумма = %d
                Проверочный код = %d
                """.formatted(productCode, productCategory, productSubcategory, 
                              packageType, controlSum, validationCode));

        // 6.ТЕСТИРОВАНИЕ ДАТЧИКОВ ПЕРЕД ЗАПУСКОМ РАКЕТЫ
        System.out.println("6.ТЕСТИРОВАНИЕ ДАТЧИКОВ ПЕРЕД ЗАПУСКОМ РАКЕТЫ\n");
        
        var temperature = Byte.MAX_VALUE;
        var pressure = Short.MAX_VALUE;
        var statusCode = Character.MAX_VALUE;
        var traveledDistance = Integer.MAX_VALUE;
        var timeSinceStart = Long.MAX_VALUE;

        System.out.printf("""
                [Температура], °C:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(temperature, (temperature += 1), (temperature -= 1)));

        System.out.printf("""
                [Давление], Па:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(pressure, (pressure += 1), (pressure -= 1)));

        System.out.printf("""
                [Код состояния системы]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted((int) statusCode, (int) (statusCode += 1), (int) (statusCode -= 1)));

        System.out.printf("""
                [Пройденное расстояние], м:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(traveledDistance, (traveledDistance += 1), (traveledDistance -= 1)));

        System.out.printf("""
                [Время с момента старта], с:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(timeSinceStart, (timeSinceStart += 1), (timeSinceStart -= 1)));

        // 7.ВЫВОД ПАРАМЕТРОВ JVM И ОС
        System.out.println("\n7.ВЫВОД ПАРАМЕТРОВ JVM И ОС\n");
        
        var runtimeObject = Runtime.getRuntime();
        var availableProcessors = runtimeObject.availableProcessors();
        var totalMemory = (runtimeObject.totalMemory()) / 1024 / 1024f;
        var freeMemory = (runtimeObject.freeMemory()) / 1024 / 1024f;
        var usedMemory = (totalMemory - freeMemory) / 1024 / 1024f;
        var maxMemory = (runtimeObject.maxMemory()) / 1024 / 1024f;

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

        var finishTime = System.nanoTime();
        var endLocalTime = LocalTime.now();
        var timeElapsed = (finishTime - startTime) / 1000000000f;
        var dtf = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

        System.out.println("\n8.ЗАМЕР ВРЕМЕНИ РАБОТЫ КОДА\n");

        System.out.printf("""
                | Старт проверки | %s |
                +----------------+--------------+
                | Финиш проверки | %s |
                +----------------+--------------+
                | Время работы   | %.3f сек    |
                """.formatted(startLocalTime.format(dtf), endLocalTime.format(dtf), timeElapsed));
    }
}