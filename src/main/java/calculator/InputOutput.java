package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputOutput {
    public String inputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return readLine();
    }

    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}