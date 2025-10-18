package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.view.Input;
import calculator.view.Output;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        Calculator calculator = new Calculator();
        CalculatorController calculatorController = new CalculatorController(input, output, calculator);
        calculatorController.run();
    }
}
