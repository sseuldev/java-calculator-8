package calculator.domain;

public class Calculator {

    public int calculate(String input) {
        Separator separator = new Separator(input);
        String[] splitInput = separator.splitBySeparator(input);
        Operands operands = new Operands(splitInput);
        return sum(operands);
    }

    private int sum(Operands operands) {
        return operands.getOperands()
                .stream()
                .mapToInt(Operand::getOperand)
                .sum();
    }
}
