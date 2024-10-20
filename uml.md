# UML 관계 표현

<img src="https://github.com/silverpoodle/typora-images/blob/main/uml.png?raw=true" alt="image" style="zoom:40%;" />


### 1. 연관 (Association): 실선 화살표
- 의미: 두 클래스 간의 일반적인 관계
- 방향: A → B는 A가 B를 참조하거나 사용함을 의미
- 설계 패턴 예시:
    - Observer 패턴에서 Subject와 Observer 간의 관계
    - Strategy 패턴에서 Context와 Strategy 간의 관계

### 2. 일반화 (Generalization): 빈 삼각형 화살표
- 의미: 상속 관계
- 방향: 자식 클래스 → 부모 클래스
- 설계 패턴 예시:
    - Template Method 패턴에서 구체 클래스와 추상 클래스 간의 관계
    - Factory Method 패턴에서 구체적인 생성자와 추상 생성자 간의 관계

### 3. 의존 (Dependency): 점선 화살표
- 의미: 한 클래스가 다른 클래스를 일시적으로 사용함을 나타냅니다.
- 방향: 사용하는 클래스 → 사용되는 클래스
- 설계 패턴 예시:
    - Builder 패턴에서 Director와 Builder 간의 관계
    - Command 패턴에서 Invoker와 Command 간의 관계

### 4. 실현 (Realization): 빈 삼각형이 있는 점선 화살표
- 의미: 인터페이스 구현
- 방향: 구현 클래스 → 인터페이스
- 설계 패턴 예시:
    - Strategy 패턴에서 구체적인 전략과 전략 인터페이스 간의 관계
    - State 패턴에서 구체적인 상태와 상태 인터페이스 간의 관계

### 5. 집합 (Aggregation): 빈 다이아몬드 화살표
- 의미: "전체-부분" 관계를 나타내며, 부분이 전체와 독립적으로 존재할 수 있습니다.
- 방향: 전체 → 부분
- 설계 패턴 예시:
    - Composite 패턴에서 Composite와 Component 간의 관계

### 6. 합성 (Composition): 채워진 다이아몬드 화살표
- 의미: 강한 "전체-부분" 관계를 나타내며, 부분이 전체에 종속적입니다.
- 방향: 전체 → 부분
- 설계 패턴 예시:
    - Decorator 패턴에서 ConcreteDecorator와 Component 간의 관계
