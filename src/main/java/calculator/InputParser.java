package calculator;

public class InputParser {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SEPARATOR = "\\n";

    public String[] parse(String input) {
        if (hasCustomDelimiter(input)) {
            String customDelimiter = extractCustomDelimiter(input);
            String content = removeDelimiterPrefix(input);
            return splitByDelimiter(content, customDelimiter);
        }

        return splitByDelimiter(input, DEFAULT_DELIMITER);
    }

    private String[] splitByDelimiter(String input, String delimiter) {
        return input.split(delimiter);
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    public String extractCustomDelimiter(String input) {
        int startIndex = CUSTOM_DELIMITER_PREFIX.length();
        int endIndex = input.indexOf(CUSTOM_DELIMITER_SEPARATOR);
        return input.substring(startIndex, endIndex);
    }

    public String removeDelimiterPrefix(String input) {
        int newlineIndex = input.indexOf(CUSTOM_DELIMITER_SEPARATOR);
        return input.substring(newlineIndex + 1);
    }
}
