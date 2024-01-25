---
layout: post
title: 검색 알고리즘 - 너비 우선 검색(BFS)
tags: [알고리즘, 검색 알고리즘, 너비 우선 검색(BFS)]
categories: [알고리즘, 검색 알고리즘, 너비 우선 검색(BFS)]
image:
  path: /assets/img/post/algorithm/bfs-and-dfs.png
  alt: bfs-and-dfs
date: 2024-01-25 10:54 +0900
---

## BFS(Breadth-First Search)는

BFS는 **그래프의 정점을 레이어별로 탐색하는 기본적인 그래프 순회 알고리즘**이다. 선택한 루트 노드에서 시작하여 다음 깊이 수준의 노드로 이동하기 전에 현재 깊이의 모든 인접 노드를 탐색한다. BFS는 **최단 경로를 찾는 데 특히 유용**하며 네트워킹, 경로 찾기 및 알고리즘 게임을 포함한 다양한 영역에 적용된다.

### BFS 작동 방식

- **초기화**: BFS는 **선택된 노드(종종 '루트' 노드라고 함)**로 시작된다.
- **노드 방문**
  - 루트 노드가 먼저 대기열에 추가된다.
  - 각 **반복에서 노드는 대기열에서 제거되고 방문한 것으로 표시**된다.
  - 제거된 노드의 모든 인접 노드(이웃)를 검사한다. 인접한 노드 중 방문하지 않았고 아직 대기열에 있지 않은 경우 대기열에 추가한다.
- **레벨별 탐색**
  - BFS는 **다음 깊이 수준의 노드로 이동하기 전에 현재 깊이 수준의 모든 노드를 탐색**한다.

### 복잡도

- **시간 복잡도**: O(V + E) - 여기서 **V는 정점 수, E는 그래프의 간선 수**를 나타낸다. 이러한 복잡성은 최악의 경우 BFS가 그래프의 모든 정점과 가장자리를 방문해야 할 수 있기 때문에 발생한다.
- **공간 복잡도**: O(V) - 대기열을 저장하는 데 사용되는 공간

> BFS에 장단점에 대해 알아보기 전에 **그래프의 종류**에 대해 먼저 알아보자.

### 장단점

- **장점**
  - **최단 경로**: BFS는 비가중 그래프에서 최단 경로를 보장하므로 **미로나 그래프의 두 노드 사이 등 최단 경로를 찾는 알고리즘에 적합**하다.
  - **레벨 순서 탐색**: BFS는 트리 또는 그래프의 레벨 순서 탐색에 사용될 수 있으며, 이는 레벨별로 노드를 처리해야 하는 특정 알고리즘에 중요할 수 있다.
  - **웹 크롤링**: BFS는 구조는 거대하지만 느슨하게 연결되어 있는 웹 크롤링에 적합하다.
  - **연결된 구성 요소 찾기**: BFS는 무방향 그래프에서 모든 연결된 구성 요소를 효율적으로 찾을 수 있다.
- **단점**
  - **메모리 사용량**: 대기열의 현재 프론티어(현재 깊이의 정점)에 있는 모든 정점을 저장해야 하므로 메모리 집약적이다.
  - **깊거나 무한한 그래프에는 적합하지 않음**: 그래프가 매우 깊거나 잠재적으로 무한한 경우 BFS는 느릴 수 있다.

### 예시 코드

```python
from collections import deque

class Graph:
  def __init__(self):
    self.adj_list = {}

  def add_vertex(self, vertex):
    self.adj_list.setdefault(vertex, [])

  def add_edge(self, v1, v2):
    if v1 in self.adj_list and v2 in self.adj_list:
      self.adj_list[v1].append(v2)
      self.adj_list[v2].append(v1)

  def bfs_find(self, start_vertex, target_vertex):
    if start_vertex not in self.adj_list:
      return False

    visited = set()
    queue = deque([start_vertex])

    while queue:
      vertex = queue.popleft()
      if vertex == target_vertex:
        return True  # Target vertex found
      if vertex not in visited:
        visited.add(vertex)
        # Enqueue all unvisited neighbors
        queue.extend(neighbor for neighbor in self.adj_list[vertex] if neighbor not in visited)
    return False  # Target vertex not found

graph = Graph()
for vertex in ['A', 'B', 'C', 'D', 'E']:
    graph.add_vertex(vertex)

edges = [('A', 'B'), ('A', 'C'), ('B', 'D'), ('C', 'D'), ('C', 'E'), ('D', 'E')]

for v1, v2 in edges:
    graph.add_edge(v1, v2)

print(graph.bfs_find('A', 'E')) # Output : True
```
