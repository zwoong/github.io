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

- **최대 힙 구축**
  - **마지막 비리프 노드에서 시작**: 마지막 비리프 노드(마지막 요소의 부모)에서 시작하여 루트 노드까지 이동한다.
  - **각 노드 힙화**: 각 노드에 대해 힙파이 프로세스는 노드의 값이 하위 노드보다 큰지 확인한다. 그렇지 않은 경우 값이 교환되고 영향을 받은 하위 트리에 대해 heapify가 재귀적으로 호출된다.
- **힙 정렬**
  - **루트를 마지막 요소로 바꾸기**: 힙의 루트(가장 큰 값)가 배열의 끝에 있는 경우 올바른 위치에 있다. 따라서 루트는 힙의 마지막 요소(아직 배열의 정렬되지 않은 부분)로 교체된다.
  - **힙 크기 줄이기**: 교체 후 힙 크기가 1씩 줄어들고 마지막 요소(현재 정렬됨)는 더 이상 힙의 일부가 아니다.
  - **루트 힙화**: 스왑이 힙 속성을 위반했을 수 있으므로 이제 줄어든 힙의 루트에 대해 heapify가 호출됩니다. 이렇게 하면 가장 큰 값이 다시 루트에 있게 된다.
  - **과정 반복**: 모든 요소가 정렬될 때까지 이 과정을 반복한다.

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
