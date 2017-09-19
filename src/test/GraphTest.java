package com.andersenlab.graph;

public class GraphTest {
    public static void main(String[] args) {
        try {
            Graph graph = new Graph.Builder()
                    .edge(1, 2, 1)
                    .edge(1, 3, 1)
                    .edge(4, 1, 1)
                    .edge(1, 4, 2)
                    .edge(2, 3, 2)
                    .edge(1, 3, 5)
                    .edge(3, 4, 1)
                    .edge(4, 5, 1)
                    .edge(2, 4, 5.1)
                    .build();
            runTest(graph, 1, 3);
            runTest(graph, 2, 5);
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }

    private static void runTest(Graph graph, int startPoint, int endPoint) {
        try {
            for (Edge edge : new PathFinder(graph, startPoint, endPoint).getOptiomalPath()) {
                System.out.println(edge);
            }
            System.out.println("========================");

        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }
}
