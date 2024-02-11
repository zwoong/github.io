---
layout: post
title: 객체 지향 프로그래밍
tags: [Java, 객체 지향 프로그래밍]
categories: [Java, 객체 지향 프로그래밍]
image:
  path: /assets/img/post/java/object-oriented-programming.png
  alt: object-oriented-programming
date: 2024-02-11 21:17 +0900
---

## 객체지향 프로그래밍의 특징

- **클래스와 객체**
  - **클래스는 객체를 정의하는 틀**이며, **객체는 클래스의 인스턴스**이다.
  - 클래스는 객체의 상태와 행동을 정의하는데 사용된다.
- **캡슐화 (Encapsulation)**
  - **데이터와 메서드를 하나의 단위로 묶어서 외부로부터 데이터를 보호하고 데이터 접근을 제어하는 개념**이다. 클래스의 내부 데이터에 직접 접근하는 것을 제한하고, 메서드를 통해 데이터를 조작하도록 하는 것이 일반적이다.

```java
// 클래스 정의
class BankAccount {
    // 클래스의 상태(멤버 변수)
    private String accountNumber;
    private double balance;

    // 클래스의 행동(메서드)
    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        // 객체 생성
        BankAccount myAccount = new BankAccount("123456");

        // 객체의 메서드 호출
        myAccount.deposit(1000);
        myAccount.withdraw(500);
        myAccount.displayBalance();
    }
}
```

- **상속 (Inheritance)**
  - 상속은 **부모 클래스의 특성과 기능을 자식 클래스에게 물려주는 개념**이다. 이를 통해 코드 재사용성을 높이고, 계층적인 관계를 구성할 수 있다.

```java
// 부모 클래스 정의
class Animal {
    public void speak() {
        System.out.println("Animal speaks");
    }
}

// 자식 클래스 정의
class Dog extends Animal {
    public void speak() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        // 객체 생성
        Dog myDog = new Dog();

        // 객체의 메서드 호출
        myDog.speak(); // "Dog barks" 출력
    }
}
```

- **다형성 (Polymorphism)**
  - 다형성은 **하나의 인터페이스나 메서드가 다양한 형태로 동작할 수 있는 능력을 의미**한다. 이는 **오버로딩(Overloading)과 오버라이딩(Overriding)을 통해 구현**된다.
    - **Overloading(오버로딩)**:
      - **동일한 이름의 메서드를 여러 개 정의하되, 매개변수의 유형, 개수, 순서가 다른 경우를 가리킨다**. 컴파일러가 메서드 호출 시 전달되는 인자의 유형과 개수를 기반으로 어떤 메서드를 호출할지 결정한다.
    - **Overriding(오버라이딩)**:
      - 메서드 오버라이딩은 **상위 클래스가 가지고 있는 메서드를 하위 클래스에서 재정의하는 것을 의미**한다.

**Overloading(오버로딩) 예시**

```java
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int sum1 = calc.add(3, 5);
        double sum2 = calc.add(3.5, 7.2);
        System.out.println("Sum1: " + sum1); // Sum1: 8
        System.out.println("Sum2: " + sum2); // Sum2: 10.7
    }
}
```

**Overriding(오버라이딩) 예시**

```java
class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    public void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.sound(); // Animal makes a sound

        Dog dog = new Dog();
        dog.sound(); // Dog barks
    }
}
```

## 객체지향 프로그래밍의 원칙

- **단일 책임 원칙 (Single Responsibility Principle, SRP)**
  - **클래스는 하나의 책임만을 가져야 한다**.
  - 하나의 클래스는 하나의 기능을 담당하여 하나의 책임을 수행하는데 집중되어 있어야 한다.
- **개방-폐쇄 원칙 (Open-Closed Principle, OCP)**
  - **확장에는 열려 있어야 하고, 수정에는 닫혀 있어야 한다**. 즉, 기존의 코드를 변경하지 않으면서 새로운 기능을 추가할 수 있어야 한다.
- **리스코프 치환 원칙 (Liskov Substitution Principle, LSP)**
  - 상속받은 클래스는 상위 클래스의 자리에 대체될 수 있어야 한다. 이는 **하위 클래스가 상위 클래스의 기능을 변경하지 않고 확장할 수 있어야 함**을 의미한다.
- **인터페이스 분리 원칙 (Interface Segregation Principle, ISP)**
  - 자신이 사용하지 않는 메서드에 의존하지 않아야 한다.
  - **한 인터페이스는 여러 개의 작은 인터페이스로 분리될 수 있어야 한다**.
- **의존성 역전 원칙 (Dependency Inversion Principle, DIP)**
  - 고수준 모듈은 저수준 모듈에 의존해서는 안되며, 양쪽 모두 추상화에 의존해야 한다.
  - **세부 구현이 아닌 인터페이스나 추상 클래스에 의존하도록 하는 원칙**이다.
  - **예시**
    - 쇼핑 카트를 만든다고 가정해보자. 카트에는 상품을 추가하는 기능이 있어야 한다.
    - 이때, 카트 클래스가 직접 상품 객체를 생성하고 관리한다면 카트 클래스는 상품 클래스에 의존하게 된다.
    - 하지만 DIP를 따른 설계에서는 카트 클래스가 상품 클래스에 직접 의존하지 않고, 상품을 관리하는 인터페이스를 만들어 상품 클래스가 이를 구현하도록 하는 것이다.
    - 이렇게 하면 상품 클래스가 변경되더라도 카트 클래스에는 영향을 덜 줄 수 있다.

```java
import java.util.ArrayList;
import java.util.List;

// 상품 인터페이스
interface Product {
    String getName();
}

// 상품 클래스
class ShoppingCartProduct implements Product {
    private String name;

    public ShoppingCartProduct(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// 쇼핑 카트 클래스
class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    // 상품 추가
    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to the shopping cart.");
    }

}

public class Main {
    public static void main(String[] args) {
        // 쇼핑 카트 생성
        ShoppingCart cart = new ShoppingCart();

        // 상품 추가
        cart.addProduct(new ShoppingCartProduct("Product 1"));
        cart.addProduct(new ShoppingCartProduct("Product 2"));
    }
}
```
