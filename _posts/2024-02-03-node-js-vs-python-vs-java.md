---
layout: post
title: node.js vs python vs java
tags: [Research, node.js vs python vs java]
categories: [Research, node.js vs python vs java]
image:
  path: /assets/img/post/research/node-python-java.png
  alt: node-python-java
date: 2024-02-03 11:08 +0900
---

## Node.js

Node.js는 **JavaScript를 서버 측에서 실행할 수 있게 하는 플랫폼**이다. Google Chrome의 V8 JavaScript 엔진을 기반으로 구축되어 **빠른 성능을 자랑하며, 주로 비동기, 이벤트 기반의 서버를 구축**하는 데 사용된다. Node.js는 자체적으로 많은 모듈을 제공하고, NPM(Node Package Manager)을 통해 수많은 오픈 소스 라이브러리를 이용할 수 있어서, 웹 애플리케이션의 개발을 효율적으로 할 수 있게 돕는다.

- **특징**
  - **비동기 이벤트 기반 실행**: 이벤트 기반, 비동기 I/O 모델을 사용하여 **높은 동시성과 빠른 실행 속도를 제공**한다.
  - **단일 언어 사용**: **프론트엔드와 백엔드 모두 JavaScript를 사용하므로 개발 프로세스가 일관되고 통합적**이다.
  - **NPM(Node Package Manager)**: 방대한 수의 라이브러리와 도구를 제공하는 NPM을 통해 기능 확장이 쉽다.
- **장단점**
  - **장점**
    - **빠른 실행 속도와 높은 동시성 처리 능력**
    - 프론트엔드와 백엔드 개발에 같은 언어 사용
    - 방대한 커뮤니티와 다양한 라이브러리
  - **단점**
    - **CPU 집약적인 작업에는 적합하지 않음**
    - 비동기 프로그래밍으로 인한 복잡성 증가

### Node.js가 CPU 집약적인 작업에 적합하지 않은 이유❗️

- **비동기 I/O 작업에 최적화**: Node.js의 설계는 I/O 작업이 많은 웹 서버와 같은 애플리케이션에 최적화되어 있다. 이러한 환경에서는 작업 대부분이 데이터베이스 쿼리, 파일 시스템 작업, 네트워크 요청과 같은 I/O 작업이며, CPU 사용률이 상대적으로 낮다.
- **싱글 스레드 모델**: **Node.js는 기본적으로 싱글 스레드로 동작**한다. Node.js의 이벤트 루프는 한 번에 하나의 작업만 처리할 수 있는데, **CPU 집약적인 작업이 실행되면 이벤트 루프가 해당 작업에 묶여** 다른 비동기 I/O 작업이나 요청을 처리할 수 없게 되며, 이는 시스템의 전반적인 처리 능력을 저하시킬 수 있다.
  - **CPU 집약적인 작업** : 중앙 처리 장치**(CPU)에 상당한 계산 부담을 주는 작업**들을 의미
    - **예시**
      - **과학적 계산**: 물리학, 화학, 생명 과학 분야의 연구에서 사용되는 대규모 수치 계산
      - **머신 러닝 및 딥러닝**: 대규모 데이터셋을 사용하는 학습 프로세스나 복잡한 인공 지능 알고리즘의 실행
      - **3D 그래픽스와 게임 개발**: 3D 모델링, 렌더링 및 물리 시뮬레이션 등은 상당한 계산 능력 필요

### Node.js 예시 코드

비동기 작업 처리에 탁월하며 특히 다중 I/O 작업을 처리하는 웹 서버에 유용 <br>
해당 예시는 fs.readFile은 비동기이므로 Node.js가 파일을 읽는 동안 다른 작업을 수행할 수 있다.

```js
const fs = require("fs");

// Asynchronous file read
fs.readFile("example.txt", "utf-8", (err, data) => {
  if (err) {
    console.error("Error reading the file");
    return;
  }
  console.log(data);
});

console.log("Reading file..."); // This will be displayed before the file content
```

## Python

Python은 깔끔하고 **읽기 쉬운 문법을 가진 인터프리터형 프로그래밍 언어**이다. 다양한 프로그래밍 패러다임(절차적, 객체 지향적, 함수형 등)을 지원하며, 강력한 표준 라이브러리가 존재한다. Python은 **웹 개발, 데이터 과학, 인공 지능, 과학적 계산 등 여러 분야에서 널리 사용되며, 초보자가 배우기 좋은 언어로 평가**받고 있다.

- **특징**
  - **간결하고 읽기 쉬운 문법**: Python은 인간이 읽기 쉬운 코드를 작성할 수 있도록 설계되었다.
  - **객체 지향, 절차 지향, 함수형 프로그래밍 지원**: 다양한 프로그래밍 패러다임을 지원한다.
    - **JavaScript도 같은 프로그래밍 패러다임을 모두 지원**
    - **Java의 경우가 대표적인 객체 지향 프로그래밍 언어**이며, Java 8부터는 람다 표현식을 도입함으로써 함수형 프로그래밍 스타일도 일부 지원
  - **포괄적인 표준 라이브러리**: 네트워킹, 파일 I/O, 시스템 관리 등 다양한 분야를 아우르는 라이브러리를 제공한다.
