package com.andersenlab.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuilderTest {
    @Test
    public void testBuilder() throws Exception {
        Graph graph = new Graph.Builder()
            .edge(1, 3, 1)
            .build();
        assertEquals("Graph", graph.getClass().getSimpleName());
    }
    @Test(expected = Exception.class)
    public void testBuilderException() throws Exception {
        new Graph.Builder()
            .edge(1, 1, 1)
            .build();
    }
}