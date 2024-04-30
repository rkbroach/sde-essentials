package algorithms.linkedList;

public class FloydsAlgo {

    public static void main(String[] args) {

    }

    public static boolean hasCycle(Node head) {

        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next; // runs at 2x
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;

    }

    public static int lengthOfCycle(Node head) {
        if (head == null) {
            return 0;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                // Cycle exists
                Node iterator = slow;
                int count = 0;

                // Count no. of steps in a loop
                do {
                    iterator = iterator.next;
                    count++;
                } while (iterator != slow);

                return count;
            }
        }

        return 0;

    }

    public Node startOfCycle(Node head) {

        if (head == null) {
            return head;
        }

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // cycle exists
            if (fast == slow) {
                // reset slow to beginning
                slow = head;
                // move slow and fast at same pace until they meet again
                // the node where they meet is the starting point of the cycle.
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        // cycle doesn't exist
        return null;

    }

    public Node startOfCycleIntuitive(Node head) {

        if (head == null) {
            return head;
        }

        Node fast = head;
        Node slow = head;

        int cycleSize = 0;

        // Find cycle existence using Floyd's algo
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                // cycle exists, find size
                Node iterator = slow;
                do {
                    iterator = iterator.next;
                    cycleSize++;
                } while (iterator != slow);
                break;
            }
        }

        // cycle doesn't exist
        if (cycleSize == 0) {
            return null;
        }

        // find start node
        Node first = head;
        Node second = head;

        while (cycleSize > 0) {
            second = second.next;
            cycleSize--;
        }

        // keep moving first and second until they meet at cycle start
        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return first;

    }

    static class Node {
        int val;
        Node next;
    }

}
