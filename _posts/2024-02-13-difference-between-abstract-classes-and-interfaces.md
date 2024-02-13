---
layout: post
title: 추상 클래스와 인터페이스의 차이
tags: [Java, 추상 클래스와 인터페이스의 차이]
categories: [Java, 추상 클래스와 인터페이스의 차이]
image:
  path: /assets/img/post/java/interface-vs-abstract-class.png
  alt: interface-vs-abstract-class
date: 2024-02-13 18:01 +0900
---

오늘은 추상 클래스와 인터페이스의 차이점에 대해 알아보자. <br>
먼저 클래스와 추상 클래스에 차이점이 뭔지 알아보자. Here we go 😉

## 클래스 (Class)

- 일반적인 클래스는 **객체를 생성하기 위한 청사진(BluePrint)**이다.
- 클래스는 **객체의 상태를 나타내는 필드(멤버 변수)**와 **객체의 동작을 나타내는 메서드**로 구성된다.
- **객체를 생성하기 위해서는 클래스의 인스턴스를 생성**해야 한다. 이러한 인스턴스는 특정 클래스의 객체를 나타낸다.

## 추상 클래스 (Abstract Class)

- 추상 클래스는 일부 메서드를 구현하지 않고, 추상 메서드를 포함하는 클래스이다.
- **추상 메서드는 선언만 있고 구현이 없으며, 서브 클래스에서 반드시 구현**되어야 한다.
- **추상 클래스는 객체를 직접 생성할 수 없다**. 대신 **추상 클래스를 상속받은 서브 클래스에서 추상 메서드를 구현하여 사용**할 수 있다.
- 추상 클래스는 **상속을 통해 기능을 확장하고 공통된 특성을 추상화할 때 사용**된다.

## 클래스와 추상 클래스의 차이점

- **인스턴스화 가능 여부**
  - **클래스는 직접 객체를 생성**할 수 있다.
  - **추상 클래스는 직접 객체를 생성할 수 없다**. 대신 서브 클래스에서 추상 메서드를 구현하여 사용할 수 있다.
- **추상 메서드의 존재 여부**
  - 클래스는 **모든 메서드가 구현**되어 있다.
  - **추상 클래스는 추상 메서드를 포함**할 수 있으며, **추상 메서드는 서브 클래스에서 반드시 구현**되어야 한다.
- **확장성**
  - 클래스는 상속을 통해 다른 클래스에 기능을 확장할 수 있다.
  - **추상 클래스는 상속을 통해 기능을 확장하고 공통된 특성을 추상화**할 수 있다.

```java
// 추상 클래스
abstract class Shape {
    // 추상 메서드
    abstract void draw();

    // 일반 메서드
    void display() {
        System.out.println("Displaying shape");
    }
}

// 서브 클래스
class Circle extends Shape {
    // 추상 메서드 구현
    void draw() {
        System.out.println("Drawing circle");
    }
}

// 메인 클래스
public class Main {
    public static void main(String[] args) {
        // 추상 클래스는 인스턴스화할 수 없지만, 서브 클래스로 객체를 생성하여 사용할 수 있습니다.
        Circle circle = new Circle();
        circle.draw(); // "Drawing circle" 출력
        circle.display(); // "Displaying shape" 출력
    }
}
```

> 클래스와 추상 클래스에 차이점에 대해 알아보았다. **이제 추상 클래스와 인터페이스에 차이점**을 알아보자. 😉

## 인터페이스(Interface)

인터페이스는 **일종의 명세서**이다. **클래스가 반드시 가져야 할 메서드의 시그니처(메서드 이름, 매개변수, 반환 타입)들을 정의**한다.

클래스는 인터페이스를 구현(Implements)함으로써, **인터페이스가 정의한 메서드들을 모두 구현**해야 한다. 인터페이스는 **다른 클래스들이 서로 다른 구현을 가지고 있을 때 이들을 통일된 방식**으로 다룰 수 있도록 해준다.

### 인터페이스의 특징

