---
layout: post
title: 정렬 알고리즘 - 병합 정렬
tags: [알고리즘, 정렬 알고리즘, 병합 정렬]
categories: [알고리즘, 정렬 알고리즘, 병합 정렬]
image:
  path: /assets/img/post/algorithm/merge-sort.png
  alt: merge-sort
date: 2024-01-19 14:18 +0900
---

## 병합 정렬

병합 정렬(Merge Sort)은 배열이나 요소 목록을 정렬하는 분할 정복 알고리즘이다. **최악의 경우, 평균적인 경우, 최상의 경우에서 O(n log n)의 시간 복잡도를 갖는 일관된 성능**으로 알려졌으며, 알고리즘이 매우 효율적이며 예측 가능하다.

### 병합 정렬 작동 방식

- **나누기**: 배열은 **각 하위 배열에 단일 요소만 존재하거나 요소가 없을 때까지(단일 요소가 있는 배열은 정렬된 것으로 간주함) 두 부분(하위 배열)으로 반복적으로 나눈다**.
- **정복(정렬)**: 분할 프로세스가 각 하위 배열에 요소가 1개 또는 0개 있는 수준에 도달하면 정복 단계가 시작된다. 실제 정렬이 이루어지는 단계이다.
- **병합**
  - **정렬된 하위 배열은 다시 병합되어 정렬된 배열을 형성**한다. 이 단계는 매우 중요하며 하위 배열의 요소를 비교하고 정렬된 순서로 결합하는 작업이 포함된다.
  - 이 프로세스는 두 하위 배열의 모든 요소가 정렬된 순서로 모든 요소를 ​​포함하는 임시 배열에 복사될 때까지 반복된다.
  - 임시 배열의 내용은 원래 배열로 다시 복사된다.

### 복잡도

- **시간 복잡도**: **배열이 절반으로 나누어지고(log n) 병합 프로세스에 각 수준에서 선형 시간(n)이 걸리기 때문에 모든 경우(최상, 평균, 최악)에 대해 O(n log n)**이다.
- **공간 복잡도**: 병합에 사용되는 임시 배열 때문에 O(n)이다. 입력 배열의 크기에 비례하여 추가 공간이 필요하다.

### 장단점

- **장점**
  - **일관된 성능**: 모든 경우에 대해 O(n log n) 시간 복잡도를 가진다.
  - **대규모 데이터 세트에 효율적**: 연결된 목록과 대규모 배열을 정렬하는 데 적합하다.
- **단점**
  - **공간 복잡성**: **병합 프로세스 중에 사용되는 임시 어레이를 위한 추가 메모리가 필요**하다.

### 예시 코드

```python
def merge_sort(arr):
  if len(arr) > 1:
    mid = len(arr) // 2
    L = arr[:mid]
    R = arr[mid:]

    merge_sort(L)  # Recursively sort the first half
    merge_sort(R)  # Recursively sort the second half

    merge(arr, L, R)  # Merge the sorted halves

def merge(arr, L, R):
  i = j = k = 0  # Initialize pointers for L, R, and arr

  # Merge the temp arrays back into arr
  while i < len(L) and j < len(R):
    if L[i] < R[j]:
      arr[k] = L[i]
      i += 1
    else:
      arr[k] = R[j]
      j += 1
    k += 1

  # Copy the remaining elements of L, if there are any
  while i < len(L):
    arr[k] = L[i]
    i += 1
    k += 1

  # Copy the remaining elements of R, if there are any
  while j < len(R):
    arr[k] = R[j]
    j += 1
    k += 1

# Function to print the list
def print_list(arr):
  print(" ".join(str(x) for x in arr))

# Test the code
arr = [12, 11, 13, 5, 6, 7]
merge_sort(arr)
print("Sorted array is: ")
print_list(arr) # Output : 5 6 7 11 12 13
```
