package linkedList;

public class LC876_MidOfLinkedList {

    // Single pass using fast and slow pointer, O(n)
    public Node middleNode1Pass(Node head) {
        Node slow = head;
        Node fast = head;

        // let fast pointer reach end of list at 2x speed
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow pointer at 1x speed would have reached only the middle
        return slow;
    }


    // 2 pass approach, O(n)
    public Node middleNode2Pass(Node head) {

        int size = 0;

        Node iterator = head;

        while (iterator != null) {
            iterator = iterator.next;
            size++;
        }

        int midIndex = size / 2;

        // reset 
        iterator = head;
        while (midIndex > 0) {
            iterator = iterator.next;
            midIndex--;
        }

        return iterator;

    }

    class Node {
        int value;
        Node next;
    }
}
