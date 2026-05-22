Bonus Task: Dijkstra's Algorithm (Shortest Path)
Project Extension Overview
To fulfill the extra credit requirements, the graph system was extended to support weighted edge structures and calculate the shortest path from a given starting vertex to all other reachable nodes.

Edge Class Update: Modified the Edge class to include a private int weight field alongside its constructor and a getWeight() getter.

Graph Class Update: Added an overloaded addEdge(int from, int to, int weight) method to append weighted edges to the Map-based adjacency list. The existing unweighted addEdge method was preserved by setting a default weight of 1 to maintain complete backward compatibility with the baseline BFS and DFS traversal experiments.

Algorithm Implementation: Implemented the void dijkstra(int start) method using standard arrays and primitive loops. Per the project guidelines, no PriorityQueue or standard collections libraries were used to find minimum weights.

Algorithm Logic and Implementation Details
Instead of relying on a min-heap, the algorithm finds the shortest path using a linear scanning approach:

Tracking Arrays: A primitive int[] distance array tracks the minimum cost to reach each vertex (initialized to Integer.MAX_VALUE), and a boolean[] visited array tracks processed nodes.

Vertex Selection: A nested loop scans through the graph's vertex keyset to manually find the unvisited vertex with the absolute smallest tentative distance value.

Edge Relaxation: Once the minimum-distance vertex u is selected, the algorithm iterates through its specific adjacency list and updates the neighbor v's distance if dist[u] + weight < dist[v].

Experimental Verification Results
The algorithm was tested on a sample 5-vertex directed graph with the following structural layout:

0 -> 1 (Weight: 6), 0 -> 2 (Weight: 2)

1 -> 3 (Weight: 1)

2 -> 1 (Weight: 3), 2 -> 3 (Weight: 5), 2 -> 4 (Weight: 10)

3 -> 4 (Weight: 3)

Console Execution Output

==============================
TESTING BONUS: DIJKSTRA ALGORITHM
==============================
Weighted Graph Structure:
0: [0 -> 1 (6), 0 -> 2 (2)]
1: [1 -> 3 (1)]
2: [2 -> 1 (3), 2 -> 3 (5), 2 -> 4 (10)]
3: [3 -> 4 (3)]
4: []

=== Dijkstra Shortest Path Results (Start: 0) ===
Vertex     | Shortest Distance
--------------------------------
0          | 0              
1          | 5              
2          | 2              
3          | 6              
4          | 9












# ads-assik4
Iliyas Kalmen 
SE-2514 
This project implements a graph data structure using an adjacency list to store vertices and edges. It features two core
traversal algorithms: Breadth-First Search (BFS) and Depth-First Search (DFS), which are used to explore the graph's nodes. I
conducted experiments across three graph sizes—10, 30, and 100 vertices—to analyze how scale affects traversal efficiency.
Using System.nanoTime(), I measured the execution time for each algorithm to compare their performance and verify their
$O(V+E)$ complexity. The results demonstrate the practical differences between level-order exploration and deep-path
exploration within various graph structures. 
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/c1c3a876-7bf6-4f18-8dc1-e7c3542b4f94" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/78f95829-8f8a-4e20-b140-ef12aaea94f1" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/f1befdc2-1826-41aa-86ec-86d34621144f" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/202c3a7f-65fb-45a3-9cb6-f03b12f86bf9" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/c913f6a0-c3f1-42ae-947e-44e824dd908d" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/76385ba9-c761-4ca0-94e1-0d8a8c1e4b97" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/575f7f76-0e82-4108-b061-e32a1c220b67" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/36c8dcbf-7372-4584-924b-8ca6655c7ebb" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/d3d754fb-e850-44dd-bfa5-f34cc3cbb225" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/cd7df691-141d-4278-8379-c6f25f608ae1" />
