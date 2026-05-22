import java.util.*;

public class Graph {
    private Map<Integer, List<Edge>> adjList;
    private Map<Integer, Vertex> vertices;

    public Graph() {
        adjList = new HashMap<>();
        vertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    // Preserved so your existing random-graph experiments do not break
    public void addEdge(int from, int to) {
        addEdge(from, to, 1);
    }

    // Overloaded method to support explicit edge weights for Dijkstra
    public void addEdge(int from, int to, int weight) {
        if (vertices.containsKey(from) && vertices.containsKey(to)) {
            Edge edge = new Edge(vertices.get(from), vertices.get(to), weight);
            adjList.get(from).add(edge);
        }
    }

    // Dijkstra's Algorithm using basic arrays and loops (No PriorityQueue)
    public void dijkstra(int start) {
        if (!vertices.containsKey(start)) {
            System.out.println("Starting vertex " + start + " not found.");
            return;
        }

        // 1. Find the highest vertex ID to correctly size primitive arrays
        int maxId = 0;
        for (int id : vertices.keySet()) {
            if (id > maxId) {
                maxId = id;
            }
        }

        // 2. Setup distance and visited tracking arrays
        int[] distance = new int[maxId + 1];
        boolean[] visited = new boolean[maxId + 1];

        // Initialize all distances to Infinity
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        // 3. Process vertices using simple loops instead of a PriorityQueue
        for (int count = 0; count < vertices.size(); count++) {

            // Look for the unvisited vertex with the minimum distance value
            int u = -1;
            int min = Integer.MAX_VALUE;

            for (int id : vertices.keySet()) {
                if (!visited[id] && distance[id] < min) {
                    min = distance[id];
                    u = id;
                }
            }

            // If no reachable vertex is found, remaining vertices are disconnected
            if (u == -1) {
                break;
            }

            // Mark the selected vertex as processed
            visited[u] = true;

            // Relax the adjacent edges of the selected vertex
            List<Edge> edges = adjList.get(u);
            if (edges != null) {
                for (Edge edge : edges) {
                    int v = edge.getDestination().getId();
                    int weight = edge.getWeight();

                    // Check boundaries and relax edge distance path rules
                    if (!visited[v] && distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                        distance[v] = distance[u] + weight;
                    }
                }
            }
        }

        // 4. Output the results clearly
        System.out.println("\n=== Dijkstra Shortest Path Results (Start: " + start + ") ===");
        System.out.printf("%-10s | %-15s\n", "Vertex", "Shortest Distance");
        System.out.println("--------------------------------");
        for (int id : vertices.keySet()) {
            String distStr = (distance[id] == Integer.MAX_VALUE) ? "Unreachable" : String.valueOf(distance[id]);
            System.out.printf("%-10d | %-15s\n", id, distStr);
        }
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            for (Edge edge : adjList.get(current)) {
                int neighbor = edge.getDestination().getId();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);
    }

    private void dfsHelper(int current, Set<Integer> visited) {
        visited.add(current);
        System.out.print(current + " ");
        for (Edge edge : adjList.get(current)) {
            int neighbor = edge.getDestination().getId();
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public void printGraph() {
        for (int id : adjList.keySet()) {
            System.out.println(id + ": " + adjList.get(id));
        }
    }
}