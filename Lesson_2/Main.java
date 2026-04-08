public class Main {
    public static void main(String[] args) {
        Main caller = new Main();

        System.out.print("\nHЕ BOOLEAN-МЕТОДЫ");
        caller.callNonBooleanMethods();

        System.out.print("\n\nBOOLEAN-МЕТОДЫ");
        caller.callBooleanMethods();
    }

    public void callNonBooleanMethods() {
        NonBooleanMethods nonBooleanObject = new NonBooleanMethods();

        System.out.print(nonBooleanObject.findLongestWord());
        nonBooleanObject.chooseMenuOption();
        System.out.print(nonBooleanObject.calculateAverageMark());
        System.out.print(nonBooleanObject.countUniqueWords());
        System.out.print(nonBooleanObject.printErrorMessage());
        nonBooleanObject.syncCloudData();
        nonBooleanObject.restoreBackup();
        nonBooleanObject.pauseDownload();
        nonBooleanObject.factoryReset();
        nonBooleanObject.writeToFile();
        System.out.print(nonBooleanObject.convertTemperature());
        nonBooleanObject.inputMathExpression();
        System.out.print(nonBooleanObject.chooseWinner());
        System.out.print(nonBooleanObject.findBookByAuthor());
    }

    public void callBooleanMethods() {
        BooleanMethods booleanObject = new BooleanMethods();

        System.out.print(booleanObject.isContinuing());
        System.out.print(booleanObject.hasUniqueDigit());
        System.out.print(booleanObject.isEnterLetter());
        System.out.print(booleanObject.hasEqualDigits());
        System.out.print(booleanObject.hasAttemptsLeft());
        System.out.print(booleanObject.isEmptyString());
        System.out.print(booleanObject.isEvenNumber());
        System.out.print(booleanObject.isValidPath());
        System.out.print(booleanObject.isExistFile());
    }
}