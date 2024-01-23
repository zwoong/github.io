---
layout: post
title: 검색 알고리즘 - 이진 검색
tags: [알고리즘, 검색 알고리즘, 이진 검색]
categories: [알고리즘, 검색 알고리즘, 이진 검색]
image:
  path: /assets/img/post/algorithm/binary-search.png
  alt: binary-search
date: 2024-01-23 15:43 +0900
---

## 이진 검색

이진 검색은 정렬된 항목 목록에서 특정 항목을 찾는 효율적인 알고리즘이다. 가능한 위치를 하나로 좁힐 때까지 **특정 항목을 포함할 수 있는 목록 부분을 반복적으로 절반으로 나누는 방식**으로 작동한다.

### 이진 검색 작동 방식

- **초기 설정**: '낮음', '높음', '중간'이라는 세 가지 지수로 시작하며, 처음에는 low가 목록의 첫 번째 인덱스(0)로 설정되고, high가 목록의 마지막 인덱스(목록 길이 - 1)로 설정된다.
- **중간 계산**: 각 단계에서 낮음과 높음(mid = (low + high) // 2)의 평균을 취하여 중간 지수 mid를 계산한다.
- **중간 요소 확인**
  - mid에 있는 요소가 타겟이라면 해당 항목을 찾은 것이므로 검색 완료
  - mid에 있는 요소가 대상보다 큰 경우 대상은 목록의 왼쪽 절반(low에서 mid - 1까지)안에 속해 있음을 의미
  - mid에 있는 요소가 대상보다 작으면 대상이 목록의 오른쪽 절반(mid + 1에서 high까지)안에 속해 있음을 의미
- **검색 범위 조정**
  - mid의 요소가 목표보다 큰 경우 high = mid - 1을 설정
  - mid의 요소가 목표보다 작다면 low = mid + 1을 설정
- **프로세스 반복**: '낮음' 지수가 '높음' 지수보다 클 때까지, **대상이 목록에 존재하지 않거나 대상을 찾을 때까지 단계를 반복**

### 복잡도

- **시간 복잡도**
  - **최선의 경우**: O(1) - 대상 요소가 목록의 중간에 있을 때 발생한다.
  - **최악 및 평균 사례**: O(log n) - 알고리즘은 각 단계마다 검색 공간을 절반으로 나눈다. 이로 인해 O(log n)의 시간 복잡도가 발생하며, 여기서 n은 목록의 요소 수이다.
- **공간 복잡도**
  - **반복적 접근 방식**: O(1) - 이진 검색이 반복적으로(루프를 사용하여) 구현되는 경우 고정된 수의 변수를 사용하기 때문에 일정한 공간 복잡도를 갖는다.
  - **재귀적 접근 방식**: O(log n) - 재귀적으로 구현하는 경우 재귀 호출에 사용되는 스택 공간으로 인해 공간 복잡도는 O(log n)이 될 수 있다.

### 장단점

- **장점**
  - **대형 데이터 세트에 대한 효율성이 매우 높음**: O(log n) 시간 복잡성 때문에 이진 검색은 대규모 데이터 세트를 검색하는 데 매우 효율적이며 **선형 검색(O(n))보다 훨씬 뛰어난 성능**을 발휘한다.
  - **최소 비교 횟수**: 이진 검색은 비교 횟수를 최소화한다.
  - **다양한 데이터 구조에서 쉽게 구현됨**: 배열, 이진 검색 트리 및 B-트리와 같은 다른 데이터 구조에도 적용할 수 있다.
- **단점**
  - **정렬된 데이터 필요**: **이진 검색은 정렬된 데이터에서만 작동**한다. 데이터 세트가 아직 정렬되지 않은 경우 데이터 정렬 비용을 고려해야 한다.

### 예시 코드

- **반복적 접근 방식**

```python
def binary_search_iterative(arr, target):
  low = 0
  high = len(arr) - 1

  while low <= high:
    mid = (low + high) // 2
    guess = arr[mid]

    if guess == target:
      return mid  # Target found
    if guess > target:
      high = mid - 1  # Target is in the left half
    else:
      low = mid + 1  # Target is in the right half

  return -1  # Target not found

arr = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
target = 13
result = binary_search_iterative(arr, target)
print("Element found at index:" if result != -1 else "Element not found.", result)
```

- **재귀적 접근 방식**

```python
def binary_search_recursive(arr, target, low, high):
    if high >= low:
        mid = (low + high) // 2
        guess = arr[mid]

        if guess == target:
            return mid  # Target found
        elif guess > target:
            return binary_search_recursive(arr, target, low, mid - 1)  # Target is in the left half
        else:
            return binary_search_recursive(arr, target, mid + 1, high)  # Target is in the right half
    else:
        return -1  # Target not found

arr = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
target = 13
result = binary_search_recursive(arr, target, 0, len(arr) - 1)
print("Element found at index:" if result != -1 else "Element not found.", result)
```