- **장단점**
  - **장점**
    - **읽고 쓰기 쉬운 코드**
    - **다양한 분야(웹 개발, 데이터 과학, 인공 지능 등)에서의 활용성**
    - 방대한 커뮤니티 지원과 라이브러리
  - **단점**
    - **상대적으로 느린 실행 속도**
    - **글로벌 인터프리터 락(GIL)으로 인한 멀티스레딩 제한** : GIL의 주요 목적은 Python 인터프리터 자체가 **멀티스레딩으로 인해 발생할 수 있는 동시성 문제**로부터 안전하게 보호하는 것
      - **단일 스레드 실행**: GIL은 한 번에 하나의 스레드만 Python 객체와 상호 작용하도록 허용한다. 즉, 멀티스레드 환경에서도 실제로는 한 번에 한 스레드만이 Python 코드를 실행할 수 있다. 이는** Python이 실제로 병렬 처리를 할 수 없게 만든다**.
      - **CPU 집중적 작업의 성능 저하**: CPU를 많이 사용하는 작업의 경우, GIL로 인해 멀티스레딩이 기대하는 성능 향상을 가져오지 못할 수 있다. 스레드들이 CPU 자원을 경쟁해야 하지만, GIL 때문에 동시에 실행될 수 없기 때문이다.

Python은 데이터 과학, 인공 지능, 과학적 계산 같은 곳에 사용된다고 하지 않았나? <br>
근데 GIL때문에 CPU 집중적 작업의 성능 저하가 일어난다면 어떡하지? 🧐 <br>

Python의 **멀티프로세싱 모듈을 사용하여 병렬 처리를 구현**할 수 있으며, 이는 **각 프로세스가 독립적인 GIL**을 가지므로, 멀티코어 시스템에서 진정한 병렬 처리를 가능하게 한다.

### Python 예시 코드

단순성과 가독성으로 유명하여 데이터 과학 및 스크립팅에서 선호되는 언어 <br>
해당 예시는 Python 라이브러리인 matplotlib를 사용하여 간단한 그래프를 그린다.

```python
import matplotlib.pyplot as plt

# Data for plotting
x = [1, 2, 3, 4, 5]
y = [1, 4, 9, 16, 25]

plt.plot(x, y)
plt.ylabel('Squares')
plt.xlabel('Numbers')
plt.title('Plot of Squares')
plt.show()
```

## Java

Java는 **객체 지향 프로그래밍 언어**로, 한 번 작성하면 어디서든 실행될 수 있는**(WORA, Write Once, Run Anywhere) 특성**을 가지고 있습니다. 이는 Java 프로그램이 Java Virtual Machine(JVM) 위에서 실행되기 때문에 가능한데, 이 때문에 다양한 플랫폼에서 Java 애플리케이션을 실행할 수 있다. Java는 **안정성과 확장성이 뛰어나기 때문에, 대규모 엔터프라이즈 시스템, 안드로이드 앱 개발, 웹 백엔드 시스템 등 다양한 분야에서 널리 사용**됩니다.

> Node.js와 Python도 Java처럼 크로스 플랫폼 능력을 갖추고 있다. 그러나 Java의 JVM과는 달리, Node.js와
> Python은 각기 다른 방식으로 크로스 플랫폼을 지원한다. **Node.js는 V8 엔진을 기반으로 하는 JavaScript 런타임**
> 환경을 제공하고, **Python은 인터프리터**를 통해 다양한 운영 체제에서 Python 코드를 실행할 수 있게 한다.
> <br><br>
> 즉, 세 가지 언어 전부 크로스 플랫폼을 지원한다. ❗️

- **특징**
  - **객체 지향 프로그래밍 언어**: **클래스 기반, 객체 지향 패러다임을 적극적으로 사용**
  - **플랫폼 독립성**: 'Write Once, Run Anywhere' 철학에 따라, JVM(Java Virtual Machine) 위에서 실행되어 다양한 환경에서 호환된다.
  - **강력한 메모리 관리**: 가비지 컬렉션을 통한 자동 메모리 관리를 제공한다.
    - JavaScript와 Python 모두 Java와 유사하게 메모리 관리를 자동으로 처리하는 기능이 있다. 각 언어의 가비지 컬렉션(Garbage Collection, GC) 시스템은 약간의 차이가 있지만, 기본적인 목적은 개발자가 직접 메모리를 할당하고 해제하는 것이 아니라, **사용하지 않는 메모리를 자동으로 회수하여 메모리 누수를 방지**하는 것
- **장단점**
  - **장점**
    - 높은 이식성과 플랫폼 독립성
    - 강력한 표준 라이브러리와 다양한 프레임워크
    - **안정적이고 유지보수가 쉬운 코드**
  - **단점**
    - **상대적으로 느린 실행 속도 (정확히는 컴파일 시간)**
    - 보일러플레이트 코드가 많아질 수 있음

### Java 예시 코드

Java는 강력한 객체 지향 언어이므로 대규모 고성능 애플리케이션에 적합하다. <br>
해당 예시는 Java에서 'Bicycle' 클래스를 정의하고 객체 지향 프로그래밍의 기본 개념인 캡슐화 및 메서드를 보여준다.

```java
class Bicycle {
    private int gear;
    private int speed;

    // Constructor
    Bicycle(int gear, int speed) {
        this.gear = gear;
        this.speed = speed;
    }

    // Method to increase speed
    void speedUp(int increment) {
        speed += increment;
    }

    // Method to print info
    void printInfo() {
        System.out.println("Gear: " + gear + "\nSpeed: " + speed);
    }
}

public class Main {
    public static void main(String args[]) {
        Bicycle bike = new Bicycle(3, 100);
        bike.speedUp(20);
        bike.printInfo();
    }
}
```
