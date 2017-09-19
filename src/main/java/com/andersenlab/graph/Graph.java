package com.andersenlab.graph;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private static final Logger logger = LogManager.getLogger(Graph.class);
    private final List<Edge> edges;
    private Graph(Builder builder) {
        edges = builder.edges;
    }

    public boolean hasStartPoint(int startPoint) {
        for (Edge edge: edges) {
            if (edge.getStartPoint() == startPoint) {
                return true;
            }
        }
        return false;
    }

    public boolean hasEndPoint(int endPoint) {
        for (Edge edge: edges) {
            if (edge.getEndPoint() == endPoint) {
                return true;
            }
        }
        return false;
    }

    List<Edge> getEdgesByPoint(int startPoint) {
        List<Edge> result = new ArrayList<>();
        for (Edge edge: edges) {
            if (edge.getStartPoint() == startPoint) {
                result.add(edge);
            }
        }
        return result;
    }

    public String toString() {
        String result = "";
        for (Edge edge: edges) {
            result += edge.toString() + "\n";
        }
        return result;
    }

    public static class Builder {
        private List<Edge> edges = new ArrayList<>();
        public Graph build() {
            Graph graph = new Graph(this);
            Graph.logger.info("Created new Graph:\n" + graph);
            return graph;
        }

        public Builder edge(int startPoint, int endPoint, double weight) throws Exception {
            Edge edge = new Edge(startPoint, endPoint, weight);
            edges.add(edge);
            return this;
        }
    }
}
