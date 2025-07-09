package level3;

import java.util.ArrayList;
import java.util.List;

abstract class Calculator {
    /* static: 클래스 단위로 존재하며 모든 인스턴스가 공유
       final: 한 번 초기화되면 변경 불가능
       PI는 모든 인스턴스가 고정된 값을 사용하고 변경될 수 없으므로 static final (상수)로 선언함 */
    public static final double PI = 3.141592;

    public List<Number> results;
    public List<String> errorMessages;  /*오류 메시지 저장용 리스트*/

    /*생성 시 필드가 초기화되도록 생성자 구현*/
    public Calculator(){
        results = new ArrayList<>();
        errorMessages = new ArrayList<>();
    }

    /*가장 먼저 저장된 데이터 삭제*/
    abstract void removeResult();

    /*현재 저장되어 있는 데이터 모두 출력*/
    abstract void inquiryResults();


}
