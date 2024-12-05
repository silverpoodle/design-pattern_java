# DESIGN PATTERN

## Creational Pattern

### 1. Singleton
`생성자가 여러 차례 호출되더라도 실제로 생성되는 객체는 하나이고 최초 생성 이후에 호출된 생성자는 최초의 생성자가 생성한 객체를 리턴`

#### a. Eager Initialization 

- 특징: 클래스 로딩 시점에 인스턴스를 생성
- 장점: 단순하고 thread-safe
- 단점: 인스턴스가 사용되지 않아도 메모리를 차지

```java
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    
    private EagerSingleton() {}
    
    public static EagerSingleton getInstance() {
        return instance;
    }
}
```

#### b. Lazy Initialization (지연 초기화)

- 특징: 인스턴스가 필요한 시점에 생성
- 장점: 필요할 때만 인스턴스 생성, 메모리 효율적
- 단점: Thread-safe하지 않음

```java
public class LazySingleton {
    private static LazySingleton instance;
    
    private LazySingleton() {}
    
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
```

#### c. Synchronized 방식

- 특징: getInstance() 메서드에 synchronized 키워드 사용
- 장점: Thread-safe
- 단점: 성능 저하 (매번 동기화 처리)

```java
public class SynchronizedSingleton {
    private static SynchronizedSingleton instance;
    
    private SynchronizedSingleton() {}
    
    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}
```

#### d. Double Checked Locking (DCL)

- 특징: 두 번 체크하여 동기화 영역 최소화
- 장점: Thread-safe하면서 성능 개선
- 단점: 복잡한 구현, Java 1.5 이전 버전에서 문제 발생 가능

```java
public class DCLSingleton {
    private static volatile DCLSingleton instance;
    
    private DCLSingleton() {}
    
    public static DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}
```

## 5. Initialization on Demand Holder (Demand Holder)

- 특징: 내부 정적 클래스를 사용하여 초기화
- 장점: Thread-safe, 성능 우수, 지연 초기화
- 단점: 복잡한 구현

```java
public class DemandHolderSingleton {
    private DemandHolderSingleton() {}
    
    private static class SingletonHolder {
        private static final DemandHolderSingleton INSTANCE = new DemandHolderSingleton();
    }
    
    public static DemandHolderSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
```

<br/>

### 2. Builder

`복잡한 객체의 생성 과정과 표현 방법을 분리하여 다양한 구성의 인스턴스를 만드는 생성 패턴`

- 객체 생성 과정의 유연성: 같은 생성 과정으로 다양한 표현의 객체를 만들 수 있음
- 가독성 향상: 많은 매개변수를 가진 생성자 대신 메서드 체이닝을 통해 객체를 생성할 수 있음
- 불변성: 객체 생성 후 상태를 변경할 수 없게 만들 수 있음
- `@Builder` 어노테이션 사용 가능

## Behavioral Pattern

### 1. Strategy
<img src="https://github.com/silverpoodle/typora-images/blob/main/image.png?raw=true" alt="image-20240218203439687" style="zoom:50%;" />

`객체가 할 수 있는 행위들 각각을 전략으로 만들어 놓고, 동적으로 행위의 수정이 필요한 경우 전략을 바꾸는 것만으로 행위의 수정이 가능하도록 만든 패턴`

- 알고리즘 변경 쉬움
- 새로운 전략 추가하기 쉬움 **(OCP)**
- 조건문을 제거하여 더 깔끔한 코드

> **Context** = 전략을 사용하는 클래스 <br/>
> **Strategy Interface** = 공통되는 interface  <br/>
> **Concrete Strategy** = Interface 를 구현한 class

<br/>

### 2. Command
<img src="https://github.com/silverpoodle/typora-images/blob/main/command.png?raw=true" alt="image" style="zoom:60%;" />

`실행될 기능을 캡슐화함으로써 주어진 여러 기능을 실행할 수 있는 재사용성이 높은 클래스를 설계하는 패턴`

- 작업을 요청하는 객체와 그 작업을 수행하는 객체를 분리
- 새로운 Command를 추가하기 쉬움 **(OCP)**
- 복합 명령(매크로 명령)을 쉽게 구현할 수 있음
- 실행 취소(Undo) 기능을 구현하기 쉬움

