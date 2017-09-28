package com.andersenlab.graph;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Edge {
    private static final Logger logger = LogManager.getLogger(Graph.class);
    private static final String CREATE_EXCEPTION_TEXT = "Can't create Edge with equal start point and end point";
    private final int startPoint;
    private final int endPoint;
    private final double weight;

    Edge(int startPoint, int endPoint, double weight) throws Exception {
        if (startPoint == endPoint) {
            logger.error(CREATE_EXCEPTION_TEXT + ": " + Integer.toString(startPoint));
            throw new Exception(CREATE_EXCEPTION_TEXT);
        }
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.weight = weight;
    }

    int getStartPoint() {
        return startPoint;
    }

    int getEndPoint() {
        return endPoint;
    }

    double getWeight() {
        return weight;
    }

    public String toString() {
        return "Edge from " + Integer.toString(startPoint) + " to "
                + Integer.toString(endPoint) + " with weight "
                + Double.toString(weight);
    }
}