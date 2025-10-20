package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    private final InputParser parser = new InputParser();
    private final NumberValidator validator = new NumberValidator();
    private final StringCalculator calculator = new StringCalculator(parser, validator);

    @Test
    void null_입력시_0_반환() {
        int result = calculator.calculate(null);
        assertEquals(0, result);
    }

    @Test
    void 빈_문자열_입력시_0_반환() {
        int result = calculator.calculate("");
        assertEquals(0, result);
    }

    @Test
    void 숫자_하나_입력시_해당_숫자_반환() {
        int result = calculator.calculate("5");
        assertEquals(5, result);
    }

    @Test
    void 쉼표_구분자로_구분된_숫자들_합계_계산() {
        int result = calculator.calculate("1,2,3");
        assertEquals(6, result);
    }

    @Test
    void 콜론_구분자로_구분된_숫자들_합계_계산() {
        int result = calculator.calculate("1:2:3");
        assertEquals(6, result);
    }

    @Test
    void 쉼표와_콜론_혼합_구분자_합계_계산() {
        int result = calculator.calculate("1,2:3");
        assertEquals(6, result);
    }

    @Test
    void 연속된_구분자로_인한_빈_문자열_처리() {
        int result = calculator.calculate("1,,2");
        assertEquals(3, result);
    }

    @Test
    void 커스텀_구분자로_구분된_숫자들_합계_계산() {
        int result = calculator.calculate("//;\\n1;2;3");
        assertEquals(6, result);
    }

    @Test
    void 여러_문자_커스텀_구분자_합계_계산() {
        int result = calculator.calculate("//:::\\n1:::2:::3");
        assertEquals(6, result);
    }

    @Test
    void 커스텀_구분자_파이프_합계_계산() {
        int result = calculator.calculate("//|\\n1|2|3");
        assertEquals(6, result);
    }

    @Test
    void 큰_숫자들의_합계_계산() {
        int result = calculator.calculate("100,200,300");
        assertEquals(600, result);
    }

    @Test
    void 숫자가_아닌_값_입력시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("1,abc,3");
        });
    }

    @Test
    void 커스텀_구분자와_잘못된_값_입력시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("//;\\n1;abc;3");
        });
    }
}
