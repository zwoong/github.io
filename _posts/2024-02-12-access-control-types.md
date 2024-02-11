---
layout: post
title: 접근 제어 종류
tags: [Java, 접근 제어 종류]
categories: [Java, 접근 제어 종류]
image:
  path: /assets/img/post/java/access-control-types.webp
  alt: access-control-types
date: 2024-02-12 00:34 +0900
---

## 접근 제어자

자바에서는 **접근 제어자(access modifier)를 사용하여 클래스, 메서드, 변수 등의 접근 권한을 제어**한다. 접근 제어자는 해당 멤버에 대한 접근을 어디까지 허용할지 지정한다.

### 접근 제어 종류

- **public**: **해당 멤버에 대한 접근을 어디서든 허용**한다. 다른 패키지에 속한 클래스에서도 접근할 수 있다.
- **protected**: **같은 패키지 내의 클래스와 해당 클래스를 상속하는 하위 클래스에서 접근 가능**하다.
- **default (package-private)**: 접근 제어자를 명시하지 않은 경우 기본적으로 적용되는 제어자로, **같은 패키지 내에서만 접근이 가능**하다.
- **private**: **해당 클래스 내에서만 접근이 가능**하다. **외부에서 직접적인 접근이 불가능**하며, 주로 정보 은닉을 위해 사용된다.

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Example example = new Example();

        // public 멤버에 접근 가능
        System.out.println("Public variable: " + example.publicVariable);
        example.publicMethod();

        // default 멤버에 접근 가능
        System.out.println("Default variable: " + example.defaultVariable);
        example.defaultMethod();

        // protected 멤버에 접근 가능 (같은 패키지)
        System.out.println("Protected variable: " + example.protectedVariable);
        example.protectedMethod();

        // private 멤버에 접근 불가능
        // System.out.println("Private variable: " + example.privateVariable); // 컴파일 에러
        // example.privateMethod(); // 컴파일 에러
    }
}

class Example {
    public int publicVariable = 10;
    int defaultVariable = 30;
    protected int protectedVariable = 20;
    private int privateVariable = 40;

    public void publicMethod() {
        System.out.println("This is a public method.");
    }

    void defaultMethod() {
        System.out.println("This is a default method.");
    }

    protected void protectedMethod() {
        System.out.println("This is a protected method.");
    }

    private void privateMethod() {
        System.out.println("This is a private method.");
    }
}
```

## static 및 non-static 차이

static과 non-static은 자바에서 멤버(변수, 메서드)에 적용되는 키워드이다. 이 두 키워드는 **해당 멤버의 특성과 동작 방식을 결정**하며, 클래스의 인스턴스와 관련하여 다음과 같은 차이점이 있다.

- **Static** 멤버
  - **클래스 레벨에 속하는 멤버**이다.
  - 클래스가 로딩될 때 한 번만 메모리에 로드되며, **인스턴스를 생성하지 않고도 사용**할 수 있다.
  - 메모리 공간에서는 클래스의 메모리 공간에 할당된다.
- **Non-static (Instance) 멤버**
  - **인스턴스 레벨에 속하는 멤버**이다. 즉, 해당 클래스의 각 인스턴스마다 별도의 값이 존재한다
  - 클래스의 인스턴스가 생성될 때마다 메모리에 새로운 인스턴스 멤버가 생성된다.
  - **반드시 클래스의 인스턴스를 생성해야 사용**할 수 있다.
  - 메모리 공간에서는 인스턴스의 메모리 공간에 할당된다.

```java
class Example {
    // static 변수
    static int staticVariable = 0;
    // 인스턴스 변수
    int instanceVariable = 0;

    // static 메서드
    static void staticMethod() {
        System.out.println("This is a static method.");
    }

    // 인스턴스 메서드
    void instanceMethod() {
        System.out.println("This is an instance method.");
    }
}
public class Main {
    public static void main(String[] args) {
        // static 변수와 static 메서드는 클래스 이름으로 접근 가능
        Example.staticVariable = 1;
        Example.staticMethod();

        // 인스턴스 변수와 인스턴스 메서드는 객체를 생성한 후에만 접근 가능
        Example obj1 = new Example();
        obj1.instanceVariable = 2;
        obj1.instanceMethod();

        // 또 다른 객체를 생성하여 인스턴스 변수와 메서드에 접근
        Example obj2 = new Example();
        obj2.instanceVariable = 3;
        obj2.instanceMethod();

        // static 변수는 모든 인스턴스에서 공유되는 값이기 때문에,
        // 하나의 인스턴스에서 변경하면 모든 인스턴스에 반영됨
        System.out.println("staticVariable value from obj1: " + obj1.staticVariable);
        System.out.println("staticVariable value from obj2: " + obj2.staticVariable);
        obj1.staticVariable = 100; // obj1에서 staticVariable 값 변경
        System.out.println("staticVariable value from obj1 after modification: " + obj1.staticVariable);
        System.out.println("staticVariable value from obj2 after modification: " + obj2.staticVariable);
    }
}
```
