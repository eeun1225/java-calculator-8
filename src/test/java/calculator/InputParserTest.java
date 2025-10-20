package calculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InputParserTest {
    private final InputParser parser = new InputParser();

    @Test
    void 쉼표_구분자로_분리() {
        String[] result = parser.parse("1,2,3");
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    void 콜론_구분자로_분리() {
        String[] result = parser.parse("1:2:3");
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    void 쉼표와_콜론_혼합_구분자로_분리() {
        String[] result = parser.parse("1,2:3");
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    void 연속된_구분자로_빈_문자열_생성() {
        String[] result = parser.parse("1,,2");
        assertArrayEquals(new String[]{"1", "", "2"}, result);
    }

    @Test
    void 숫자_하나만_입력() {
        String[] result = parser.parse("5");
        assertArrayEquals(new String[]{"5"}, result);
    }

    // 커스텀 구분자 테스트
    @Test
    void 커스텀_구분자_추출() {
        String result = parser.extractCustomDelimiter("//;\\n1;2;3");
        assertEquals(";", result);
    }

    @Test
    void 여러_문자_커스텀_구분자_추출() {
        String result = parser.extractCustomDelimiter("//:::\\n1:::2");
        assertEquals(":::", result);
    }

    @Test
    void 커스텀_구분자_선언부_제거() {
        String result = parser.removeDelimiterPrefix("//;\\n1;2;3");
        assertEquals("1;2;3", result);
    }

    @Test
    void 커스텀_구분자로_문자열_분리() {
        String[] result = parser.parse("//;\\n1;2;3");
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    void 여러_문자_커스텀_구분자로_분리() {
        String[] result = parser.parse("//:::\\n1:::2:::3");
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    void 커스텀_구분자_파이프() {
        String[] result = parser.parse("//|\\n1|2|3");
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }
}
