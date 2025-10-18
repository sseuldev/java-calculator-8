package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Operands {

    private final List<Operand> operands = new ArrayList<>();

    public Operands(String[] splitInput) {
        for (String element : splitInput) {
            Operand operand = new Operand(element);
            operands.add(operand);
        }
    }

    public List<Operand> getOperands() {
        return operands;
    }
}
