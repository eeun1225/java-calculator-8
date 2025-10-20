package calculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NumberValidatorTest {
    private final NumberValidator validator = new NumberValidator();

    @Test
    void 숫자_문자열_변환() {
        int[] result = validator.parseToNumbers(new String[]{"1", "2", "3"});
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void 공백이_포함된_숫자_변환() {
        int[] result = validator.parseToNumbers(new String[]{" 1 ", "2", " 3"});
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void 숫자가_아닌_값_입력시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.parseToNumbers(new String[]{"1", "abc", "3"});
        });
    }

    @Test
    void 빈_문자열_변환시_0반환() {
        int[] result = validator.parseToNumbers(new String[]{"1", "", "2"});
        assertArrayEquals(new int[]{1, 0, 2}, result);
    }

    @Test
    void 공백만_있는_문자열_변환시_0반환() {
        int[] result = validator.parseToNumbers(new String[]{"1", "   ", "2"});
        assertArrayEquals(new int[]{1, 0, 2}, result);
    }

    @Test
    void 모두_빈_문자열인_경우() {
        int[] result = validator.parseToNumbers(new String[]{"", "", ""});
        assertArrayEquals(new int[]{0, 0, 0}, result);
    }

    @Test
    void 음수_입력시_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.parseToNumbers(new String[]{"1", "-1", "3"});
        });
    }
}
