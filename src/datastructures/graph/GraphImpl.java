package datastructures.graph;


import java.util.*;

class GraphImpl {
    private Map<Integer, List<Integer>> adjLists;
    private boolean[] visited;

    // Graph creation
    GraphImpl(int vertices) {
        adjLists = new HashMap<>();
        visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            adjLists.put(i, new LinkedList<>());
        }
    }

    // Add edges
    void addEdge(int v, int w) {
        adjLists.get(v).add(w);
    }

    // DFS traversal
    void DFS(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int neighbor : adjLists.get(v)) {
            if (!visited[neighbor]) {
                DFS(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        GraphImpl g = new GraphImpl(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal (starting from vertex 2):");
        g.DFS(2);
    }
}
