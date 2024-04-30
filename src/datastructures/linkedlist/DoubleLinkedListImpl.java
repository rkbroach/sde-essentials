package datastructures.linkedlist;

public class DoubleLinkedListImpl {

    public static class DoubleLinkedList {
        private Node head;
        private Node tail;
        private int size;

        public DoubleLinkedList() {
            this.size = 0;
            this.head = null;
            this.tail = null;
        }

        private class Node {
            int value;
            Node next;
            Node prev;

            public Node(int value) {
                this.value = value;
                this.next = null;
                this.prev = null;
            }

            public Node(int value, Node next, Node prev) {
                this.value = value;
                this.next = next;
                this.prev = prev;
            }
        }

        void addFirst(int val) {
            // null <- Node -> head
            Node node = new Node(val, this.head, null);

            // null <- Node <-> head
            if (this.head != null) {
                this.head.prev = node;
            }
            // null <- Node(currHead) <-> formerHead
            this.head = node;

            // update tail if Linked List is empty
            if (this.size == 0) {
                this.tail = this.head;
            }

            this.size++;
        }

        void display() {
            Node iterator = this.head;

            while (iterator != null) {
                System.out.print(iterator.value + " <-> ");
                iterator = iterator.next;
            }
            System.out.println("END");
        }

        Node getNode(int index) {
            checkIndexRange(index);

            if (index == 0) {
                return this.head;
            }

            if (index == this.size - 1) {
                return this.tail;
            }

            Node iterator = this.head;
            for (int i = 0; i < index; i++) {
                iterator = iterator.next;
            }

            return iterator;
        }

        int getNodeValue(int index) {
            return getNode(index).value;
        }

        void checkIndexRange(int index) {
            if (index < 0 || index >= this.size) {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList(); // END
        dll.display();
        dll.addFirst(1);
        dll.display();
        dll.addFirst(2);
        dll.display();
        System.out.println(dll.getNode(1).prev.value);
    }
}
