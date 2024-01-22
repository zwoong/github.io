---
layout: post
title: 고급 언어와 저급 언어
tags: [컴퓨터 구조, 고급 언어와 저급 언어]
categories: [컴퓨터 구조, 고급 언어와 저급 언어]
image:
  path: /assets/img/post/computer-architecture/classification-of-programming-language.jpg
  alt: classification-of-programming-language
date: 2023-11-30 10:34 +0900
---

## 고급 언어와 저급 언어

오늘은 우리가 프로그래밍 할때 사용하는 언어인 C, C++, Java, Python, Javascript 등을 컴퓨터는 어떻게 이해하고 실행하는지에 대해 알아보자.

컴퓨터 프로그래밍 영역에서 "고수준" 및 "저수준" 언어라는 용어는 컴퓨터 하드웨어의 추상화 수준을 설명하는 데 사용된다. 이러한 용어는 언어의 품질이나 성능을 나타내는 것이 아니라 **컴퓨터가 직접 실행하는 기계어 코드와 언어가 얼마나 가깝거나 멀리 떨어져 있는지**를 나타낸다. 😉

### 고급 언어 (Python, Java, C#, JavaScript, Ruby)

- **추상화**: 고급 언어는 컴퓨터 하드웨어에서 높은 수준의 추상화를 제공한다, 이는 **인간의 언어에 더 가깝고 기계어 코드와는 더 멀다는 것을 의미**한다. 사람이 쉽게 읽고 쓸 수 있도록 설계되었다.
  이러한 언어는 메모리 관리 및 하드웨어 상호 작용과 같은 복잡한 세부 사항을 처리하는 경우가 많다.
- **이식성**: 고급 언어로 작성된 코드는 **수정이 거의 또는 전혀 없이 다양한 유형의 하드웨어에서 실행**될 수 있는 경우가 많다. 이는 일반적으로 대상 하드웨어와 관련된 기계어 코드로 컴파일되거나 해석되기 때문이다.
- **사용 용이성**: 이러한 언어는 **일반적으로 배우고 사용하기가 더 쉬워서 초보자가 더 쉽게 접근할 수 있고** 웹 개발에서 인공 지능에 이르기까지 광범위한 애플리케이션에 적합하다.
- **성능**: 고급 언어는 개발자에게 더 효율적이지만 기계 코드로 변환할 때 **추가적인 추상화 계층과 오버헤드로 인해 항상 하위 수준 언어와 동일한 수준의 성능을 달성하지 못할 수도 있다**.

### 저급 언어 (어셈블리 언어, 기계 코드)

- **하드웨어에 대한 근접성**: 저수준 언어는 기계어에 더 가깝고 하드웨어로부터의 추상화를 덜 제공한다. 이는 **인간이 이해하기에는 더 복잡하고 덜 직관적이라는 것을 의미**한다.
- **하드웨어 제어**: 이러한 언어를 사용하면 하드웨어 및 시스템 리소스를 세밀하게 제어할 수 있으며 이는 **임베디드 시스템, 장치 드라이버 또는 고성능 컴퓨팅과 같은 특정 애플리케이션에 중요**할 수 있다.
- **성능**: 저수준 언어는 프로그래머가 특정 하드웨어에 맞게 코드를 최적화할 수 있도록 해주기 때문에 실행 속도와 메모리 사용량 측면에서 더 효율적일 수 있다. (개발자가 코드를 최적화하지 못하면 오히려 성능상 악영향이 있을 수 있음 ❗️)
- **어려움과 위험**: **저수준 언어로 프로그래밍하는 것은 더 복잡하고 오류가 발생하기 쉽다**. 컴퓨터 아키텍처에 대한 깊은 이해가 필요하며 일반적으로 시간이 더 많이 걸린다.
- **이식성**: 저수준 언어로 작성된 코드는 특정 유형의 프로세서나 아키텍처에만 국한되는 경우가 많아 고급 언어 코드보다 이식성이 떨어진다.

