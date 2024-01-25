---
layout: post
title: 데이터 구조 - 비선형
tags: [알고리즘, 데이터 구조 - 비선형]
categories: [알고리즘, 데이터 구조 - 비선형]
image:
  path: /assets/img/post/algorithm/data-structure.png
  alt: data-structure
date: 2024-01-17 17:13 +0900
---

## 비선형 데이터 구조

비선형 데이터 구조는 **데이터 요소가 순차적인 선형 순서로 배열되지 않은 데이터 구조**이며, 계층적 방식으로 연결되므로 요소 간의 관계가 다소 복잡하다. 이 구조는 선형, 순차 형식에 자연스럽게 맞지 않는 데이터를 나타내는 데 적합하다.

- **주요 특징**
  - **계층적 관계**: 요소가 계층적으로 배열되어 있으며, 이는 **각 요소가 하나 이상의 다른 요소와 관련되어 계층 구조를 형성**할 수 있음을 의미한다.
  - **다중 레벨 구성**: 비선형 데이터 구조는 **여러 레벨을 가질 수 있다**. 예를 들어, 트리 데이터 구조에는 루트 노드와 여러 수준의 하위 노드가 있다.
  - **비순차적 접근**: 순차적으로 접근이 되지 않으며, 요소에 액세스하는 순서는 특정 요구 사항과 요소 구성에 따라 다르다.

### Trees(트리)

트리는 **일련의 연결된 노드로 계층적 트리 구조를 시뮬레이션하는 데이터 구조 유형**이다. 트리의 각 노드는 자체 데이터와 다른 노드(자식)에 대한 포인터를 보유한다.

- **장점**
  - **계층적 구조**: 가계도나 **회사 조직도와 유사한 구조적 관계를 반영하므로 이러한 계층적 데이터 표현에 적합**하다.
  - **효율적인 검색**: **이진 검색 트리를 사용하면 빠른 데이터 검색, 삽입 및 삭제 작업이 가능**하다.
  - **정렬된 데이터**: 이진 검색 트리는 항상 정렬되어 있어 요소의 순서대로 탐색이 용이하다.
- **단점**
  - **복잡성**: 트리는 배열이나 연결 목록과 같은 선형 데이터 구조보다 더 복잡하다.
  - **오버헤드**: 각 노드에는 **하위 항목(루트가 아닌 경우 상위 항목)에 대한 포인터를 위한 추가 저장 공간이 필요**하다.
  - **균형 문제**: 최악의 경우 **트리가 자체 균형을 이루지 않는 한 성능이 O(n)으로 저하될 수 있다**.

```python
class TreeNode:
  def __init__(self, key):
    self.left = None
    self.right = None
    self.val = key

  def insert(self, key):
    if self.val is None:
      self.val = key
      return

    if self.val < key:
      if self.right is None:
          self.right = TreeNode(key)
      else:
          self.right.insert(key)
    else:
      if self.left is None:
          self.left = TreeNode(key)
      else:
          self.left.insert(key)

  def inorder_traversal(self):
    if self.left:
      self.left.inorder_traversal()
    print(self.val, end=' ')
    if self.right:
      self.right.inorder_traversal()

# Usage
root = TreeNode(50)
root.insert(30)
root.insert(20)
root.insert(40)
root.insert(70)
root.insert(60)
root.insert(80)

print("Inorder traversal of the given tree:")
root.inorder_traversal() # Output: 20 30 40 50 60 70 80
```

### Graphs(그래프)

그래프는 **가장자리로 연결된 노드(정점) 네트워크를 나타내는 데 사용**되며, 소셜 네트워크, 컴퓨터 네트워크, 교통 시스템과 같은 다양한 실제 구조를 모델링할 수 있다.

- **장점**
  - **복잡한 구조의 표현**: 그래프는 엔티티가 복잡한 방식으로 상호 연결된 소셜 네트워크와 같은 복잡한 관계와 구조를 나타내는 데 탁월하다.
  - **경로찾기**: 최단 경로를 찾거나 노드 간 연결을 탐색하는 알고리즘(깊이 우선 검색 - DFS 또는 너비 우선 검색 - BFS)에 자주 사용된다.
  - **클러스터링 및 추천 시스템**: 그래프는 데이터 내의 커뮤니티나 클러스터를 식별하는 데 사용할 수 있으며, **추천 시스템(예: Amazon 또는 Netflix에서 사용하는 시스템)을 설계하는 데 기본으로 사용**된다.
