package calculator;

public class InputParser {
    private static final String DEFAULT_DELIMITER = "[,:]";

    public String[] parse(String input) {
        return splitByDelimiter(input);
    }

    private String[] splitByDelimiter(String input) {
        return input.split(InputParser.DEFAULT_DELIMITER);
    }
}