> **Command** = 실행될 기능에 대한 인터페이스 <br/>
> **Concrete Command** = 실제 실행될 기능을 구현  <br/>
> **Invoker** =  기능의 실행을 요청 <br/>
> **Receiver** = Concrete Command 에서 실제 기능 수행

<br/>

### 3. Observer
<img src="https://github.com/silverpoodle/typora-images/blob/main/observer.png?raw=true" alt="image" style="zoom:60%;" />

`일대다(one-to-many) 의존 관계를 정의하여, 어떤 객체의 상태가 변할 때 그와 연관된 객체 들에게 알림을 보내는 디자인 패턴`

- 느슨한 결합(Loose Coupling): Subject와 Observer는 서로 독립적으로 변경 가능
- 기존 코드를 변경하지 않고 새로운 Observer를 추가 가능 **(OCP)**
- 일관성 있는 갱신: 모든 Observer가 동시에 갱신됨.

> **Subject** = 관찰 대상이 되는 객체. Observer들을 등록하고 제거하는 메서드를 가짐 <br/>
> **Observer** = Subject의 변경을 통보받는 객체들의 인터페이스  <br/>
> **ConcreteSubject** =  Subject 인터페이스를 구현하는 구체적인 클래스 <br/>
> **ConcreteObserver** = Observer 인터페이스를 구현하는 구체적인 클래스

<br/>

### 4. Decorator

<img src="https://github.com/silverpoodle/typora-images/blob/main/decorator.png?raw=true" alt="image" style="zoom:90%;" />

`객체에 동적으로 새로운 책임을 추가할 수 있게 해주는 디자인 패턴. 기존 코드를 변경하지 않고 확장할 수 있다.`

- 단일 책임 원칙(SRP): 클래스가 하나의 책임만을 가짐
- 기존 코드를 수정하지 않고 새로운 기능을 추가 가능 **(OCP)**
- 런타임에 동적으로 기능을 추가/제거할 수 있음

> **Component** = 원본 객체와 데코레이터에 공통적으로 정의되는 인터페이스 <br/>
> **ConcreteComponent** = 원본 객체. 추가적인 책임이 추가될 수 있는 기본 객체 <br/>
> **Decorator** = Component를 참조하며 공통 인터페이스를 구현하는 추상 클래스 <br/>
> **ConcreteDecorator** = 실제 책임을 추가하는 구체적인 데코레이터 클래스


<br/>

### 5. Template Method

<img src="https://github.com/silverpoodle/typora-images/blob/main/template.png?raw=true" alt="image" style="zoom:70%;" />

`알고리즘의 구조를 메서드에 정의하고, 하위 클래스에서 알고리즘의 특정 단계를 재정의할 수 있게 하는 디자인 패턴. 변하지 않는 기능은 상위 클래스에 만들어두고 자주 변경되며 확장할 기능은 하위 클래스에서 구현한다.`

- 중복 코드 제거: 공통 알고리즘을 상위 클래스에 정의
- 하위 클래스에서 알고리즘 구조 변경 없이 특정 단계만 재정의 가능 **(OCP)**
- 코드 재사용과 유지보수성 향상: 변하지 않는 부분은 상위 클래스에서 관리

> **AbstractClass** = 템플릿 메서드를 정의하는 추상 클래스. 알고리즘의 뼈대를 구현 <br/>
> **ConcreteClass** = 추상 클래스에서 정의한 추상 메서드를 구체적으로 구현하는 클래스 <br/>
> **templateMethod()** = 알고리즘의 골격을 정의하는 메서드. 하위 클래스에서 오버라이드 불가능(final) <br/>
> **primitiveOperation()** = 하위 클래스에서 구현해야 하는 추상 메서드들

 <br/>

### 6. GoF Factory Method

<img src="https://github.com/silverpoodle/typora-images/blob/main/factory.png?raw=true" alt="image" style="zoom:80%;" />

`객체 생성을 위한 인터페이스를 정의하고, 인스턴스 생성은 하위 클래스가 결정하도록 하는 디자인 패턴. 객체의 생성과 사용을 분리한다.`

- 객체 생성 로직과 사용 로직의 분리: 결합도 감소
- 기존 코드 수정 없이 새로운 제품 클래스 추가 가능 **(OCP)**
- 객체 생성의 캡슐화: 구체적인 객체 생성 과정을 감춤

