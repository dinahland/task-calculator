package calculator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calculator cal = new Calculator();  /* Calculator 인스턴스 생성*/

        //exit 입력 전까지 반복
        while(true){
            //정수 2개 입력 받음
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            //사칙연산 기호 입력 받아 char 형태로 저장
            System.out.print("사칙연산 기호를 입력하세요: ");
            String symbol = sc.next();
            char operator = symbol.charAt(0);

            /*예외 처리: Calculator 클래스의 메서드를 호출하여 사칙연산 수행*/
            try {
                int result = cal.calculate(num1, num2, operator);
                System.out.println("연산 결과: " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            if(sc.next().equals("remove")){
                cal.removeResult();
            }

            System.out.println("저장된 연산 결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            if(sc.next().equals("inquiry")){
                System.out.print("[ ");
                for(Integer n: cal.get()){         /*for each 활용*/
                    System.out.print(n + " ");      /*현재 저장된 연산 결과 모두 출력*/
                }
                System.out.println("]");
            }

            //사용자가 exit 입력 시 반복 종료
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String isExit = sc.next();
            if(isExit.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }



    }
}
