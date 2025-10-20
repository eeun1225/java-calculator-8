package calculator;

import java.util.Arrays;

public class StringCalculator {
    private final InputParser inputParser;
    private final NumberValidator numberValidator;

    public StringCalculator(InputParser inputParser, NumberValidator numberValidator) {
        this.inputParser = inputParser;
        this.numberValidator = numberValidator;
    }

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] tokens = inputParser.parse(input);
        int[] numbers = numberValidator.parseToNumbers(tokens);
        return sum(numbers);
    }

    private int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
