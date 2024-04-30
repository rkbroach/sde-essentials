package datastructures.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class GenericTreeImpl {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>(); // generic number of children
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1};

        Node root = null;
        ArrayDeque<Node> stack = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) { // If leaf ended
                stack.pop();
            } else {
                // Create node and set value
                Node node = new Node();
                int value = arr[i];
                node.data = value;

                // Check if root or child
                if (stack.isEmpty()) {
                    root = node;
                } else {
                    stack.peek().children.add(node);
                }

                // Push
                stack.push(node);
            }
        }
        displayGenericTree(root);
    }

    // d(10) -> knows how to print itself and its children
    // d(20), d(30)
    public static void displayGenericTree(Node node) {
        String str = node.data + " -> "; // self

        for (Node child : node.children) {
            str += String.valueOf(child.data) + " "; // children
        }

        System.out.println(str);
    }
}
