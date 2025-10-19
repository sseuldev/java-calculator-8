# java-calculator-precourse

## ✔️ 문자열 입출력

1. 사용자에게 보여줄 입력 문구를 출력한다.
2. 문자열을 입력받는다.
3. 계산된 값을 출력 형식에 맞게 출력한다.

## ✔️ 계산기 기능

1. 구분자를 기준으로 숫자를 분리한다.
    1. 쉼표(,)나 콜론(:) (기본 구분자) 을 기준으로 분리한다.
    2. 문자열 앞 부분의 `//` 와 `\n` 사이에 위치하는 문자로 커스텀 구분자를 지정하여 이를 기준으로 분리한다.


2. 분리된 문자를 바탕으로 입력값을 검증하고 예외를 처리한다.
    1. 분리된 문자에 숫자가 아닌 문자가 있는 경우 (단, 빈 문자열은 0으로 처리 가능)
    2. 분리된 문자에 음수가 포함된 경우
    3. 커스텀 구분자가 문자가 아닌 숫자인 경우
    4. 커스텀 구분자 세팅 시 구분자가 두 개 이상인 경우
    5. 커스텀 구분자 세팅 시 구분자가 빈 문자인 경우
    6. 커스텀 구분자를 기본 구분자 중 하나로 설정하는 경우


3. 분리된 숫자의 합을 구한다.

<br />

## 📑 메서드 설계
## 1. Domain (Model)
### Separator
> 구분자 기준 문자열에서 문자 분리

- public 메서드
  - `Separator(input : String)`
  - `splitBySeparator(input : String)` : `String[]`


- 구분자 기준으로 문자 분리
   - 기본 구분자 기준으로 문자 분리
   - 커스텀 구분자 기준으로 문자 분리
   - 이때, 커스텀 구분자 지정해도 기본 구분자 등장 시 이 또한 문자 분리 가능


- 예외 처리 - '구분자 관련 에러'는 해당 클래스가 전담
  - Case 1 : 커스텀 구분자 세팅 시 구분자가 한 개의 문자가 아닌 경우
  - Case 2 : 커스텀 구분자가 문자가 아닌 숫자인 경우
  - Case 3 : 커스텀 구분자를 기본 구분자 중 하나로 설정하는 경우

### Operands
> Operand 리스트를 담당하는 일급 컬렉션

- public 메서드
  - `Operands(splitInput : String[])`

### Operand
> Operand 숫자 처리

- public 메서드
   - `Operand(element : String)`


- 구분자를 제외한 문자를 숫자로 추출하기


- 예외처리 - '숫자 관련 에러'는 해당 클래스가 전담
  - Case 1 : 분리된 문자에 숫자가 아닌 문자가 있는 경우
  - Case 2 : 분리된 문자에 음수가 포함된 경우

### Calculator
> 숫자 합 계산 처리

- public 메서드
   - `calculate(input : String)` : `int`


- Operand로부터 가져온 숫자를 바탕으로 총합 계산하기

## 2. View
### Input
> 문자열 입력 담당

- public 메서드
   - `readInput()` : `String`

### Output
> 결과 출력 담당

- public 메서드
   - `showOutput(output : int)`


## 3. Controller
### CalculatorController
- public 메서드
   - `CalculatorController(input : Input, output : Output, calculator : Calculator)`
   - `run()`


- 입력 → 계산 → 출력 흐름 제어

## 4. Application
- model과 view를 생성하고 controller에 주입

<br />

## ⛳️ 1주차 목표

- MVC 패턴을 활용한 **객체지향** 코드 설계 공부
- **유지보수**가 뛰어난 코드 설계
- **캡슐화** 신경쓰기 : public, private 접근지정자
- **SRP(단일 책임 원칙)** & **DIP(의존성 주입 원칙)** 생각하면서 코드 짜기
- 의미있는 **테스트 코드** 설계하기
