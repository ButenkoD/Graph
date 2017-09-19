package com.andersenlab.graph;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PathFinder {
    private final Logger logger = LogManager.getLogger(Graph.class);
    public static final String CANT_FIND_EXCEPTION_TEXT = "Can't create Edge with equal start point and end point";
    private List<Path> openPaths = new ArrayList<>();
    private List<Path> finishedPaths = new ArrayList<>();
    private final Graph graph;
    private final int startPoint;
    private final int endPoint;

    public PathFinder(Graph graph, int startPoint, int endPoint) {
        this.graph = graph;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    public List<Edge> getOptiomalPath() throws Exception {
        if (!graph.hasStartPoint(startPoint) || !graph.hasEndPoint(endPoint)) {
            logger.error(CANT_FIND_EXCEPTION_TEXT);
            throw new Exception(CANT_FIND_EXCEPTION_TEXT);
        }
        initSearch();
        List<Path> newOpenPaths;
        while (openPaths.size() > 0) {
            newOpenPaths = new ArrayList<>();
            for (Path pathIter: openPaths) {
                List<Edge> lastEdges = graph.getEdgesByPoint(pathIter.getLastPoint());
                for (Edge edge : lastEdges) {
                    if (!pathIter.hasEdge(edge)) {
                        Path newPath = Path.newPath(pathIter, edge);
                        if (newPath.reachedFinish(endPoint)) {
                            finishedPaths.add(newPath);
                        } else {
                            newOpenPaths.add(newPath);
                        }
                    }
                }
            }
            openPaths = newOpenPaths;
        }
        return getMinimumWeightPath(finishedPaths);
    }

    private void initSearch() {
        for (Edge edge : graph.getEdgesByPoint(startPoint)) {
            Path newPath = Path.initPath(edge);
            if (newPath.reachedFinish(endPoint)) {
                finishedPaths.add(newPath);
            } else {
                openPaths.add(Path.initPath(edge));
            }
        }
    }

    private List<Edge> getMinimumWeightPath(List<Path> paths) {
        Path easiestPath = paths.get(0);
        for (Path path: paths) {
            if (path.weight < easiestPath.weight) {
                easiestPath = path;
            }
        }
        return easiestPath.edges;
    }

    private static class Path {
        private double weight = 0;
        private List<Edge> edges = new ArrayList<>();

        private static Path initPath(Edge edge) {
            Path result = new Path();
            result.addEdge(edge);
            return result;
        }

        private static Path newPath(Path oldPath, Edge edge) {
            Path result = new Path();
            result.weight = oldPath.getWeight();
            result.edges = new ArrayList<>(oldPath.edges);
            result.addEdge(edge);
            return result;
        }

        boolean hasEdge(Edge edge) {
            return edges.contains(edge);
        }

        private double getWeight() {
            return weight;
        }

        private void addWeight(double weight) {
            this.weight += weight;
        }

        private void addEdge(Edge edge) {
            edges.add(edge);
            addWeight(edge.getWeight());
        }

        private int getLastPoint() {
            return edges.get(edges.size() - 1 ).getEndPoint();
        }

        boolean reachedFinish(int endPoint) {
            return getLastPoint() == endPoint;
        }
    }
}
