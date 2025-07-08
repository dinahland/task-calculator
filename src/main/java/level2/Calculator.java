package level2;

import java.util.ArrayList;
import java.util.List;

class Calculator {
    /* static: 클래스 단위로 존재하며 모든 인스턴스가 공유
       final: 한 번 초기화되면 변경 불가능
       PI는 모든 인스턴스가 고정된 값을 사용하고 변경될 수 없으므로 static final (상수)로 선언함 */
    public static final double PI = 3.141592;

    private List<Integer> result_arr;   /*연산 결과 저장*/
    private List<Double> circleArea;    /*원의 넓이 결과 저장*/

    /*생성 시 필드가 초기화되도록 생성자 구현*/
    public Calculator(){
        result_arr = new ArrayList<>();
        circleArea = new ArrayList<>();
    }

    public List<Integer> getResult_arr(){
        return result_arr;
    }

    public void setResult_arr(List<Integer> result_arr){
        this.result_arr = result_arr;
    }

    public List<Double> getCircleArea() {
        return circleArea;
    }

    public void setCircleArea(List<Double> circleArea) {
        this.circleArea = circleArea;
    }

    /*정수 2개와 연산 기호를 매개변수로 받아 연산한 다음 결과 값 반환*/
    /*분모가 0인 경우, 연산 기호가 잘못된 경우는 의도적으로 예외를 발생시킨 다음 throws*/
    public int calculate(int num1, int num2, char operator) throws Exception {
        int result;
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

    /*가장 먼저 저장된 데이터 삭제*/
    public void removeResult(){
        result_arr.remove(0);
    }

    /*현재 저장되어 있는 연산 결과 모두 출력*/
    public void inquiryResults(){
        System.out.println(result_arr);
    }

    /*반지름을 매개변수로 받아 원의 넓이를 반환하는 메서드*/
    public double calculateCircleArea(double radius){
        double area = radius * radius * PI;
        circleArea.add(area);
        return area;
    }

    /*현재 저장되어 있는 원의 넓이 모두 출력*/
    public void inquiryCircleAreas(){
        System.out.println(circleArea);
    }


}
