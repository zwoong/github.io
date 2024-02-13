---
layout: post
title: List, Map, Set의 차이점
tags: [Research, List, Map, Set의 차이점]
categories: [Research, List, Map, Set의 차이점]
image:
  path: /assets/img/post/research/list-map-set.png
  alt: list-map-set
date: 2024-02-13 23:08 +0900
---

## List(목록)

- 리스트는 순서가 있는 요소들의 모임이다. **각 요소는 위치(인덱스)를 가지며, 이를 통해 접근**할 수 있다.
- 리스트는 **동적 배열(dynamic array)로 구현**된다.
- 리스트는 **대개 배열(array)로 구현되며, 각 요소는 메모리상에 연속적으로 저장**된다.
- 리스트의 장점은 요소의 순서가 보존되며, **인덱스를 통해 빠르게 접근**할 수 있다는 것이다. 하지만 삽입 및 삭제 연산은 리스트의 길이에 따라 성능이 달라질 수 있다.

```python
# 리스트 생성
my_list = [1, 2, 3, 4, 5]

# 리스트 출력
print("List:", my_list)

# 리스트의 요소에 접근
print("First element:", my_list[0])
print("Last element:", my_list[-1])

# 리스트에 요소 추가
my_list.append(6)
print("After appending 6:", my_list)

# 리스트에서 요소 제거
my_list.remove(3)
print("After removing 3:", my_list)

# 리스트 길이 확인
print("Length of list:", len(my_list))
```

### List 사용예시

- 리스트는 **순서가 있는 데이터를 다룰 때 사용**된다.
- 요소의 순서가 중요한 경우에 주로 사용된다. 예를 들어, 데이터의 입력 순서가 중요하거나 데이터를 스택(stack) 또는 큐(queue)와 같은 자료 구조로 사용할 때 유용하다.
- 예를 들어, **To-Do 리스트, 사용자가 입력한 목록, 데이터 항목의 정렬된 시퀀스 등을 저장할 때** 리스트를 사용할 수 있다.

## Map(맵)

- 맵은 **키(key)와 값(value)의 쌍으로 이루어진 자료 구조**이다. 각 키는 고유해야 하며, 값은 중복될 수 있다.
- 키-값 쌍의 집합으로 구성되며, 각 키는 하나의 값과 연관된다. 이를 통해 **키를 사용하여 값을 검색하거나 갱신**할 수 있다.
- 맵의 장점은 키를 사용하여 빠르게 값을 검색할 수 있다는 것이다.

```python
# 사전 생성
my_dict = {"apple": 3, "banana": 5, "orange": 2}

# 사전 출력
print("Dictionary:", my_dict)

# 사전의 값에 접근
print("Value for 'apple':", my_dict["apple"])

# 새로운 키-값 쌍 추가
my_dict["grape"] = 4
print("After adding 'grape':", my_dict)

# 키로 값을 제거
del my_dict["banana"]
print("After removing 'banana':", my_dict)

# 사전의 길이 확인
print("Length of dictionary:", len(my_dict))
```

### Map 사용예시

- 맵은 **키(key)와 값(value)의 쌍으로 이루어진 데이터를 다룰 때 사용**된다.
- 데이터의 **검색 속도가 중요한 경우에 많이 사용**된다. 해시 맵은 일반적으로 평균적으로 O(1)의 시간 복잡도로 데이터를 검색할 수 있다.
- 예를 들어, 학생의 이름과 점수, 사용자의 프로필 정보, 단어의 빈도수 등을 저장할 때 맵을 사용할 수 있다.

## Set(집합)

- 집합은 **중복되지 않는 요소들의 모임**이다. 각 요소는 유일해야 한다.
- 집합은 **합집합, 교집합, 차집합 등의 집합 연산을 지원**한다.
- 집합의 장점은 중복을 허용하지 않으며, 집합 연산을 효율적으로 수행할 수 있다는 것이다. 하지만 순서가 보존되지 않는다(파이썬 3.7 버전부터는 집합(set)이 요소들의 순서를 보존).

```python
# 집합 생성
my_set = {1, 2, 3, 4, 5}

# 집합 출력
print("Set:", my_set)

# 집합에 요소 추가
my_set.add(6)
print("After adding 6:", my_set)

# 집합에서 요소 제거
my_set.remove(3)
print("After removing 3:", my_set)

# 집합의 길이 확인
print("Length of set:", len(my_set))
```

### Set 사용예시

- **중복된 데이터를 제거하거나 데이터의 유일성을 확인할 때 유용**하다.
- 집합 연산(합집합, 교집합, 차집합 등)을 수행해야 하는 경우에 사용된다.
- 예를 들어, 고유한 값을 추출하거나 중복된 데이터를 제거하고자 할 때 집합을 사용하거나, 데이터의 유일성을 확인하거나 데이터 간의 관계를 파악하기 위해 사용될 수 있다.

```python
# 사용자가 입력한 값을 검사하여 중복된 값을 제거하고 유일한 값만 저장하는 예시
unique_usernames = set()
while True:
    username = input("Enter username (or 'quit' to exit): ")
    if username == 'quit':
        break
    else:
        if username not in unique_usernames:
            unique_usernames.add(username)
        else:
            print("Username already exists. Please enter a unique username.")
```
