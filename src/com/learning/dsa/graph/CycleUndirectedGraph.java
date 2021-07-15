package com.learning.dsa.graph;

import java.util.*;

public class CycleUndirectedGraph {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(2, 4);
        graph.addUndirectedEdge(4, 0);
        graph.printGraph();
        System.out.println(isCycle(graph));
    }

    public static boolean isCycle(Graph graph) {
        //visited array
        Map<Integer, Boolean> visited = new HashMap<>();

        //do DFS, from each vertex
        Set<Integer> vertices = graph.adjacencyMap.keySet();
        if (vertices != null && !vertices.isEmpty()) {
            for (Integer vertex : vertices) {
                if (visited.get(vertex) == null || !visited.get(vertex)) {
                    if (isCycleUtil(vertex, visited, -1, graph)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(int currVertex, Map<Integer, Boolean> visited, int parent, Graph graph) {

        //add this vertex to visited vertex
        visited.put(currVertex, true);

        //visit neighbors except its direct parent
        List<Integer> edges = graph.adjacencyMap.get(currVertex);
        if (edges != null && !edges.isEmpty()) {
            for (int vertex : edges) {
                //check the adjacent vertex from current vertex
                if (vertex != parent) {
                    //if destination vertex is not its direct parent then
                    if (visited.get(vertex) != null && visited.get(vertex)) {
                        //if here means this destination vertex is already visited
                        //means cycle has been detected
                        return true;
                    } else {
                        //recursion from destination node
                        if (isCycleUtil(vertex, visited, currVertex, graph)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

