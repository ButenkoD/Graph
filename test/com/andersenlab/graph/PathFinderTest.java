package com.andersenlab.graph;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PathFinderTest {
    @Test
    public void getOptiomalPathOneStep() throws Exception {
        Graph graph = new Graph.Builder()
                .edge(1, 2, 1)
                .edge(1, 3, 1)
                .edge(4, 1, 1)
                .edge(1, 4, 2)
                .edge(2, 3, 2)
                .edge(1, 5, 5)
                .edge(3, 4, 1)
                .edge(4, 5, 1)
                .edge(2, 4, 5.1)
                .build();
        List<Edge> edges = new PathFinder(graph).getOptiomalPath(1, 4);
        assertEquals(2, edges.get(0).getWeight(), 0.1);
    }

    @Test
    public void getOptiomalPathTwoSteps1() throws Exception {
        Graph graph = new Graph.Builder()
                .edge(1, 2, 1)
                .edge(1, 3, 1)
                .edge(4, 1, 1)
                .edge(1, 4, 2)
                .edge(2, 3, 2)
                .edge(1, 5, 5)
                .edge(3, 4, 1)
                .edge(4, 5, 1)
                .edge(2, 4, 5.1)
                .build();
        List<Edge> edges = new PathFinder(graph).getOptiomalPath(1, 5);
        assertEquals(4, edges.get(1).getStartPoint());
    }

    @Test
    public void getOptiomalPathTwoSteps2() throws Exception {
        Graph graph = new Graph.Builder()
                .edge(1, 2, 1)
                .edge(1, 3, 6)
                .edge(4, 1, 1)
                .edge(1, 4, 2)
                .edge(2, 3, 2)
                .edge(1, 5, 5)
                .edge(3, 4, 1)
                .edge(4, 5, 1)
                .edge(2, 4, 5.1)
                .build();
        List<Edge> edges = new PathFinder(graph).getOptiomalPath(1, 3);
        assertEquals(2, edges.get(0).getEndPoint());
    }

    @Test(expected = Exception.class)
    public void getOptiomalPathFail() throws Exception {
        Graph graph = new Graph.Builder()
                .edge(1, 2, 1)
                .edge(4, 5, 1)
                .build();
        new PathFinder(graph).getOptiomalPath(2, 3);
    }
}
