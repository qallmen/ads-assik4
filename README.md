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

"C:\Program Files\Java\jdk-25\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2025.3\lib\idea_rt.jar=52675" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\User\IdeaProjects\assignment1ads\assignment4\out\production\assignment4 Main

==============================
TESTING GRAPH SIZE: 10
==============================
Graph Structure (Small):
0: [0 -> 7 (1)]
1: [1 -> 3 (1), 1 -> 8 (1)]
2: [2 -> 6 (1), 2 -> 7 (1), 2 -> 3 (1)]
3: [3 -> 9 (1), 3 -> 1 (1)]
4: [4 -> 0 (1), 4 -> 3 (1), 4 -> 0 (1)]
5: [5 -> 3 (1)]
6: []
7: [7 -> 1 (1)]
8: [8 -> 2 (1), 8 -> 9 (1), 8 -> 4 (1)]
9: [9 -> 8 (1), 9 -> 6 (1), 9 -> 5 (1)]
Starting BFS from node 0:
0 7 1 3 8 9 2 4 6 5 
Starting DFS from node 0:
0 7 1 3 9 8 2 6 4 5 
Execution Results:
BFS Time: 3070300 ns
DFS Time: 1158600 ns

==============================
TESTING GRAPH SIZE: 30
==============================
Starting BFS from node 0:
0 12 17 16 7 18 9 25 2 19 20 22 6 27 15 10 5 28 1 3 24 26 4 14 13 29 
Starting DFS from node 0:
0 12 16 17 18 25 6 27 5 26 22 19 15 3 2 10 24 28 14 4 13 29 1 20 7 9 
Execution Results:
BFS Time: 1700100 ns
DFS Time: 3046900 ns

==============================
TESTING GRAPH SIZE: 100
==============================
Starting BFS from node 0:
0 91 32 94 4 34 81 23 70 17 13 15 92 73 20 36 10 85 9 78 77 6 82 5 64 14 38 57 61 29 75 43 46 37 49 18 7 87 90 8 80 96 35 84 68 74 97 24 55 3 60 47 39 63 83 62 45 25 42 69 56 2 76 40 58 48 26 12 30 79 31 21 99 72 28 52 16 53 19 11 51 71 95 
Starting DFS from node 0:
0 91 32 34 15 82 46 68 43 84 62 79 96 83 76 45 85 57 5 49 92 73 64 18 97 36 13 94 23 10 38 90 3 40 61 8 47 48 28 77 74 58 60 9 81 20 14 87 55 56 99 70 78 75 35 29 80 39 26 52 71 63 12 16 95 69 21 11 2 30 4 72 51 17 6 37 7 24 53 25 42 31 19 
Execution Results:
BFS Time: 8882500 ns
DFS Time: 13931300 ns

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

Process finished with exit code 0













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
