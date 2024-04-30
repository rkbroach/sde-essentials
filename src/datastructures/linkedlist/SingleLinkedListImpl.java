package datastructures.linkedlist;

public class SingleLinkedListImpl {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        LinkedList ll = new LinkedList();

        for (int item : arr) {
            ll.addLast(item); // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> END
        }

        System.out.print("A: ");
        ll.display(); // A

        ll.addFirst(10); // 10 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> END
        ll.addFirst(11); // 11 -> 10 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> END
        System.out.print("B: ");
        ll.display();

        ll.add(4, 13); // 11 -> 10 -> 1 -> 2 -> 3 -> 13 -> 4 -> 5 -> 6 -> 7 -> END
        System.out.print("C: ");
        ll.display();

        ll.deleteFirst(); // 10 -> 1 -> 2 -> 13 -> 3 -> 4 -> 5 -> 6 -> 7 -> END
        ll.deleteFirst(); // 1 -> 2 -> 13 -> 3 -> 4 -> 5 -> 6 -> 7 -> END
        System.out.print("D: ");
        ll.display();

        ll.deleteLast(); // 1 -> 2 -> 13 -> 3 -> 4 -> 5 -> 6 -> END
        System.out.print("E: ");
        ll.display();

        System.out.print("F: ");
        System.out.println(ll.getFirst()); // 1
        System.out.print("G: ");
        System.out.println(ll.getLast()); // 6

        System.out.print("H: ");
        System.out.println(ll.getValue(4));

        System.out.print("I: ");
        System.out.println(ll.delete(2));

        System.out.print("J: ");
        ll.display();
    }

    // Static class
    public static class LinkedList {
        private Node head;
        private Node tail;
        private int size;

        // Constructor creating an empty linked list
        public LinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public LinkedList(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                addLast(arr[i]);
            }
        }

        public static class Node {
            private int value;
            private Node next;

            public Node(int value) {
                this.value = value;
                this.next = null;
            }

            public Node(int value, Node next) {
                this.value = value;
                this.next = next;
            }


        }

        /* GET */
        // Helper function to get the node at a given index
        Node getNodeAt(int index) {
            // check if index is valid
            if (index < 0 || index >= this.size) {
                return null;
            }

            if (index == 0) {
                return this.head;
            }

            if (index == size - 1) {
                return this.tail;
            }

            // iterate
            Node iterator = this.head;
            for (int i = 0; i < index && iterator != null; i++) {
                iterator = iterator.next;
            }
            return iterator;
        }

        int getFirst() {
            return this.head.value;
        }

        int getLast() {
            return this.tail.value;
        }

        int getValue(int index) {
            Node node = getNodeAt(index);
            return node != null ? node.value : -1;
        }

        /* Add */
        public void addFirst(int val) {
            Node node = new Node(val, this.head);

            // update head
            this.head = node;

            // update tail if Linked List is empty
            if (this.tail == null) {
                this.tail = this.head;
            }

            // Increase the size of the list
            this.size++;
        }

        public void addLast(int val) {
            // If the list was empty, then head is also the this.tail
            if (this.tail == null) {
                addFirst(val);
                return;
            }

            Node node = new Node(val);
            this.tail.next = node;
            this.tail = node;

            this.size++;
        }

        public void add(int index, int val) {

            checkPositionIndex(index);

            // Insert first
            if (index == 0) {
                addFirst(val);
                return;
            }

            // Insert last
            if (index == this.size) {
                addLast(val);
                return;
            }

            // Insert in middle
            Node preNode = getNodeAt(index - 1);
            Node node = new Node(val, preNode.next);
            preNode.next = node;
            this.size++;
        }

        // Recursive insert and add used when Size and Tail are not available
        public void addRec(int index, int value) {
            this.head = addRec(index, value, this.head);
        }

        private Node addRec(int index, int value, Node currNode) {

            if (index == 0) {
                Node node = new Node(value, currNode);
                size++;
                return node;
            }

            currNode.next = addRec(index--, value, currNode.next);
            return currNode;

        }


        /* Delete */

        public int deleteFirst() {

            if (this.size == 0) {
                System.out.println("List is empty");
                return -1;
            }

            int val = this.head.value;
            this.head = this.head.next;

            if (this.head == null) {
                this.tail = null;
            }

            this.size--;
            return val;
        }

        public int deleteLast() {
            if (this.size <= 1) {
                deleteFirst();
            }

            Node secondLast = getNodeAt(this.size - 2);
            int val = this.tail.value;

            this.tail = secondLast;
            this.tail.next = null;

            this.size--;

            return val;

        }

        int delete(int index) {
            if (index == 0) {
                deleteFirst();
            }

            if (index == this.size - 1) {
                deleteLast();
            }

            Node prev = getNodeAt(index - 1);

            int value = prev.next.value;
            prev.next = prev.next.next;

            this.size--;
            return value;
        }

        /* Display */

        public void display() {
            Node iterator = this.head;

            while (iterator != null) {
                System.out.print(iterator.value + " -> ");
                iterator = iterator.next; // keep moving forward
            }
            System.out.println("END");
        }

        private void checkPositionIndex(int index) {
            if (!isPositionIndex(index)) {
                throw new IndexOutOfBoundsException();
            }
        }

        private boolean isPositionIndex(int index) {
            return index >= 0 && index <= this.size;
        }
    }
}
