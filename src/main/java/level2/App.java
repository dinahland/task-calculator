package level2;

import level2.calculator.ArithmeticCalculator;
import level2.calculator.CircleCalculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArithmeticCalculator arithmetic = new ArithmeticCalculator();
        CircleCalculator circle = new CircleCalculator();

        //exit 입력 전까지 반복
        while(true){
            //사칙연산을 진행할지 원의 넓이를 구할지 선택
            System.out.println("1. 사칙연산\n2. 원의 넓이");
            System.out.print("어떤 기능을 사용하시겠습니까? (숫자 입력): ");
            int command = sc.nextInt();
            switch (command){
                case 1:
                    System.out.println("사칙연산을 진행합니다.");

                    //정수 2개 입력 받음
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    double num1 = sc.nextInt();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    double num2 = sc.nextInt();

                    //사칙연산 기호 입력 받아 char 형태로 저장
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    String symbol = sc.next();
                    char operator = symbol.charAt(0);

                    /*예외 처리: Calculator 클래스의 메서드를 호출하여 사칙연산 수행*/
                    try {
                        double result = arithmetic.calculate(num1, num2, operator);
                        System.out.println("연산 결과: " + result);
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }

                    arithmetic.removeResult(sc);      /*가장 먼저 저장된 연산결과 삭제 여부를 사용자에게 입력 받고 처리함*/
                    arithmetic.inquiryResults(sc);    /*연산결과 리스트 조회 여부를 사용자에게 입력 받고 처리함*/
                    break;
                case 2:
                    System.out.println("원의 넓이를 계산합니다. ");
                    System.out.print("반지름을 입력하세요: ");
                    double radius = sc.nextDouble();
                    double area = circle.calculateCircleArea(radius);
                    System.out.println("반지름이 " + radius + "인 원의 넓이: " + area);

                    circle.removeResult(sc);      /*가장 먼저 저장된 원의 넓이 삭제 여부를 사용자에게 입력 받고 처리함*/
                    circle.inquiryResults(sc);    /*원의 넓이 리스트 조회 여부를 사용자에게 입력 받고 처리함*/
                    break;
                default:
                    System.out.println("1 또는 2를 입력해주세요.");
            }

            //사용자가 exit 입력 시 반복 종료
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if(sc.next().equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }



    }
}
