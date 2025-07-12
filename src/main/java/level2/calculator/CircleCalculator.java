package level2.calculator;

import java.util.List;
import java.util.Scanner;

public class CircleCalculator extends Calculator {

    public List<Double> get() {
        return results;
    }

    public void set(List<Double> results) {
        this.results = results;
    }

    /*반지름을 매개변수로 받아 원의 넓이를 반환하는 메서드*/
    public double calculateCircleArea(double radius){
        double area = radius * radius * PI;
        results.add(area);
        return area;
    }

    /*가장 먼저 저장된 원의 넓이 삭제*/
    public void removeResult(Scanner sc) {
        System.out.println("가장 먼저 저장된 원의 넓이를 삭제하시겠습니까? (remove 입력 시 삭제)");
        if(sc.next().equals("remove")){
            results.remove(0);
        }
    }

    /*현재 저장되어 있는 원의 넓이 모두 출력*/
    public void inquiryResults(Scanner sc){
        System.out.println("저장된 원의 넓이들을 조회하시겠습니까? (inquiry 입력 시 조회)");
        if(sc.next().equals("inquiry")) {
            System.out.println(results);
        }
    }

}
