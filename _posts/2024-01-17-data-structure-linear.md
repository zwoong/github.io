---
layout: post
title: 데이터 구조 - 선형
tags: [알고리즘, 데이터 구조 - 선형]
categories: [알고리즘, 데이터 구조 - 선형]
image:
  path: /assets/img/post/algorithm/data-structure.png
  alt: data-structure
date: 2024-01-17 10:43 +0900
---

## 데이터 구조

데이터 구조는 **데이터를 구성, 처리, 검색 및 저장하기 위한 특수한 형식**이다. 알고리즘을 배우기전에 데이터 구조를 먼저 학습하는 이유는 **다양한 데이터 구조와 그 속성을 알면 특정 알고리즘에 가장 적합한 데이터 구조를 선택**할 수 있으며, 많은 알고리즘은 특정 데이터 구조를 염두에 두고 설계되었기 때문에 데이터 구조에 대한 지식은 알고리즘을 푸는데 많은 도움이 된다. 대표적인 데이터구조에 대해 함께 알아보자. 😉

### 선형 데이터 구조

선형 데이터 구조는 **요소가 순차적으로 배열**되어 있으며, 메모리에 저장되는 방식으로 인해 한 번의 실행으로 쉽게 탐색할 수 있는 장점이 있다.

- **주요 특징**
  - **순차적 액세스**: 요소는 순서대로 배열되어 하나씩 액세스된다.
  - **단일 레벨**: 첫 번째 요소와 마지막 요소를 제외한 모든 요소에는 고유한 선행 요소와 후속 요소가 있다.
  - **메모리 할당**: **배열과 같은 데이터 구조의 경우 메모리는 연속된 블록에 할당**된다.

#### Arrays(배열)

배열은 **인접한 메모리 위치에 유사한 데이터 유형 모음을 저장하는 데 사용**되는 데이터 구조이다. 이는 일련의 요소를 저장하고 액세스하기 위한 가장 간단하고 효율적인 데이터 구조 중 하나이다.

- **장점**
  - **효율적인 액세스**: **연속적인 메모리 할당**으로 인해 배열을 사용하면 요소에 빠르게 액세스하고 수정할 수 있다.
  - **성능**: 읽기 작업에 대한 빠른 성능을 제공한다.
  - **단순성**: 배열은 사용이 간단하고 데이터 저장 및 조작이 매우 쉽다.
  - **호환성**: 배열은 거의 모든 프로그래밍 언어에서 지원되며 많은 알고리즘의 기본 구성 요소이다.
- **단점**
  - **비용이 많이 드는 삽입/삭제**: 배열에 요소를 삽입하거나 삭제하는 작업은 일반적으로 배열의 순서를 유지하기 위해 요소를 이동해야 하므로 비용이 많이 든다.

```python
numbers = [10, 20, 30, 40, 50]

print(numbers[0])  # Output: 10
print(numbers[3])  # Output: 40

numbers[2] = 35
print(numbers)  # Output: [10, 20, 35, 40, 50]
```

#### Linked List

Linked List는 일련의 노드로 구성된 기본 데이터 구조이다. **각 노드에는 데이터와 다음 노드에 대한 참조(링크)가 포함**되어 있다.

- **장점**
  - **효율적인 삽입/삭제**: 노드를 추가하거나 제거하는 작업은 배열에서처럼 요소를 이동하는 것이 아니라 포인터만 변경하는 작업이므로 대체로 효율적이다.
- **단점**
  - **순차적 액세스**: 노드는 첫 번째 노드부터 순차적으로 액세스해야 하며, 이는 특히 큰 목록(**액세스의 경우 O(n)**)의 경우 시간이 오래 걸릴 수 있다.
  - **복잡성**: **배열을 사용하는 것보다 더 복잡하며 오류율이 더 높다**(예: 목록에 대한 참조 손실).

