package datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DFSOfGraph {

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adjLi = new ArrayList<>();

        adjLi.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        adjLi.add(new ArrayList<>(Arrays.asList(0)));
        adjLi.add(new ArrayList<>(Arrays.asList(0, 4)));
        adjLi.add(new ArrayList<>(Arrays.asList(0)));
        adjLi.add(new ArrayList<>(Arrays.asList(2)));

        ArrayList<Integer> result = dfsOfGraph(V, adjLi);
        System.out.println(result);
    }

    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adjLi) {

        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;

        dfsRecursive(start, adjLi, visited, result);

        return result;
    }

    private static void dfsRecursive(int currentNode, ArrayList<ArrayList<Integer>> adjLi, boolean[] visited, ArrayList<Integer> result) {

        if (visited[currentNode]) {
            return;
        }

        visited[currentNode] = true;
        result.add(currentNode);

        // Iterate over connected nodes in DFS
        ArrayList<Integer> allConnectedNodesToCurrentNode = adjLi.get(currentNode);

        for (Integer dest : allConnectedNodesToCurrentNode) {
            if (!visited[dest]) {
                dfsRecursive(dest, adjLi, visited, result);
            }
        }
    }
}