- **단점**
  - **알고리즘 복잡성**: 그래프에 대한 많은 작업(최단 경로 찾기 또는 주기 감지 등)은 다른 데이터 구조에 대한 작업에 비해 시간 복잡성이 더 높다.
  - **확장성 문제**: **그래프의 크기가 커짐에 따라 그래프를 처리하는 데 계산 집약적**이 될 수 있다.

```python
class Graph:
  def __init__(self):
    self.graph = {}

  def add_edge(self, u, v):
    if u not in self.graph:
      self.graph[u] = []
    self.graph[u].append(v)

  def show_edges(self):
    for node in self.graph:
      for neighbor in self.graph[node]:
        print(f"({node}, {neighbor})", end=' ')
    print()  # for newline

# Usage
g = Graph()
g.add_edge(1, 2)
g.add_edge(1, 3)
g.add_edge(2, 3)
g.add_edge(3, 4)
g.add_edge(4, 1)

print("Graph edges:")
g.show_edges() # Output : (1, 2) (1, 3) (2, 3) (3, 4) (4, 1)
```

![tree-graph](/assets/img/post/algorithm/tree-graph.jpg){: width="700＂ }

#### 그래프의 종류

- **방향 그래프(Directed Graph)**
  - **간선에 방향이 있다.**
  - 정점 A에서 정점 B까지의 가장자리가 있는 경우(A -> B) A에서 B로 이동할 수 있지만 B에서 A로 이동할 수는 없다.
  - **사용 사례**: 웹 페이지 링크 또는 코스 예약의 전제 조건과 같이 관계가 단방향인 시나리오에 사용된다.

![directed-graph](/assets/img/post/algorithm/directed-graph.png){: width=＂500＂ }

- **무방향 그래프(Undirected Graph)**
  - **간선에 방향이 없다.**
  - 정점 A와 정점 B 사이에 가장자리가 있는 경우 A에서 B로, B에서 A로 제한 없이 이동할 수 있다.
  - **사용 사례**: 소셜 네트워크의 팔로워나 지도의 도로 연결과 같은 양방향 관계를 모델링하는 데 사용된다.

![undirected-graph](/assets/img/post/algorithm/undirected-graph.png){: width=＂500＂ }

- **가중 그래프(Weighted Graph)**
  - **각 모서리에는 가중치 또는 비용이 있다.**
  - 가중치는 **거리, 비용 또는 문제와 관련된 측정항목**을 나타낼 수 있습니다.
  - **사용 사례**: 가장자리는 도로를 나타내고 무게는 거리 또는 이동 시간을 나타내는 도로 네트워크에서 **최단 경로를 찾는 문제에서 일반적으로 사용**된다.

![weighted-graph](/assets/img/post/algorithm/weighted-graph.png){: width=＂500＂ }

- **방향성 비순환 그래프(Directed Acyclic Graph)**
  - **순환이 없는 유향 그래프이다.**
  - 정점 v에서 시작하여 v로 다시 루프백되는 방법이 없음을 의미한다.
  - **사용 사례**: 작업 예약과 같은 종속성이 있는 구조를 표현하고 **버전 제어 기록과 같은 시나리오에서 유용**하다.

![directed-acyclic-graph](/assets/img/post/algorithm/directed-acyclic-graph.png){: width=＂500＂ }

- **완전 그래프(Complete Graph)**
  - **서로 다른 정점의 모든 쌍이 연결**된 그래프이다.
  - **사용 사례**: 이론적 그래프 연구 및 모든 위치(정점)가 다른 모든 위치에 연결되는 여행하는 외판원 같은 문제에 자주 사용된다.

![complete-graph](/assets/img/post/algorithm/complete-graph.png){: width=＂600＂ }

- **이분 그래프(Bipartite Graph)**
  - 모든 모서리가 한 세트의 꼭지점을 다른 세트의 꼭지점에 연결하도록 꼭지점을 두 개의 분리되고 독립적인 세트로 나눌 수 있는 그래프이다.
  - **사용 사례**: 작업 할당 문제, 일치 문제 등 **서로 다른 두 개체 클래스 간의 관계를 모델링하는 데 사용**된다.

![bipartite-graph](/assets/img/post/algorithm/bipartite-graph.png){: width=＂500＂ }

### Tables(테이블)

테이블은 **데이터베이스 및 데이터 저장과 관련하여 널리 사용되는 데이터 구조**이다. 프로그래밍에서 테이블은 일반적으로 행과 열로 구성된 데이터의 구조화된 배열로 생각할 수 있으며, 쉽게 조작하고 접근할 수 있다.

- **장점**
  - **정리된 데이터**: 테이블의 데이터는 **행과 열로 구성되어 있어 이해하고 해석하기 쉽다**.
  - **효율적인 데이터 검색**: 적절하게 인덱싱된 경우 효율적인 데이터 검색 작업을 허용한다. **데이터가 있는 행과 열을 알고 있으면 모든 데이터에 빠르게 액세스**할 수 있다.
  - **유연한 데이터 조작**: 테이블을 사용하면 데이터 분석에 필수적인 정렬, 필터링, 그룹화 등 다양한 작업이 가능하다.
  - **관계 표현**: 관계형 데이터베이스에서 테이블은 **외래 키를 통해 다양한 유형의 데이터 간의 관계를 나타낼 수 있다**.
- **단점**
  - **대규모 데이터의 복잡성**: 대량의 데이터가 포함된 테이블을 처리하는 것은 복잡할 수 있으며 **조인, 검색 또는 인덱싱과 같은 작업은 최적화 기술이 필요**할 수 있다.
  - **고정 스키마**: 대부분의 테이블 구현에는 고정 스키마가 필요하다. 즉, **테이블 구조(열 및 데이터 유형)를 미리 정의해야 하므로 유연성이 제한**될 수 있다.
  - **메모리 오버헤드**: 테이블의 각 셀이 공간을 차지하므로 테이블에 더 많은 메모리가 소모될 수 있다. 특히 테이블에 null 또는 중복 값이 ​​많이 포함된 경우에는 더욱 그렇다.

```python
table = [
  {"Name": "Alice", "Age": 30, "City": "New York"},
  {"Name": "Bob", "Age": 25, "City": "Los Angeles"},
  {"Name": "Charlie", "Age": 35, "City": "Chicago"}
]

def print_table(table):
  headers = table[0].keys()
  print(' | '.join(headers))
  print('-' * (7 * len(headers)))

  for row in table:
    print(' | '.join(str(row[header]) for header in headers))

def add_row(table, row):
  table.append(row)

print("Original Table:")
print_table(table)
# Name | Age | City
# ---------------------
# Alice | 30 | New York
# Bob | 25 | Los Angeles
# Charlie | 35 | Chicago

add_row(table, {"Name": "Diana", "Age": 28, "City": "Boston"})
print("\nTable after adding a new row:")
print_table(table)
# Name | Age | City
# ---------------------
# Alice | 30 | New York
# Bob | 25 | Los Angeles
# Charlie | 35 | Chicago
# Diana | 28 | Boston
```

### Sets(집합)

집합은 **특별한 순서가 없는 고유한 요소의 모음**이다. 특정 요소가 집합에 포함되어 있는지 확인하는 데 고도로 최적화되어 있다.

- **장점**
  - **고유한 요소**: 집합은 **모든 요소가 고유한지 자동으로 확인하고 중복을 제거**한다.
  - **빠른 연산 속도**: 항목이 집합에 있는지 확인하는 것은 기본 해시 테이블 구현으로 인해 O(1) 시간 복잡도를 가진다.
  - **수학적 연산**: 집합은 합집합, 교차점, 차이, 대칭 차이와 같은 수학적 연산을 지원하므로 항목 그룹에 대한 연산을 쉽게 수행할 수 있다.
- **단점**
  - **순서 없음**: 집합은 **순서가 없는 컬렉션이므로 항목의 위치가 고정되어 있지 않다**. 인덱스별로 항목에 액세스할 수 없으며 항목이 특정 순서로 유지될 것으로 기대할 수 없다.
  - **다중성 파악 불가**: 집합은 요소의 다중성을 기록할 수 없다. 예를 들어, 각 항목이 나타나는 횟수를 계산하려는 경우 세트는 고유한 요소만 유지하므로 불가능하다.

```python
fruits = {"apple", "banana", "cherry"}
print("Original Set:", fruits)
# Output : {'banana', 'apple', 'cherry'}

# Adding an element
fruits.add("orange")
print("After adding an element:", fruits)
# Output : {'orange', 'banana', 'apple', 'cherry'}

fruits.remove("banana")
print("After removing an element:", fruits)
# Output : {'orange', 'apple', 'cherry'}

if "apple" in fruits:
    print("Apple is in the set")

other_fruits = {"berry", "cherry", "dragonfruit"}
print("Union:", fruits.union(other_fruits))
# Output : {'cherry', 'dragonfruit', 'orange', 'apple', 'berry'}
print("Intersection:", fruits.intersection(other_fruits))
# Output : {'cherry'}
```