```python
class Node:
  def __init__(self, data):
    self.data = data
    self.next = None

class LinkedList:
  def __init__(self):
    self.head = None
    self.tail = None

  def append(self, data):
    new_node = Node(data)
    if self.head is None:
      self.head = new_node
      self.tail = new_node
      return
    self.tail.next = new_node
    self.tail = new_node

  def delete_node(self, key):
    cur_node = self.head

    if not cur_node:
      return

    if cur_node.data == key:
      self.head = cur_node.next
      self.tail = None
      return

    while cur_node and cur_node.data != key:
      prev = cur_node
      cur_node = cur_node.next

    if not cur_node:
      return

    if cur_node.next is None:
      self.tail = prev

    prev.next = cur_node.next

  def print_list(self):
    cur_node = self.head
    while cur_node:
      print(cur_node.data, end=" -> ")
      cur_node = cur_node.next
    print(None)

llist = LinkedList()

# Inserting elements
llist.append(3)
llist.append(4)

# Output the list
print("Linked List:")
llist.print_list() # Output : 3 -> 4 -> None

# Deleting an element
llist.delete_node(3)

# Output the list after deletion
print("\nLinked List after deleting 3:")
llist.print_list() # Output : 4 -> None
```

#### Stack(스택)

스택은 마지막으로 추가된 항목이 가장 먼저 제거되는 **선입선출(LIFO) 원칙을 따른다**. 스택은 새 항목의 추가와 기존 항목의 제거가 항상 스택의 맨 위에서 이루어지는 정렬된 항목 모음이다.

- **장점**
  - **간단하고 직관적**: LIFO 원칙은 이해하고 구현하기 쉽다.
  - **효율적인 작업**: Push, Pop 같은 기본 연산은 **일반적으로 O(1)(상수 시간)이므로 매우 효율적**이다.
  - **접근 제어**: 연산을 최상위 요소로 제한하면 스택 내부에 대한 무단 액세스를 방지하여 데이터 보안을 강화할 수 있다.
- **단점**
  - **제한된 접근성**: 최상위 요소에만 직접 액세스할 수 있으므로 목록이나 대기열과 같은 다른 데이터 구조보다 유연성이 떨어진다.
  - **메모리 오버헤드**: 특정 구현에서 스택은 **기본 스토리지 구조(예: 연결된 목록의 포인터)로 인해 추가적인 메모리 오버헤드가 발생**할 수 있다.

```python
class Stack:
  def __init__(self):
    self.items = []

  def is_empty(self):
    return len(self.items) == 0

  def push(self, item):
    self.items.append(item)

  def pop(self):
    if not self.is_empty():
        return self.items.pop()
    else:
        return None

  def size(self):
    return len(self.items)

stack = Stack()
stack.push(1)
stack.push(2)
stack.push(3)

print(stack.pop())    # Output: 3
print(stack.size())   # Output: 2
```

#### Queue(큐)

Queue는 FIFO(선입선출) 원칙을 따르는 선형 데이터 구조이다. 이는 **대기열에 추가된 첫 번째 요소가 제거되는 첫 번째 요소가 됨을 의미**한다. 이는 음식점 계산대에 줄을 서서 가장 먼저 줄을 선 사람이 가장 먼저 음식을 받는 것과 유사하다.

- **장점**
  - **순서 유지**: 요소가 추가된 순서대로 처리되도록 한다.
  - **효율적인 작업**: 대기열에 넣기 및 빼기와 같은 **기본 작업은 일반적으로 `O(1)`(상수 시간)으로 매우 효율적**이다.
  - **광범위한 사용**: 작업 일정 관리, 데이터 통신의 버퍼링과 같은 다양한 컴퓨팅 시나리오에 유용하다.
- **단점**
  - **제한된 접근성**: 맨앞 및 맨뒤 요소와의 상호 작용만 허용하고 **중간 요소에 대한 직접 액세스를 제한**한다.

```python
class Queue:
  def __init__(self):
    self.items = []

  def is_empty(self):
    return len(self.items) == 0

  def enqueue(self, item):
    self.items.insert(0, item)

  def dequeue(self):
    if not self.is_empty():
      return self.items.pop()
    else:
      return None

  def size(self):
    return len(self.items)

queue = Queue()
queue.enqueue(1)
queue.enqueue(2)
queue.enqueue(3)

print(queue.dequeue()) # Output: 1
print(queue.size())    # Output: 2
```
