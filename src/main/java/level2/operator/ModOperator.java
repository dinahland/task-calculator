package level2.operator;

public class ModOperator implements Operator{

    public boolean isAvailable(char operator) {
        return operator == '%';
    }

    public double operate(double num1, double num2){
        if(num2 == 0){
            throw new ArithmeticException("나머지 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
        } else{
            return num1 % num2;
        }
    }
}
