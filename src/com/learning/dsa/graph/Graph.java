package com.learning.dsa.graph;

import java.util.*;

public class Graph {

    Map<Integer, List<Integer>> adjacencyMap;

    public Graph(int size) {
        this.adjacencyMap = new LinkedHashMap<>(size);
    }

    public void addUndirectedEdge(int u, int v) {
        if (this.adjacencyMap.get(u) == null) {
            this.adjacencyMap.put(u, new ArrayList<>());
        }
        this.adjacencyMap.get(u).add(v);
        if (this.adjacencyMap.get(v) == null) {
            this.adjacencyMap.put(v, new ArrayList<>());
        }
        this.adjacencyMap.get(v).add(u);
    }

    public void addDirectedEdge(int u, int v) {
        if (this.adjacencyMap.get(u) == null) {
            this.adjacencyMap.put(u, new ArrayList<>());
        }
        this.adjacencyMap.get(u).add(v);
    }

    public void printGraph() {
        for (Map.Entry entry : this.adjacencyMap.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }

    public void breadthFirstSearch(int root) {
        System.out.println("Breadth First Search");
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            if (visited.get(vertex) == null || !visited.get(vertex)) {
                System.out.print(vertex + " ");
                for(Integer edge:this.adjacencyMap.get(vertex)){
                    queue.offer(edge);
                }
            }
            visited.put(vertex,true);
        }
        System.out.println();
    }

    public void depthFirstSearch(int root) {
        System.out.println("Depth First Search");
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Integer vertex = stack.pop();
            if (visited.get(vertex) == null || !visited.get(vertex)) {
                System.out.print(vertex + " ");
                for(Integer edge:this.adjacencyMap.get(vertex)){
                    stack.push(edge);
                }
            }
            visited.put(vertex,true);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(2, 4);

        graph.printGraph();
        graph.breadthFirstSearch(4);
        graph.depthFirstSearch(4);
    }

}
