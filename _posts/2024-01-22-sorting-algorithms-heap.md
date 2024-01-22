---
layout: post
title: 정렬 알고리즘 - 힙 정렬
tags: [알고리즘, 정렬 알고리즘, 힙 정렬]
categories: [알고리즘, 정렬 알고리즘, 힙 정렬]
image:
  path: /assets/img/post/algorithm/heap-sort.jpg
  alt: heap-sort
date: 2024-01-22 15:43 +0900
---

## 힙 정렬

힙 정렬은 이진 힙 데이터 구조를 사용하여 요소를 정렬하는 비교 기반 정렬 알고리즘이다. **대규모 데이터 세트에서 우수한 성능을 발휘하고 최상의 경우와 최악의 경우 모두 O(n log n) 시간으로 정렬**하는 기능으로 알려져 있다.

### Binary Heap(이진 힙) 이해하기

완전한 이진 트리로 왼쪽에서 오른쪽으로 **마지막 레벨을 제외하고는 완전히 채워져 있는**트리를 의미한다.

- **Binary Max Heap**: 특정 노드 'i'에 대해 'i' 노드의 상위 노드의 값보다 작거나 같다. 가장 큰 요소가 힙의 루트에 있다.
- **Binary Min Heap**: 특정 노드 'i'에 대해 'i' 노드의 상위 노드의 값보다 크거나 같다. 가장 작은 요소가 힙의 루트에 있다.

![max-heap-vs-min-heap](/assets/img/post/algorithm/max-heap-vs-min-heap.png){: width=＂700＂ }

### 힙 정렬 작동 방식 - 최대 힙

- **각 노드 힙화**: **모든 노드 'i'에 대해 'i' 값이 해당 하위 노드보다 크거나 같은지 확인**한다. 'i'가 자식 중 하나보다 작으면 'i'를 자식 중 가장 큰 것과 교환한다.
- **트리 전체에서 힙 속성이 충족될 때까지 반복**

### 복잡도

- **시간 복잡도**: O(n log n)
- **공간 복잡도**: O(1) - 입력 크기와 관계없이 일정한 양의 추가 공간이 필요함

### 예시 코드

```python
def heapify(arr, n, i):
  largest = i
  left = 2 * i + 1
  right = 2 * i + 2

  # Check if left child exists and is greater than root
  if left < n and arr[largest] < arr[left]:
    largest = left

  # Check if right child exists and is greater than the largest so far
  if right < n and arr[largest] < arr[right]:
    largest = right

  # Change root if needed
  if largest != i:
    arr[i], arr[largest] = arr[largest], arr[i]  # Swap
    heapify(arr, n, largest)  # Heapify the root

def build_max_heap(arr):
  n = len(arr)
  # Build a max heap from the input array
  for i in range(n // 2 - 1, -1, -1):
    heapify(arr, n, i)

def heap_sort(arr):
  n = len(arr)
  build_max_heap(arr)

  # Extract elements from the heap one by one
  for i in range(n - 1, 0, -1):
    arr[i], arr[0] = arr[0], arr[i]  # Swap root with the last element
    heapify(arr, i, 0)  # Heapify the reduced heap

# Example usage:
arr = [12, 11, 13, 5, 6, 7]
heap_sort(arr)
print("Sorted array is:", arr)  # Output: [5, 6, 7, 11, 12, 13]
```
