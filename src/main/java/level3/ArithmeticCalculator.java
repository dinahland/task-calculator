package level3;
import java.util.List;

enum OperatorType{
    ADD('+'){
        public double operate(double num1, double num2){
            return num1 + num2;
        }
    },
    SUBTRACK('-'){
        public double operate(double num1, double num2){
            return num1 - num2;
        }
    },
    MULTIPLY('*'){
        public double operate(double num1, double num2){
            return num1 * num2;
        }
    },
    DIVIDE('/'){
        public double operate(double num1, double num2){
            if(num2 == 0){
                throw new ArithmeticException("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
            } else{
                return num1 / num2;
            }
        }
    },
    MOD('%'){
        public double operate(double num1, double num2){
            if(num2 == 0){
                throw new ArithmeticException("나머지 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
            } else{
                return num1 % num2;
            }
        }
    };

    private final char symbol;        /*연산 기호 저장 필드*/

    OperatorType(char symbol){  /*생성자*/
        this.symbol = symbol;
    }

    /*현재 객체가 가진 symbol과 입력 받은 연산 기호가 같은지 판단*/
    public boolean isAvailable(char symbol){
        return symbol == this.symbol;
    }

    /*enum 클래스에서 공통으로 사용할 메서드는 추상 메서드로 정의 필요*/
    public abstract double operate(double num1, double num2);
}

class ArithmeticCalculator extends Calculator {      /*제네릭 클래스로 변경*/

    /*사칙연산의 각 기능을 담당하는 enum 타입들을 저장하는 List*/
    private final List<OperatorType> operators;

    /*인스턴스 생성 시 필드(List) 초기화, enum 클래스가 가지고 있는 모든 상수 값을 List에 저장*/
    public ArithmeticCalculator(){
        this.operators = List.of(OperatorType.values());
    }

    public List<Number> get(){
        return results;
    }

    public void set(List<Number> results){
        this.results = results;
    }

    /*사용자가 입력한 연산자(char)에 해당하는 연산 수행 후 반환*/
    /*분모가 0이거나 연산 기호가 잘못된 경우, 의도적으로 예외를 발생시킨 다음 상위 메서드에 전달*/
    public double calculate(Number num1, Number num2, char operator) {
        /*T 타입으로 저장된 숫자를 double 형태로 저장*/
        double n1 = num1.doubleValue();
        double n2 = num2.doubleValue();
        double result;
        for(OperatorType o : operators){                /*List 내 모든 객체 확인*/
            if(o.isAvailable(operator)){            /*해당 객체가 할 수 있는 연산인지 판단*/
                result = o.operate(n1, n2);
                results.add(result);
                return result;
            }
        }
        throw new ArithmeticException("사칙연산 기호가 잘못 입력되었습니다.");  /*가능한 연산이 아닌 경우*/
    }

    /*가장 먼저 저장된 연산 결과 삭제*/
    public void removeResult(){
        if(!results.isEmpty()){
            results.remove(0);
        }
    }

    /*현재 저장되어 있는 연산 결과 모두 출력*/
    public void inquiryResults(){
        System.out.println(results);
    }
}
