package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.Input;
import calculator.view.Output;

public class CalculatorController {
    private final Input input;
    private final Output output;
    private final Calculator calculator;

    public CalculatorController(Input input, Output output, Calculator calculator) {
        this.input = input;
        this.output = output;
        this.calculator = calculator;
    }

    public void run() {
        String userInput = input.readInput();
        int sum = calculator.calculate(userInput);
        output.showOutput(sum);
    }
}
