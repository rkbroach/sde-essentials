package datastructures.linkedlist;

public class CircularLinkedListImpl {

    public static class CircularLinkedList {
        Node head;
        Node tail;

        CircularLinkedList() {
            this.head = null;
            this.tail = null;
        }

        private class Node {
            int value;
            Node next;

            Node(int value) {
                this.value = value;
                this.next = null;
            }
        }

    }

    public static void main(String[] args) {

    }
}
