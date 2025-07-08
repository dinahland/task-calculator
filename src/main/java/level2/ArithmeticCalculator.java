package level2;

import java.util.List;

class ArithmeticCalculator extends Calculator {

    public List<Double> get(){
        return results;
    }

    public void set(List<Double> results){
        this.results = results;
    }

    /*정수 2개와 연산 기호를 매개변수로 받아 연산한 다음 결과 값 반환*/
    /*분모가 0인 경우, 연산 기호가 잘못된 경우는 의도적으로 예외를 발생시킨 다음 throws*/
    public double calculate(double num1, double num2, char operator) throws Exception {
        double result;
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
        results.add(result);
        return result;
    }

    /*가장 먼저 저장된 연산 결과 삭제*/
    public void removeResult(){
        results.remove(0);
    }

    /*현재 저장되어 있는 연산 결과 모두 출력*/
    public void inquiryResults(){
        System.out.println(results);
    }
}
