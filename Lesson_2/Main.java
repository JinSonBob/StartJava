public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        System.out.println("HЕ BOOLEAN-МЕТОДЫ\n");
        main.callNonBooleanMethods();

        System.out.println("\nBOOLEAN-МЕТОДЫ");
        main.callBooleanMethods();
    }

    private void callNonBooleanMethods() {
        NonBooleanMethods nonBooleanObject = new NonBooleanMethods();

        nonBooleanObject.findLongestWord();
        nonBooleanObject.chooseMenuOption();
        nonBooleanObject.calculateAverageMark();
        nonBooleanObject.countUniqueWords();
        nonBooleanObject.printErrorMessage();
        nonBooleanObject.syncCloudData();
        nonBooleanObject.restoreBackup();
        nonBooleanObject.pauseDownload();
        nonBooleanObject.resetSettings();
        nonBooleanObject.writeToFile();
        nonBooleanObject.convertTemperature();
        nonBooleanObject.inputMathExpression();
        nonBooleanObject.chooseWinner();
        nonBooleanObject.findBookByAuthor();
    }

    private void callBooleanMethods() {
        BooleanMethods booleanObject = new BooleanMethods();

        System.out.print(booleanObject.isContinuing());
        System.out.print(booleanObject.hasUniqueDigit());
        System.out.print(booleanObject.isEnteredLetter());
        System.out.print(booleanObject.hasEqualDigits());
        System.out.print(booleanObject.hasAttemptsLeft());
        System.out.print(booleanObject.isEmptyString());
        System.out.print(booleanObject.isEvenNumber());
        System.out.print(booleanObject.isValidPath());
        System.out.print(booleanObject.isExistFile());
    }
}