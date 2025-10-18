package calculator.domain;

public class Operand {

    private static final String INVALID_OPERAND_TYPE = "피연산자는 숫자여야 합니다.";
    private static final String INVALID_RANGE_OF_NUMBERS = "피연산자는 양수여야 합니다.";

    private final int operand;

    public Operand(String element) {
        this.operand = changeToInt(element);
    }

    public int getOperand() {
        return operand;
    }

    private int changeToInt(String element) {
        try {
            if (element.isEmpty()) {
                return 0;
            }
            int num = Integer.parseInt(element);
            validatePositiveInt(num);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_OPERAND_TYPE);
        }
    }

    private void validatePositiveInt(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException(INVALID_RANGE_OF_NUMBERS);
        }
    }
}
