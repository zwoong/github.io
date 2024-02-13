---
layout: post
title: Spring vs Spring Boot
tags: [Java, Spring vs Spring Boot]
categories: [Java, Spring vs Spring Boot]
image:
  path: /assets/img/post/java/spring-vs-spring-boot.jpeg
  alt: spring-vs-spring-boot
date: 2024-02-14 00:00 +0900
---

## Spring

- Spring은 **경량의 웹 애플리케이션을 개발하기 위한 포괄적인 프레임워크**이다.
- Spring은 다양한 기능을 제공하는 모듈로 구성되어 있으며, 각 모듈은 특정한 기능을 담당한다. 예를 들어, **Spring MVC 모듈은 웹 애플리케이션의 웹 계층을 처리하는 데 사용**된다.
- Spring 프레임워크를 사용하면 **개발자가 애플리케이션의 모든 구성 요소를 직접 설정**해야 한다. 이것은 **유연성과 커스터마이징 가능성을 제공하지만, 초기 설정과 구성이 복잡**할 수 있다.

### Spring 디렉토리 구조

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── myapplication/
│   │               ├── config/
│   │               │   ├── AppConfig.java
│   │               │   └── WebConfig.java
│   │               ├── controller/
│   │               │   └── MyController.java
│   │               ├── model/
│   │               │   └── MyModel.java
│   │               ├── repository/
│   │               │   └── MyRepository.java
│   │               └── service/
│   │                   └── MyService.java
│   └── resources/
│       ├── static/
│       │   └── css/
│       │       └── style.css
│       ├── templates/
│       │   └── index.html
│       ├── application.properties
│       └── logback.xml
└── test/
    ├── java/
    │   └── com/
    │       └── example/
    │           └── myapplication/
    │               └── controller/
    │                   └── MyControllerTest.java
    └── resources/
        └── application-test.properties
```

- **src/main/java/**
  - Java 소스 코드 파일을 포함하는 디렉토리이다.
  - 프로젝트의 **Java 클래스와 패키지들은 여기에 위치**한다.
  - 주로 **애플리케이션의 비즈니스 로직, 컨트롤러, 서비스, 모델 등의 구성 요소가 위치**한다.
- **src/main/resources/**
  - 애플리케이션의 리소스 파일을 포함하는 디렉토리이다.
  - 주로 설정 파일, 정적 자원(css, js, 이미지 등), 템플릿 파일(html) 등이 위치한다.
  - **Spring Boot에서는 application.properties와 같은 애플리케이션 설정 파일**도 여기에 위치한다.
- **src/test/**
  - **테스트 소스 코드 및 리소스 파일을 포함하는 디렉토리**이다.
  - 주로 JUnit 테스트 코드와 테스트 리소스 파일이 위치한다.
- **config/**
  - Spring의 설정 파일들을 포함하는 디렉토리이다.
  - AppConfig.java, WebConfig.java와 같은 Spring 설정 클래스들이 위치한다.
- **controller/**
  - Spring **MVC 컨트롤러 클래스를 포함하는 디렉토리**이다.
  - HTTP 요청을 처리하고 적절한 응답을 반환하는 컨트롤러 클래스들이 위치한다.
- **model/**
  - 애플리케이션의 **데이터 모델 클래스들을 포함하는 디렉토리**이다.
  - 데이터베이스와 상호 작용하는 엔터티 클래스들이 여기에 위치한다.
- **repository/**
  - 데이터베이스와의 상호 작용을 위한 리포지토리 인터페이스들을 포함하는 디렉토리이다.
  - 주로 Spring Data JPA를 사용하여 데이터베이스와 상호 작용하는 데 사용된다.
- **service/**
  - **비즈니스 로직을 포함하는 서비스 클래스들을 포함하는 디렉토리**이다.
  - 컨트롤러와 리포지토리 간의 중간 계층으로 사용된다.

## Spring Boot

- Spring Boot는 **Spring 기반의 애플리케이션을 보다 쉽게 개발하고 실행할 수 있도록 도와주는 프레임워크**이다.
- Spring Boot는 애플리케이션의 **초기 설정을 자동화하고, 개발자가 최소한의 구성**으로 신속하게 애플리케이션을 구축할 수 있도록 지원한다.
- Spring Boot는 **내장된 톰캣(Tomcat)과 같은 서버를 제공**하여, 애플리케이션을 더 쉽게 실행하고 배포할 수 있도록 한다.
- Spring Boot는 자동 구성(autowiring)과 스프링 부트 스타터(starter) 라이브러리를 통해 **의존성 관리를 자동화**하여 개발자가 애플리케이션의 의존성을 쉽게 관리할 수 있다.

## Spring, Spring Boot 차이점 정리

- **설정의 간소화**
  - Spring은 **초기 설정과 구성이 복잡**할 수 있다. 프로젝트의 구성과 의존성 관리는 개발자에게 많은 시간을 들이게 한다.
  - Spring Boot는 애플리케이션의 **초기 설정을 자동화하고, 개발자가 최소한의 구성으로 신속하게 애플리케이션을 구축**할 수 있도록 지원한다. 이는 starter 라이브러리와 자동 구성(auto-configuration)을 통해 가능하다.
- **내장된 서버**
  - Spring 프레임워크는 일반적으로 **외부 서버(Tomcat, Jetty 등)를 사용하여 애플리케이션을 실행**한다.
  - Spring Boot는 **내장된 서버(Tomcat, Jetty, Undertow 등)를 제공**하여 애플리케이션을 더 쉽게 실행하고 배포할 수 있도록 한다. 따라서 별도의 외부 서버 설정이 필요하지 않는다.
- **의존성 관리**
  - Spring 프레임워크에서는 **Maven 또는 Gradle과 같은 빌드 도구를 사용하여 의존성을 관리**한다. 개발자가 직접 필요한 라이브러리를 추가해야 한다.
  - Spring Boot는 **starter 라이브러리를 통해 의존성 관리를 자동화**한다. 예를 들어, spring-boot-starter-web는 웹 애플리케이션을 개발할 때 필요한 모든 라이브러리를 자동으로 포함한다.
- **기본 설정**
  - Spring은 기본적으로 **XML 또는 Java 구성을 사용하여 애플리케이션을 설정**한다.
  - Spring Boot는 기본적으로 자바 구성을 사용한다. 또한 **application.properties 또는 application.yml 파일을 사용하여 애플리케이션의 속성을 설정**할 수 있다.
- **주요 목적**
  - Spring은 일반적으로 개발자가 애플리케이션의 모든 구성 요소를 직접 설정하고 구성해야 하는 대규모 프로젝트에 적합하다.
  - Spring Boot는 애플리케이션의 초기 설정을 자동화하고 빠르게 개발할 수 있는 작은 및 중간 규모의 프로젝트에 더 적합하다.
