### 단계별로 진화하는 계산기 프로그램

#### App.java
- 사용자로부터 어떤 기능을 수행할지 입력 받아 계산 시작 (사칙연산/원의 넓이)
- 사칙연산의 피연산자를 입력 받을 때, 정수와 실수 모두 가능하게 함
- 사용자로부터 연산 기호 입력 받음
- ArithmeticCalculator 클래스의 calculate() 호출하여 사칙연산 수행
- 가장 먼저 저장된 연산 결과 삭제 여부 선택
- 저장된 연산 결과 조회 가능
- 수를 입력 받아 저장된 연산 결과들 중 입력값보다 큰 수만 조회
- 원의 넓이 선택 시 반지름을 입력 받음
- CircleCalculator 클래스의 calculate() 호출하여 원의 넓이 계산
- 저장된 원의 넓이 조회 가능
- exit 입력 시 프로그램 종료

#### Calculator.java
- 상수 PI와 계산 결과 저장 List, 오류 메시지 저장 List가 선언되어 있는 추상 클래스
- 가장 먼저 저장된 데이터 삭제 기능의 추상 클래스 선언
- 현재 저장되어 있는 데이터 모두 출력 기능의 추상 클래스 선언

#### ArithmeticCalculator.java
- enum 타입으로 연산자 타입 관리 (각 연산자에 맞는 기능과 예외 처리 구현)
- calculate() 연산 수행 후 연산 결과 List에 저장
- 가장 먼저 저장된 연산 결과 제거 메서드 removeResult()
- 저장된 연산 결과 모두 출력 메서드 inquiryResults()
- 기준값보다 큰 값만 필터링해서 출력하는 메서드 printAbove()

#### CircleCalculator.java
- 반지름을 받아서 원의 넓이를 반환하는 메서드 calculateCircleArea()
- 가장 먼저 저장된 원의 넓이 제거 메서드 removeResult()
- 저장된 원의 넓이 모두 출력 메서드 inquiryResults()
