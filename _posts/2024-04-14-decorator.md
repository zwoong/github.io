---
layout: post
title: 데코레이터
tags: [Research, Python, 데코레이터]
categories: [Research, Python, 데코레이터]
image:
  path: /assets/img/post/research/decorator.png
  alt: decorator
date: 2024-04-14 16:26 +0900
---

## 데코레이터

Python 데코레이터는 **Python의 함수 또는 메서드 동작을 수정하거나 향상시킬 수 있는 매우 강력한 도구**이다. 
실제 코드를 수정하지 않고 기존 함수나 메서드의 기능을 강화하는 데 자주 사용되며, 본질적으로 **함수를 인수로 취하고 함수를 반환**하는 형태이다.

데코레이터를 이해하기 위해 Python의 2가지 개념을 먼저 알아둬야 한다.

1. 함수를 포함한 **파이썬의 모든 것은 객체**이다. 즉, 함수를 다른 함수에 인수로 전달하고, 반환하고, 변수에 저장할 수 있다.
2. 함수는 다른 함수 내부에서 정의될 수 있으며 함수는 다른 함수를 반환할 수 있다.

한마디로 데코레이터는 **함수를 인수로 받아들이고 원래 함수의 동작을 향상하거나 변경하는 새 함수를 반환하는 함수**라고 보면 된다. (말이 좀 어렵네.. 🥺)
예제를 함께 살펴보자!

### 데코레이터 장점

- **코드 재사용성**
  - 데코레이터를 사용하면 기능을 한 번 작성하고 이를 애플리케이션 전체의 여러 함수나 메서드에 적용할 수 있다. 
  - 동일한 동작이 필요한 각 기능에 대해 동일한 코드를 반복적으로 작성할 필요가 없으므로 **코드 중복이 줄어**든다.
- **가독성 및 유지 관리성 향상**
  - 함수의 핵심 기능을 보조 기능(예: 로깅, 액세스 제어, 캐싱 등)과 분리할 수 있다. 
  - **관심사의 분리는 코드를 더 깔끔하고 목적에 더 집중하게 하여 가독성을 향상**시킨다.

### 기본 예시

데코레이터의 작동 방식을 이해하기 위해 간단한 예를 살펴보자.
이 예에서 my_ decorator는 **func 함수를 인수로 사용**하고 실행 전후에 메시지를 인쇄하여 기능을 향상시키는 내부 함수 wrapper를 정의하는 데코레이터이다.

```py
def my_decorator(func):
    def wrapper():
        print("Something is happening before the function is called.")
        func()
        print("Something is happening after the function is called.")
    return wrapper

def say_hello():
    print("Hello!")

# Applying the decorator
say_hello = my_decorator(say_hello)

say_hello()
```


### 데코레이터에 @ 구문 사용하기

```py
def my_decorator(func):
    def wrapper():
        print("Something is happening before the function is called.")
        func()
        print("Something is happening after the function is called.")
    return wrapper

@my_decorator
def say_hello():
    print("Hello!")

say_hello()
```

이 @my_ decorator는 say_hello = my_decorator(say_hello)와 동등한 구문이다.
훨씬 더 간결한 코드가 되었다.

### 매개변수가 있는 데코레이터

때로는 **데코레이터 자체에 인수를 전달**하고 싶을 수도 있다.

```py
def repeat(num_times):
    def decorator_repeat(func):
        def wrapper(*args, **kwargs):
            for _ in range(num_times):
                result = func(*args, **kwargs)
            return result
        return wrapper
    return decorator_repeat

@repeat(num_times=4)
def greet(name):
    print(f"Hello {name}")

greet("Alice")
```

### 로깅 설정

다음은 함수의 실행 시간과 호출된 인수를 기록하는 기능을 데코레이터를 활용한 예제이다.

```py
import time
import logging

# 로깅 설정을 간단하게 조정
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(message)s')

def log_function_data(func):
    def wrapper(*args, **kwargs):
        start_time = time.time()
        result = func(*args, **kwargs)
        end_time = time.time()
        # 로그 메시지를 좀 더 읽기 쉽게 조정
        logging.info(f"{func.__name__} 실행 시간: {end_time - start_time:.4f}초, args: {args}, kwargs: {kwargs}")
        return result
    return wrapper

@log_function_data
def process_data(x, y, z=0):
    time.sleep(1)  # 실행 지연 시뮬레이션
    return x + y + z

result = process_data(5, 10, z=15)
print(f"Result: {result}")
```

### 재시도 기능

이 예에서는 데코레이터를 사용하여 함수에 정교한 오류 처리 및 재시도 메커니즘을 추가한 예제이다.

- **데코레이터 설정**: retry 데코레이터는 max_attempts, delay_seconds 및 Exceptions의 세 가지 매개변수를 사용한다.
- **함수 래핑**: 데코레이터 내부에는 래퍼 함수가 정의됩니다.
- **예외 처리**: 함수가 지정된 예외를 발생시키는 경우 데코레이터는 이를 포착하고 실패를 기록한 다음 지정된 지연을 기다린 후 다시 시도한다.
- **최종 실행**: 모든 재시도가 실패하면 마지막으로 함수가 호출되어 성공하거나 예외가 발생한다.

```py
import time

def retry(max_attempts, delay_seconds, exceptions):
    def decorator(func):
        def wrapper(*args, **kwargs):
            attempts = 0
            while attempts < max_attempts:
                try:
                    return func(*args, **kwargs)
                except exceptions as e:
                    attempts += 1
                    print(f"Attempt {attempts}/{max_attempts} failed with {str(e)}. Retrying in {delay_seconds} seconds...")
                    time.sleep(delay_seconds)
            return func(*args, **kwargs)
        return wrapper
    return decorator

@retry(max_attempts=3, delay_seconds=2, exceptions=(ValueError,))
def test_function(x):
    if x != 5:
        raise ValueError("Only 5 is accepted")
    return x

# Try the function
try:
    result = test_function(2)
    print(f"Function succeeded with result: {result}")
except ValueError as e:
    print(f"Function ultimately failed after retries: {e}")
```


