package level2.operator;

public interface Operator {
    /*연산자(char)를 매개변수로 받아서 사용 가능한 연산인지 boolean 반환*/
    boolean isAvailable(char operator);

    double operate(double num1, double num2);
}