> 저급 언어는 어셈블리 언어와 기계 코드 두 종류가 있는데, 각각에 대해 좀 더 알아보자! 🧐 <br>
> 참고로 언어의 근본이라 불리는 **C언어의 경우 중간 수준 언어로 간주**된다고 한다.(고수준 언어와 저수준 언어의 요소를 결합하므로)

### 기계어 코드

기계어 코드는 **프로그래밍 언어의 가장 기본적인 수준**으로, 컴퓨터의 중앙 처리 장치(CPU)가 직접 실행할 수 있는 2진수 또는 16진수 명령어로 구성된다.

- **바이너리 형식**: 기계어 코드는 1과 0을 사용하여 바이너리 형식으로 표현된다. 이러한 이진수(비트)는 바이트(일반적으로 8비트)로 그룹화되며 각 바이트는 메모리의 명령어, 데이터 또는 주소를 나타낼 수 있다.
- **프로세서별**: **기계어 코드는 컴퓨터 프로세서의 아키텍처 및 명령어 세트에 따라 다르다**. 이는 한 가지 유형의 CPU(예: Intel x86 프로세서) 용으로 작성된 기계어 코드가 수정 없이는 다른 유형(예: ARM 프로세서)에서 작동하지 않음을 의미한다.
- **직접 실행**: 기계어 코드로 컴파일하거나 해석해야 하는 고급 언어와 달리 기계어 코드는 CPU에서 직접 실행할 수 있다. **이러한 직접 실행으로 인해 번역 오버헤드가 없으므로 속도가 매우 빠르다**.

