package com.learning.dsa.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CycleDirectedGraph {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addDirectedEdge(0, 1);
        graph.addDirectedEdge(0, 2);
        graph.addDirectedEdge(0, 3);
        graph.addDirectedEdge(2, 4);
        graph.addDirectedEdge(4, 0);
        System.out.println(isCyclic(graph));
    }

    public static boolean isCyclic(Graph graph) {
        Map<Integer, Boolean> visited = new HashMap<>();
        Map<Integer, Boolean> recursionStack = new HashMap<>();
        for (Integer vertex : graph.adjacencyMap.keySet()) {
            if (isCyclicUtil(vertex, visited, recursionStack, graph)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCyclicUtil(int vertex, Map<Integer, Boolean> visited, Map<Integer, Boolean> recursionStack, Graph graph) {
        if (recursionStack.get(vertex) != null && recursionStack.get(vertex)) {
            return true;
        }
        if (visited.get(vertex) != null && visited.get(vertex)) {
            return false;
        }
        visited.put(vertex, true);
        recursionStack.put(vertex, true);
        List<Integer> edges = graph.adjacencyMap.get(vertex);
        if (edges != null && !edges.isEmpty()) {
            for (Integer edge : edges) {
                if (isCyclicUtil(edge, visited, recursionStack, graph)) {
                    return true;
                }
            }
        }
        recursionStack.put(vertex, false);
        return false;
    }
}

