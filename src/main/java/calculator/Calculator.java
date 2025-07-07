package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    /*연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성*/
    private List<Integer> result_arr = new ArrayList<>();

    /*정수 2개와 연산 기호를 매개변수로 받아 연산한 다음 결과 값 반환*/
    /*분모가 0인 경우, 연산 기호가 잘못된 경우는 의도적으로 예외를 발생시킨 다음 throws*/
    public int calculate(int num1, int num2, char operator) throws Exception {
        int result = 0;
        switch (operator){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if(num2 == 0){
                    throw new Exception("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                } else{
                    result = num1 / num2;
                }
                break;
            default:
                throw new Exception("사칙연산 기호가 잘못 입력되었습니다.");
        }
        result_arr.add(result);
        return result;
    }
}