![machine-language](/assets/img/post/computer-architecture/machine-language.png){: width="500" height="200 }

### 어셈블리 언어

- **니모닉 코드**: 인간이 읽고 쓰기 어려운 바이너리 코드(기계어 코드)를 작성하는 대신 어셈블리 언어를 사용하면 프로그래머가 니모닉 코드를 사용할 수 있다. 이는 **기계 명령어를 짧게 텍스트로 표현**한 것으로, 예를 들어 덧셈은 'ADD', 뺄셈은 'SUB', 레지스터 간 데이터 이동은 'MOV' 등이다.

- **기계어 코드와의 일대일 대응**: 각 어셈블리 언어 명령어는 일반적으로 단일 기계어 명령어에 해당한다. 이러한 일대일 대응으로 인해 어셈블리 언어는 하드웨어 작업을 밀접하게 반영하므로 "저수준" 언어가 된다.

- **하드웨어 특정**: **어셈블리 언어는 특정 컴퓨터 아키텍처에 특정한다**. 즉, 한 유형의 프로세서(예: Intel x86)용으로 작성된 어셈블리 코드는 큰 변경 없이는 다른 유형(예: ARM 프로세서)에서 작동하지 않는다.

- **제어 및 효율성**: 어셈블리 언어는 기계어에 가깝기 때문에 **프로그래머가 고급 언어에서는 불가능한 방식으로 하드웨어를 직접 조작하고, 메모리를 관리하고, 성능을 최적화**할 수 있다.

- **어셈블러 & 링커**: 어셈블러는 **어셈블리 언어를 기계어 코드로 변환**하여 객체 파일을 생성하는 도구이다. 그런 다음 링커는 이러한 **객체 파일을 가져와 단일 실행 파일이나 라이브러리로 결합**하여 프로세스의 모든 모듈 간 참조를 확인한다.

![assembly-language](/assets/img/post/computer-architecture/assembly-language.png){: width="600" }

> 고급 언어로 작성한 코드 역시 CPU가 해당 명령어를 이해할 수 있도록 저급 언어로 변환되어 실행되는데, 어떻게 고급 언어를 저급 언어로 변환하는 것일까? 🧐 <br>
> 컴파일 언어와 인터프리터 언어는 사람이 읽을 수 있는 소스 코드를 컴퓨터가 실행할 수 있는 기계어 코드로 변환하는 두 가지 기본 접근 방식을 나타내는데, 아래에서 이 두 가지 접근방식에 대해 알아보자!

#### 컴파일 언어 (C, C++, Rust, Go)

- **컴파일 프로세스**: **프로그래머가 소스 코드를 작성한 후 컴파일이라는 프로세스를 통해 기계어 코드로 변환**된다. 이는 일반적으로 **프로그램이 실행되기 전에 전체 소스 코드를 실행 파일로 변환**하는 프로그램인 컴파일러를 사용하여 수행된다.
- **실행**: 소스 코드가 실행 파일로 컴파일되면 컴퓨터 하드웨어에서 직접 실행할 수 있다. 컴파일은 일회성 프로세스이며 결과 실행 파일은 소스 코드를 다시 컴파일할 필요 없이 반복적으로 실행될 수 있다.
- **성능**: 일반적으로 **컴파일된 언어는 더 빠른 실행 시간을 제공**한다. 소스 코드는 기계어 코드로 미리 컴파일되어 있기 때문에 CPU에서 직접 실행할 수 있어 실시간 번역이 필요하지 않다.

#### 인터프리터 언어 (Python, Ruby, JavaScript, PHP)

- **해석 과정**: 인터프리터 언어에서는 소스 코드가 미리 기계어 코드로 컴파일되지 않는다. 대신 런타임 시 인터프리터가 한 줄씩 읽고 실행한다.
- **실행**: 별도의 컴파일 단계가 없으며, 소스 코드는 인터프리터에 입력되어 즉시 명령을 수행한다. 이는 호환 가능한 인터프리터가 있는 모든 시스템에서 동일한 소스 코드를 실행할 수 있음을 의미한다.
- **성능**: 인터프리터 언어는 일반적으로 소스 코드에서 기계어 코드로의 번역이 **런타임에 발생하므로 컴파일된 언어에 비해 실행 속도가 느리다**. (각 코드 줄이 실행될 때마다 해석되어야 함)

> 위 2가지 접근 방식을 모두 가지는 언어들이 있는데, 이는 대표적으로 Java가 있다. <br>
> Java 소스 코드는 바이트코드로 컴파일된 후 JVM(Java Virtual Machine)에 의해 런타임 시 기계어 코드로 해석된다. <br>
> 왜 java는 소스코드를 기계어 코드로 바로 해석하지 않고 바이트코드로 해석한 이후 컴파일하는 단계를 두었을까? 🧐

![java](/assets/img/post/computer-architecture/java.png){: width="500" height="200 }

#### Java가 하이브리드 접근 방식을 쓰는 이유

- **"한 번 작성하면 어디서나 실행"**: **Java는 "한 번 작성하면 어디서나 실행"(WORA - Write once, run anywhere) 원칙으로 설계**되었다. Java 소스 코드를 바이트코드(플랫폼 독립적인 중간 형식)로 컴파일하면 JVM(Java Virtual Machine)이 있는 모든 플랫폼에서 동일한 바이트코드가 실행될 수 있다. 이 JVM은 바이트코드를 호스트 플랫폼에 특정한 기계어 코드로 해석하는 역할을 담당한다.
- **교차 플랫폼 호환성**: **JVM은 바이트코드와 기본 하드웨어 및 운영 체제 사이의 추상화 계층 역할**을 한다.
- **이식성**: 바이트코드는 수정 없이 **다양한 플랫폼(Windows, Linux, macOS 등)에서 쉽게 전송하고 실행**할 수 있다.

Java가 소스 코드와 기계 코드 사이의 중간 단계로 **바이트코드를 사용하는 것은 성능과 이식성, 보안 및 유지 관리 가능성의 균형을 맞추는 전략적 선택**이라고 볼 수 있다. 이 접근 방식을 통해 Java 프로그램은 JVM이 장착된 모든 장치에서 실행될 수 있으므로 **Java는 크로스 플랫폼 애플리케이션을 위한 언어**라고 한다.