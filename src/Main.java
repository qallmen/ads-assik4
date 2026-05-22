public class Main {
    public static void main(String[] args) {
        // Runs your original Assignment 4 benchmark trials
        Experiment exp = new Experiment();
        exp.runMultipleTests();

        System.out.println("\n==============================");
        System.out.println("TESTING BONUS: DIJKSTRA ALGORITHM");
        System.out.println("==============================");

        // Creates a clean, custom weighted graph showcase
        Graph weightedGraph = new Graph();

        for (int i = 0; i < 5; i++) {
            weightedGraph.addVertex(new Vertex(i));
        }

        weightedGraph.addEdge(0, 1, 6);
        weightedGraph.addEdge(0, 2, 2);
        weightedGraph.addEdge(1, 3, 1);
        weightedGraph.addEdge(2, 1, 3);
        weightedGraph.addEdge(2, 3, 5);
        weightedGraph.addEdge(3, 4, 3);
        weightedGraph.addEdge(2, 4, 10);

        System.out.println("Weighted Graph Structure:");
        weightedGraph.printGraph();

        // Run your shortest path algorithm
        weightedGraph.dijkstra(0);
    }
}