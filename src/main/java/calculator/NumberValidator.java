package calculator;

public class NumberValidator {
    public int[] parseToNumbers(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = parseToNumber(values[i]);
        }
        return numbers;
    }

    private int parseToNumber(String value) {
        if (value.trim().isEmpty()) {
            return 0;
        }

        try {
            int number = Integer.parseInt(value.trim());
            validatePositive(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }
}