- **모든 메서드는 추상 메서드로 선언**된다.
  - 메서드의 구현을 가지지 않고, 메서드의 시그니처만을 정의한다.
  - **Java 8부터는 디폴트 메서드와 정적 메서드를 인터페이스 내에 구현**할 수 있게 되었다.
- **상수(Constant)를 선언할 수 있다**.
  - 인터페이스 내에서 선언한 변수는 자동으로 public static final로 선언된다.
    - **public**: 해당 변수는 어디서든 접근할 수 있다.
    - **static**: **클래스의 모든 인스턴스가 공유하는 변수**이며, 클래스가 로드될 때 메모리에 할당된다.
    - **final**: **값이 한 번 할당되면 변경할 수 없음을 의미**한다.
- **인터페이스는 다른 인터페이스를 상속할 수 있다**.

```java
// 인터페이스 선언
interface Animal {
    void makeSound(); // 추상 메서드
}

// 인터페이스 구현
class Dog implements Animal {
    // 추상 메서드 구현
    public void makeSound() {
        System.out.println("Bark");
    }
}

class Cat implements Animal {
    // 추상 메서드 구현
    public void makeSound() {
        System.out.println("Meow");
    }
}

// 메인 클래스
public class Main {
    public static void main(String[] args) {
        // 인터페이스를 구현한 객체 생성
        Animal dog = new Dog();
        dog.makeSound(); // "Bark" 출력

        Animal cat = new Cat();
        cat.makeSound(); // "Meow" 출력
    }
}
```

### 추상 클래스와 인터페이스 차이점

- **추상 클래스는 추상 메서드뿐만 아니라 구현된 메서드도 가질 수 있다**.
- **인터페이스는 모든 메서드가 추상 메서드이므로 구현된 메서드가 없다**.
- **다중 상속**:
  - **자바에서 클래스는 단일 상속만을 지원**한다.
  - 인터페이스는 다중 상속을 지원한다.
- **용도**
  - 추상 클래스는 **객체의 공통된 특징을 추상화하여 코드의 재사용성과 확장성을 증가시킬 때 사용**
  - 인터페이스는 **클래스 간의 관계를 정의하고, 다양한 클래스들이 동일한 동작을 보장**하기 위한 명세를 제공할 때 사용
- **상속과 구현**
  - **추상 클래스는 상속을 통해 확장**된다. 즉, 다른 클래스에서 상속을 받아 기능을 확장할 수 있다.
  - **인터페이스는 클래스가 구현(implement)하여 사용**된다. 클래스는 인터페이스의 메서드들을 모두 구현해야 한다.
- **인스턴스화**

  - 추상 클래스는 직접 인스턴스화할 수 없다. 추상 클래스의 인스턴스는 추상 클래스를 상속받은 서브 클래스에서 생성
  - 인터페이스도 직접 인스턴스화할 수 없다. 클래스가 인터페이스를 구현한 후에 해당 클래스의 인스턴스를 생성

- **인터페이스 예제**
  - 다중 상속이 가능하며, 인터페이스 내에 추상메서드는 반드시 구현해야함

```java
// 인터페이스 1
interface Walkable {
    void walk();
}

// 인터페이스 2
interface Swimmable {
    void swim();
}

// 인터페이스 3
interface Flyable {
    void fly();
}

// 클래스
class Animal implements Walkable, Swimmable, Flyable {
    // 인터페이스들의 메서드를 구현
    public void walk() {
        System.out.println("Walking");
    }

    public void swim() {
        System.out.println("Swimming");
    }

    public void fly() {
        System.out.println("Flying");
    }
}

// 메인 클래스
public class Main {
    public static void main(String[] args) {
        // Animal 클래스의 인스턴스 생성
        Animal animal = new Animal();

        // 다중 상속된 인터페이스의 메서드 호출
        animal.walk(); // "Walking" 출력
        animal.swim(); // "Swimming" 출력
        animal.fly();  // "Flying" 출력
    }
}
```
