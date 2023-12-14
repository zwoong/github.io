---
layout: post
title: 운영체제란 무엇인가
tags: [운영체제, 운영체제란 무엇인가]
categories: [운영체제, 운영체제란 무엇인가]
image:
  path: /assets/img/post/operating-system/os.jpg
  alt: os
date: 2023-12-14 13:44 +0900
---

운영체제(Operating System, OS)는 **컴퓨터 시스템의 가장 기본적인 소프트웨어**로, **하드웨어와 사용자 사이에서 중재자 역할**을 한다. 이는 컴퓨터의 모든 기본적인 작업을 관리하고, 컴퓨터 하드웨어를 쉽고 효율적으로 사용할 수 있도록 돕는다.

## 운영체제 주요 기능

- **자원 관리**: CPU, 메모리, 디스크 공간 등의 컴퓨터 자원 관리
- **프로세스 관리**: 프로그램의 실행을 관리
- **메모리 관리**: 메모리 할당 및 관리
- **파일 시스템 관리**: 파일 저장 및 접근 관리
- **보안**: 시스템 보호 및 접근 제어
- **사용자 인터페이스 제공**: 명령줄 인터페이스(CLI) 또는 그래픽 사용자 인터페이스(GUI)를 제공

## 운영체제의 종류

- **일괄 처리 운영체제(Batch Operating Systems)**
  - 예시: IBM의 초기 메인프레임 시스템 운영체제, 예를 들어 IBM OS/360.
  - 특징: 사용자의 **작업을 일괄적으로 모아서 순차적으로 처리**한다. 사용자와의 직접적인 상호작용이 없는 환경에서 효율적이다.

![batch-operating-systems](/assets/img/post/operating-system/batch-operating-systems.png){: width="500" }

- **시분할 운영체제(Time-Sharing Operating Systems)**
  - 예시: Unix, [Multics](https://ko.wikipedia.org/wiki/%EB%A9%80%ED%8B%B1%EC%8A%A4).
  - 특징: 시**스템이 매우 짧은 시간 간격으로 여러 사용자의 작업을 빠르게 전환하며 처리하는 방식**을 의미한다. 이러한 처리 방식 때문에 사용자는 마치 여러 작업이 동시에 이루어지는 것처럼 느낀다.

![time-sharing-operating-systems](/assets/img/post/operating-system/time-sharing-operating-systems.png){: width="500" }

- **멀티프로세싱 운영체제(Multiprocessing Operating Systems)**
  - 예시: Windows, Linux.
  - 특징: **여러 프로그램이 동시에 실행되는 환경을 지원**한다. 멀티프로세싱은 여러 CPU를 사용하여 성능을 향상시키는 데 초점을 맞춘다.

![multiprocessing-operating-systems](/assets/img/post/operating-system/multiprocessing-operating-systems.jpg){: width="450" }

- **분산 운영체제(Distributed Operating Systems)**
  - 예시: Google's Android, Apache Hadoop.
  - 특징: **여러 독립적인 컴퓨터가 네트워크를 통해 연결되어 하나의 일관된 시스템처럼 작동**한다. 이러한 시스템은 처리 능력과 신뢰성을 높이기 위해 분산된 자원을 활용한다.

![distributed-operating-systems](/assets/img/post/operating-system/distributed-operating-systems.png){: width="600" }

- **실시간 운영체제(Real-Time Operating Systems)**

  - 예시: [VxWorks](https://ko.wikipedia.org/wiki/VxWorks), FreeRTOS.
  - 특징: **엄격한 시간 제약 조건을 만족시키는 것이 중요**한 응용 분야(예: 임베디드 시스템, 산업 제어 시스템)에서 사용된다. 실시간 처리와 빠른 반응 시간이 요구된다.
  - **종류**
    - **Hard Real Time Operating System**: **가장 엄격한 시간 제약**을 가진 작업에 사용된다. 처리 시간이 매우 중요하며, 시간 제약을 지키지 못하면 심각한 결과를 초래할 수 있다. 예를 들어, 항공기 제어 시스템이나 의료 장비 같은 곳에서 사용된다.
    - **Soft Real Time Operating System**: 하드 실시간 시스템보다 덜 엄격한 시간 제약을 가지고 있다. 시간 제약을 일부 놓치더라도 시스템의 전체 성능에 치명적인 영향을 주지는 않는다. 비디오 스트리밍이나 오디오 처리 같은 작업에서 사용된다.
    - **Firm Real Time Operating System**: **하드와 소프트 실시간 시스템의 중간 형태**이다. 작업이 기한 내에 완료되어야 최적의 성능을 발휘하지만, 일정 시간을 초과하더라도 시스템이 실패하는 것은 아니다. 그러나 반복적인 기한 초과는 시스템 성능에 영향을 줄 수 있다. 예를 들어, 자동화된 공정 제어 시스템에서 볼 수 있다.

![real-time-operating-systems](/assets/img/post/operating-system/real-time-operating-systems.png){: width="600" }

- **네트워크 운영체제(Network Operating Systems)**
  - 예시: Novell NetWare, Windows Server.
  - 특징: 네트워크 환경에서 자원을 공유하고 통신을 관리한다. 파일 서버, 프린터 서버 등의 네트워크 자원 관리에 적합하다.

![network-operating-system](/assets/img/post/operating-system/network-operating-system.png){: width="600" }

- **모바일 운영체제(Mobile Operating Systems)**
  - 예시: Android, iOS.
  - 특징: 스마트폰, 태블릿과 같은 **모바일 기기에 최적화**되어 있으며, 터치스크린 인터페이스, 에너지 효율성, 모바일 애플리케이션 지원에 중점을 둔다.

## 대표적인 운영체제

- **Windows**: 가장 널리 사용되는 개인용 컴퓨터 운영체제
- **macOS**: Apple의 Mac 컴퓨터를 위한 운영체제
- **Linux**: 오픈 소스 기반의 운영체제, **서버와 클라우드 환경에서 많이 사용됨**
- **Unix**: 대학 및 연구 기관에서 널리 사용되었으며, **많은 현대 운영체제의 기반**이 됨
- **iOS/Android**: 모바일 기기를 위한 운영체제
