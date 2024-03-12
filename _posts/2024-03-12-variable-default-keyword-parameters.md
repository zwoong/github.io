---
layout: post
title: 매개변수
tags: [Research, Python, 매개변수]
categories: [Research, Python, 매개변수]
image:
  path: /assets/img/post/research/python-parameter.jpeg
  alt: python-parameter
date: 2024-03-12 22:18 +0900
---

## 매개변수

파이썬에서 함수는 다양한 형태의 매개변수를 가질 수 있으며, 그 종류로는 가변 매개변수, 기본 매개변수, 키워드 매개변수가 있다.

### 기본 매개변수 (Default Parameters)

함수를 호출할 때 **값이 제공되지 않는 경우 사용되는 매개변수**이다. 이 매개변수에는 기본값이 할당되며, 함수 호출 시 해당 매개변수에 대해 아무 값도 전달되지 않으면 이 기본값이 사용된다.

```py
def greet(name, message="Hello"):
    return f"{message}, {name}!"

# 기본 매개변수 사용
print(greet("Alice")) # "Hello, Alice!"

# 기본 매개변수를 오버라이드
print(greet("Alice", "Goodbye")) # "Goodbye, Alice!"
```

### 가변 매개변수 (\*args and \*\*kwargs)

가변 매개변수를 사용하면 함수에 **임의의 수의 매개변수를 전달할 수 있다**. \*args는 임의 개수의 매개변수를 튜플로 받고, \*\*kwargs는 임의 개수의 키워드 매개변수를 dict로 받는다.

```py
def make_greeting(*args, **kwargs):
    greeting = " and ".join(args) + "! "
    if kwargs:
        greeting += "Your special message is: "
        greeting += ", ".join(f"{key}={value}" for key, value in kwargs.items())
    return greeting

print(make_greeting("Alice", "Bob", greeting="Hello", time="Morning"))
# "Alice and Bob! Your special message is: greeting=Hello, time=Morning"
```

### 키워드 매개변수 (Keyword Arguments)

키워드 매개변수는 함수를 호출할 때 **매개변수의 이름을 명시적으로 지정하여 값을 전달하는 방식**이다. 이를 통해 함수 호출 시 매개변수의 순서를 고려하지 않아도 되며, 코드의 가독성을 높일 수 있다.

```py
def register_user(name, age, country="Unknown"):
    return f"Name: {name}, Age: {age}, Country: {country}"

# 키워드 매개변수 사용
print(register_user(name="Alice", age=30, country="Wonderland"))
# "Name: Alice, Age: 30, Country: Wonderland"

# 일부 매개변수만 키워드로 전달
print(register_user("Bob", age=25))
# "Name: Bob, Age: 25, Country: Unknown"
```
