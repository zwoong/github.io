---
layout: post
title: 정렬 알고리즘 - 버블 정렬
tags: [알고리즘, 정렬 알고리즘, 버블 정렬]
categories: [알고리즘, 정렬 알고리즘, 버블 정렬]
image:
  path: /assets/img/post/algorithm/bubble-sort.png
  alt: bubble-sort
date: 2024-01-22 10:30 +0900
---

## 버블 정렬

버블 정렬(Bubble Sort)은 목록을 반복적으로 살펴보고, 인접한 요소를 비교하고, 순서가 잘못된 경우 교체하는 간단한 정렬 알고리즘이다. 목록이 정렬될 때까지 반복되며, **작은 요소가 목록의 맨 위(목록의 시작)로 "버블링"되고 큰 요소가 맨 아래(목록의 끝)로 가라앉는 방식에**서 버블이라는 이름을 가진다.

### 버블 정렬 작동 방식

- **첫 번째 요소부터 비교**: 현재 요소를 다음 요소와 비교한다.
- **필요한 경우 교체**: 현재 요소가 다음 요소보다 크면 위치를 교체한다.
- **정렬될 때까지 반복**: 위치를 오른쪽으로 이동하고 **목록 끝에 도달할 때까지 비교 및 ​​교체 과정을 반복**한다.
- **최적화**: 스왑 없이 완전한 패스가 있으면 프로세스가 중지된다. 이는 목록이 정렬되었음을 의미한다.

### 복잡도

- **시간 복잡도**
  - **최선의 경우**: O(n) - 목록이 이미 정렬되어 있고 최적화된 버전을 사용하는 경우
  - **평균 및 최악의 경우**: O(n²) - 각 요소가 다른 모든 요소와 비교되므로
- **공간 복잡도**: O(1) - 입력 목록 외에 추가 공간이 필요하지 않음

### 장단점

- **장점**
  - **단순성**: 구현이 간단하다.
  - **안정적**: 다른 배열을 위한 추가 공간이 필요하지 않으며 동일한 값 요소에 대해 안정적이다.
- **단점**
  - **큰 목록에서는 비효율적**: 평균 및 최악의 경우 시간 복잡도가 상당히 높아서 **큰 목록에서는 비효율적**이다.
  - **복잡한 문제에는 적합하지 않음**: 단순한 특성때문에 복잡한 문제나 대규모 데이터세트에는 적합하지 않다.

### 예시 코드

```python
def bubble_sort(arr):
  n = len(arr)

  # Traverse through all array elements
  for i in range(n-1):
    # Flag to check if any swap is made
    swapped = False

    # Last i elements are already in place, no need to check them
    for j in range(0, n-i-1):

      # Traverse the array from 0 to n-i-1
      # Swap if the element found is greater than the next element
      if arr[j] > arr[j+1]:
        arr[j], arr[j+1] = arr[j+1], arr[j]
        swapped = True

    # If no two elements were swapped in inner loop, the array is sorted
    if not swapped:
      break

example_array = [10, 7, 8, 9, 1, 5]
bubble_sort(example_array)
print(example_array)  # Output: [1, 5, 7, 8, 9, 10]
```
