package level2;

import java.util.ArrayList;
import java.util.List;

class ArithmeticCalculator extends Calculator {

    /*사칙연산의 각 기능을 담당하는 클래스들을 저장하는 컬렉션 타입 변수*/
    private final List<Operator> operators;

    /*인스턴스 생성 시 필드(List) 초기화, 현재 가지고 있는 연산 클래스들 List에 추가*/
    public ArithmeticCalculator(){
        operators = new ArrayList<>();
        operators.add(new AddOperator());
        operators.add(new SubtractOperator());
        operators.add(new MultiplyOperator());
        operators.add(new DivideOperator());
        operators.add(new ModOperator());
    }

    public List<Double> get(){
        return results;
    }

    public void set(List<Double> results){
        this.results = results;
    }

    /*사용자가 입력한 연산자(char)에 해당하는 연산 수행 후 반환*/
    /*분모가 0이거나 연산 기호가 잘못된 경우, 의도적으로 예외를 발생시킨 다음 상위 메서드에 전달*/
    public double calculate(double num1, double num2, char operator) {
        double result;
        for(Operator o : operators){                /*List 내 모든 객체 확인*/
            if(o.isAvailable(operator)){            /*해당 객체가 할 수 있는 연산인지 판단*/
                result = o.operate(num1, num2);
                results.add(result);
                return result;
            }
        }
        throw new ArithmeticException("사칙연산 기호가 잘못 입력되었습니다.");  /*가능한 연산이 아닌 경우*/
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
