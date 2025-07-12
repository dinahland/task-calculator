package level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Double> result_arr = new ArrayList<>();   /*Collection 리스트 선언*/

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

            double result = 0; /*결과 저장*/
            boolean error = false; /*부적절한 입력 확인*/
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
                        System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다. ");
                        error = true;
                    } else{
                        result = (double) num1 / num2;
                    }
                    break;
                default:
                    System.out.println("사칙연산 기호가 잘못 입력되었습니다.");
                    error = true;
            }
            if(!error) {
                System.out.println("연산 결과: " + result);
                result_arr.add(result);
            }

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            if(sc.next().equals("remove")){
                if(!result_arr.isEmpty()){
                    result_arr.remove(0);
                } else{
                    System.out.println("삭제할 연산 결과가 없습니다.");
                }
            }

            System.out.println("저장된 연산 결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            if(sc.next().equals("inquiry")){
                System.out.println(result_arr);
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
