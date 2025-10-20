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
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}