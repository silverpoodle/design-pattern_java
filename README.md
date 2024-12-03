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

`동일한 클래스의 다른 객체의 동작에 영향을 주지 않고, 개별 객체에 동적으로 동작을 추가할 수 있는 구조적 디자인 패턴`

- 