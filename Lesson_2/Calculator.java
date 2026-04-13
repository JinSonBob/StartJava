public class Calculator {
    private long firstNum;
    private long secondNum;
    private char operator;
    private double result;

    public void setFirstNum(long firstNum) {
        this.firstNum = firstNum;
    }

    public void setSecondNum(long secondNum) {
        this.secondNum = secondNum;
    }

    public void setOperator(char operator) {
        switch (operator) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '%':
                this.operator = operator;
                break;
            default:
                System.out.printf("Ошибка: операция '%c' не поддерживается%n", operator);
                break;
        }
    }

    public double calculate() {
        switch (operator) {
            case '+':
                result = firstNum + secondNum;
                break;
            case '-':
                result = firstNum - secondNum;
                break;
            case '*':
                result = firstNum * secondNum;
                break;
            case '/':
                if (secondNum != 0) {
                    result = (double) firstNum / secondNum;
                } else {
                    result = 0;
                    System.out.println("Ошибка: деление на ноль запрещено");
                }
                break;
            case '^':
                result = Math.pow(firstNum, secondNum);
                break;
            case '%':
                if (secondNum != 0) {
                    result = firstNum % secondNum;
                } else {
                    result = 0;
                    System.out.println("Ошибка: деление по модулю на ноль");
                }
                break;
            default:
                result = 0;
        }
        return result;
    }
}