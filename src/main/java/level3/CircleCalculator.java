package level3;

import java.util.List;

class CircleCalculator extends Calculator {

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
    void removeResult() {
        if(!results.isEmpty()){
            results.remove(0);
        }
    }

    /*현재 저장되어 있는 원의 넓이 모두 출력*/
    public void inquiryResults(){
        System.out.println(results);
    }

}
