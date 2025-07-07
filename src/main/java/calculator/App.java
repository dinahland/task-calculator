package calculator;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] result_arr = new int[10]; /*연산 결과 10개를 저장할 수 있는 배열*/
        int count = 0; /*연산 결과를 배열의 빈 곳에 저장하기 위함*/

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

            int result = 0; /*결과 저장*/
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
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("사칙연산 기호가 잘못 입력되었습니다.");
                    error = true;
            }
            if(!error) {
                System.out.println("연산 결과: " + result);
                if(count == result_arr.length){                      /*연산 결과가 10개를 초과하는 경우*/
                    for(int i = 0; i < result_arr.length-1; i++){
                        result_arr[i] = result_arr[i+1];             /*result_arr[0] 삭제, 모든 값 한 칸씩 앞으로 이동*/
                    }
                    count--;                                         /*새로운 결과는 마지막 인덱스에 저장*/
                }
                result_arr[count] = result;
                count++;
            }
            System.out.println("현재 배열: " + Arrays.toString(result_arr));

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
