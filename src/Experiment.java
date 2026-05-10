import java.util.Random;

public class Experiment {

    public void runTraversals(Graph g, int startNode) {
        System.out.println("Starting BFS from node " + startNode + ":");
        long startBFS = System.nanoTime(); // [cite: 68]
        g.bfs(startNode);
        long endBFS = System.nanoTime(); // [cite: 69]

        System.out.println("\nStarting DFS from node " + startNode + ":");
        long startDFS = System.nanoTime();
        g.dfs(startNode);
        long endDFS = System.nanoTime();

        System.out.println("\nExecution Results:");
        System.out.println("BFS Time: " + (endBFS - startBFS) + " ns");
        System.out.println("DFS Time: " + (endDFS - startDFS) + " ns");
    }

    public void runMultipleTests() {
        int[] sizes = {10, 30, 100}; // Small, Medium, Large [cite: 61, 62, 74]

        for (int size : sizes) {
            System.out.println("\n==============================");
            System.out.println("TESTING GRAPH SIZE: " + size);
            System.out.println("==============================");

            Graph g = new Graph();
            for (int i = 0; i < size; i++) {
                g.addVertex(new Vertex(i));
            }

            // Connect nodes randomly [cite: 63]
            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                int connections = rand.nextInt(3) + 1;
                for (int j = 0; j < connections; j++) {
                    int target = rand.nextInt(size);
                    if (i != target) g.addEdge(i, target);
                }
            }

            if (size == 10) {
                System.out.println("Graph Structure (Small):");
                g.printGraph(); // [cite: 71]
            }

            runTraversals(g, 0);
        }
    }
}