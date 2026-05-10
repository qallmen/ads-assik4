import java.util.*;

public class Graph {
    private Map<Integer, List<Edge>> adjList; // Adjacency List [cite: 36]
    private Map<Integer, Vertex> vertices;

    public Graph() {
        adjList = new HashMap<>();
        vertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        if (vertices.containsKey(from) && vertices.containsKey(to)) {
            Edge edge = new Edge(vertices.get(from), vertices.get(to));
            adjList.get(from).add(edge);
        }
    }

    // Breadth-First Search [cite: 12, 43]
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

    // Depth-First Search [cite: 12, 44]
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