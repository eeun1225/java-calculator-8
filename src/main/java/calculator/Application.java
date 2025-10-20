package calculator;

public class Application {
    public static void main(String[] args) {
        InputOutput io = new InputOutput();
        InputParser parser = new InputParser();
        NumberValidator validator = new NumberValidator();
        StringCalculator calculator = new StringCalculator(parser, validator);

        String input = io.inputString();
        int result = calculator.calculate(input);
        io.printResult(result);
    }
}
