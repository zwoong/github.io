---
layout: post
title: 정렬 알고리즘 - 퀵 정렬
tags: [알고리즘, 정렬 알고리즘, 퀵 정렬]
categories: [알고리즘, 정렬 알고리즘, 퀵 정렬]
image:
  path: /assets/img/post/algorithm/quick-sort.png
  alt: quick-sort
date: 2024-01-19 09:35 +0900
---

## 퀵 정렬

퀵 정렬은 **매우 효율적인 정렬 알고리즘이며 분할 방식을 기반으로 동작**한다. 목록이나 배열을 정렬하는 기능이 있으며 많은 표준 프로그래밍 라이브러리에서 널리 사용되는 가장 널리 사용되는 알고리즘 중 하나이다.

퀵 정렬의 기본 원리는 배열에서 **'피벗' 요소를 선택하고 다른 요소가 피벗보다 작거나 큰지에 따라 두 개의 하위 배열로 분할하는 것**이다.

### 퀵 정렬 작동 방식

- **피벗 선택**: 배열에서 '피벗' 요소를 선택한다. 피벗 선택은 다양할 수 있으며, 첫 번째 요소, 마지막 요소, 중앙값 또는 임의 요소가 될 수 있다. 알고리즘의 효율성은 피벗 선택 방법에 따라 크게 달라진다.
- **분할**: **피벗보다 작은 값을 가진 모든 요소가 피벗 앞에 오고, 피벗보다 큰 값을 가진 모든 요소가 피벗 뒤에 오도록 배열을 정렬**한다. 이를 파티션 작업이라고 한다.
- **재귀적으로 적용**: 위 단계를 더 작은 값을 가진 요소의 하위 배열에 반복적으로 적용하고 더 큰 값을 가진 요소의 하위 배열에 별도로 적용한다.

### 복잡도

- **시간 복잡도**
  - **최선의 경우**: O(n log n)
  - **평균 사례**: O(n log n)
  - **최악의 경우**: O(n^2) (각 단계에서 가장 작거나 가장 큰 요소가 피벗으로 선택되는 경우 발생)
- **공간 복잡도**: 재귀에 사용되는 스택 공간으로 인해 O(log n)발생

### 장단점

- **장점**
  - **내부 정렬**: 추가 저장 공간이 필요하지 않다.
  - **대규모 데이터 세트에 효율적**: 일반적으로 **병합 정렬 또는 힙 정렬과 같은 다른 O(n log n) 알고리즘보다 빠르다**.
- **단점**
  - **최악의 성능**: 최악의 성능은 O(n^2)이며, **가장 작거나 가장 큰 요소가 항상 피벗으로 선택되는 경우 발생**할 수 있다.

### 예시 코드

```python
def quick_sort(arr, low, high):
  if low < high:
    pi = partition(arr, low, high)
    quick_sort(arr, low, pi - 1)
    quick_sort(arr, pi + 1, high)

def partition(arr, low, high):
  mid = low + (high - low) // 2
  pivot = sorted([arr[low], arr[mid], arr[high]])[1]
  pivot_index = arr.index(pivot)

  # Move the pivot to the end for the partitioning process
  arr[pivot_index], arr[high] = arr[high], arr[pivot_index]

  i = low
  for j in range(low, high):
    if arr[j] <= pivot:
      arr[i], arr[j] = arr[j], arr[i]  # Swap elements
      i += 1

  arr[i], arr[high] = arr[high], arr[i]  # Swap pivot to the right position
  return i

example_array = [10, 7, 8, 9, 1, 5]
quick_sort(example_array, 0, len(example_array) - 1)
print(example_array) # Output : [1, 5, 7, 8, 9, 10]
```
