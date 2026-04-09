public class Calculator {
    private float firstNum;
    private float secondNum;
    private char operator;
    private float result;

    public void setFirstNum(float firstNum) {
        this.firstNum = (float) firstNum;
    }

    public void setSecondNum(float secondNum) {
        this.secondNum = (float) secondNum;
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

    public float calculate() {
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
                    result = firstNum / secondNum;
                } else {
                    result = 0f;
                    System.out.println("Ошибка: деление на ноль запрещено");
                }
                break;
            case '^':
                result = (float) Math.pow(firstNum, secondNum);
                break;
            case '%':
                if (secondNum != 0) {
                    result = firstNum % secondNum;
                } else {
                    result = 0f;
                    System.out.println("Ошибка: деление по модулю на ноль");
                }
                break;
            default:
                result = 0f;
        }
        return result;
    }
}