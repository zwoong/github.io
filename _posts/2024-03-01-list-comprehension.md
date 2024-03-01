---
layout: post
title: List Comprehension
tags: [Research, Python, List Comprehension]
categories: [Research, Python, List Comprehension]
image:
  path: /assets/img/post/research/list-comprehension.png
  alt: list-comprehension
date: 2024-03-01 10:20 +0900
---

## List Comprehension(리스트 컴프리핸션)

파이썬의 리스트 컴프리헨션(list comprehension)은 **리스트(list), 세트(set), 사전(dictionary) 등의 컬렉션 또는 이터러블(iterable) 객체를 생성할 때 코드를 간결하게 작성하는 방법**이다. 이 구문은 반복문과 조건문을 결합하여, 보다 읽기 쉽고 표현력 있는 코드를 작성할 수 있게 도와준다. 리스트 컴프리헨션은 주로 데이터를 변환하거나 필터링할 때 유용하게 사용된다. 😉

### 기본 구조

```python
[표현식 for 항목 in 이터러블 if 조건문]
```

- **표현식**: 리스트의 새로운 요소를 정의한다. 이 표현식은 for 문의 각 항목에 대해 계산된다.
- **for 항목 in 이터러블**: 반복 가능한 객체(리스트, 튜플, 딕셔너리 등)에서 요소를 하나씩 가져와 '항목' 변수에 할당한다.
- **if 조건문(optional)**: 이 조건이 참(True)인 경우에만 항목이 결과 리스트에 포함된다.

### 예제

- **기본 예제**: 0부터 9까지의 숫자 중에서, 각 숫자의 제곱을 원소로 하는 리스트 생성

```python
squares = [x**2 for x in range(10)]
```

- **조건문 포함**: 0부터 9까지의 숫자 중에서 짝수인 숫자의 제곱을 원소로 하는 리스트 생성

```python
even_squares = [x**2 for x in range(10) if x % 2 == 0]
```

- **중첩 루프 사용**: 두 개의 리스트에서 모든 가능한 조합 생성

```python
# 기존
pairs = []
for x in [1, 2, 3]:
    for y in [3, 1, 4]:
        if x != y:
            pairs.append((x, y))

# 컴프리핸션 적용
pairs = [(x, y) for x in [1, 2, 3] for y in [3, 1, 4] if x != y]
```

> 리스트 컴프리헨션과 유사하게, **세트(set)와 딕셔너리(dictionary)도 컴프리헨션 문법을 사용**할 수 있다.

```python
sets = {x**2 for x in range(10)}
dictionary = {x: x**2 for x in range(10)}

# sets : {0, 1, 64, 4, 36, 9, 16, 49, 81, 25}
# dictionary : {0: 0, 1: 1, 2: 4, 3: 9, 4: 16, 5: 25, 6: 36, 7: 49, 8: 64, 9: 81}
```

dictionary에 경우 안에 요소가 순차적으로 들어가 있는데 sets는 그렇지 않네? 🧐

- **Set의 특성**
  - **순서 보장 없음**: Python의 **set은 순서를 보장하지 않는다**. set은 수학적 집합 개념을 구현한 것으로, 집합 내의 요소들 사이에는 순서가 없다. 따라서, set에 요소를 추가할 때, 그 요소들이 저장되는 순서는 정의되어 있지 않으며, 실행할 때마다 요소의 순서가 달라질 수 있다.
  - **중복 요소 없음**: set은 **중복된 요소를 허용하지 않는다**. 같은 값을 두 번 이상 추가하려고 해도 set에는 단 한 번만 저장된다.

Python의 set 구조는 순서를 보장하지 않는다고 흔히 말하지만, 이는 요소들이 무작위 순서로 저장되거나 반환된다는 것을 의미하지는 않는다. 대신, set 내의 요소 정렬은 **해당 요소들의 해시(hash) 값에 기반하여 결정된다**. 이 해시 기반 저장 메커니즘은 set의 빠른 조회와 삽입, 삭제 연산을 가능하게 한다. 이 **내부적인 해시 메커니즘은 Python의 구현 세부 사항**에 속하며, 일반적으로 사용자가 직접 제어하거나 예측할 수 있는 것은 힘들다.

### 주의사항 ❗️

리스트 컴프리헨션은 **코드의 간결성과 가독성을 높일 수 있지만**, 너무 복잡하거나 긴 표현식에 사용될 경우 오히려 가독성을 해칠 수 있다. 따라서, **복잡한 로직은 전통적인 for문을 사용하여 구현하는 것이 더 나을 수 있다**.