> **Creator** = 팩토리 메서드를 추상화한 클래스. 객체 생성을 위한 인터페이스를 정의 <br/>
> **ConcreteCreator** = 실제 객체를 생성하는 팩토리 메서드를 구현하는 클래스 <br/>
> **Product** = 팩토리 메서드로 생성될 객체의 공통 인터페이스 <br/>
> **ConcreteProduct** = 실제 생성되는 구체적인 제품 클래스

 <br/>

### 7. Abstract Factory Method

<img src="https://github.com/silverpoodle/typora-images/blob/main/abstractfac.png?raw=true" alt="image" style="zoom:70%;" />

`관련성 있는 여러 객체의 군을 생성하기 위한 인터페이스를 제공하는 디자인 패턴. 구체적인 클래스에 의존하지 않고 서로 연관되거나 의존적인 객체들의 조합을 만드는 인터페이스를 제공한다.`

- 제품군을 쉽게 대체할 수 있음: 전체 제품군을 한번에 교체 가능
- 제품 사이의 일관성 보장: 같은 제품군의 객체들만 생성됨
- 구체적인 클래스와의 결합도를 낮춤 **(DIP)**

> **AbstractFactory** = 연관된 객체들의 생성을 위한 인터페이스를 정의 <br/>
> **ConcreteFactory** = 구체적인 제품을 생성하는 팩토리 클래스 <br/>
> **AbstractProduct** = 연관된 제품들의 공통 인터페이스 <br/>
> **ConcreteProduct** = 구체적인 제품을 구현하는 클래스

Factory Method와의 주요 차이점은:
- Factory Method는 한 종류의 객체 생성을 다룸
- Abstract Factory는 연관된 여러 종류의 객체 군을 생성함


 <br/>

### 8. Composite

<img src="https://github.com/silverpoodle/typora-images/blob/main/composite.png?raw=true" alt="image" style="zoom:60%;" />

`부분과 전체의 계층을 표현하기 위한 디자인 패턴. 클라이언트가 개별 객체와 복합 객체를 동일하게 다룰 수 있게 한다.`

- 복잡한 트리 구조를 효과적으로 처리: 재귀적 구조를 통한 처리
- 단일 객체와 복합 객체를 동일하게 취급: 일관된 방식으로 처리 가능
- 새로운 요소 추가가 용이함 **(OCP)**

> **Component** = Leaf와 Composite를 동일하게 다루기 위한 공통 인터페이스 <br/>
> **Leaf** = 구체적인 부분 클래스. 자식을 가질 수 없는 객체 <br/>
> **Composite** = 복합 객체. 부분 객체들을 포함하며 관리하는 클래스 <br/>
> **Client** = Component 인터페이스를 통해 복합 객체 구조를 조작

예를 들어 파일 시스템에서:
- Component = 파일시스템 요소
- Leaf = 파일
- Composite = 디렉토리 (다른 파일과 디렉토리를 포함할 수 있음)

 <br/>

### 9. Adapter

<img src="https://github.com/silverpoodle/typora-images/blob/main/image.png?raw=true" alt="image" style="zoom:60%;" />

`한 클래스의 인터페이스를 클라이언트에서 사용하고자 하는 다른 인터페이스로 변환하는 디자인 패턴. 호환되지 않는 인터페이스를 가진 클래스들이 함께 동작하도록 해준다.`

- 기존 코드를 변경하지 않고 새로운 인터페이스 적용 가능 **(OCP)**
- 호환되지 않는 클래스들을 함께 동작하게 함
- 기존 클래스의 재사용성을 높임

> **Target** = 클라이언트가 사용하려는 인터페이스. 클라이언트가 직접 사용하는 인터페이스 <br/>
> **Adaptee** = 적응이 필요한 기존 클래스. 변환이 필요한 인터페이스를 가진 클래스 <br/>
> **Adapter** = Target 인터페이스를 구현하여 Adaptee의 인터페이스를 Target 인터페이스에 맞추는 클래스 <br/>
> **Client** = Target 인터페이스를 사용하는 클래스

두 가지 구현 방식:
- 클래스 어댑터: 상속을 사용
- 객체 어댑터: 합성을 사용

예시 상황:
- 220V를 사용하는 한국의 가전제품(Adaptee)
- 110V를 사용하는 미국의 전원(Target)
- 변압기(Adapter)가 220V를 110V로 변환
