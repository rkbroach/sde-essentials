package problems.linkedList;
/* https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

public class LC83_RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3, 4, 4};
        LinkedList ll = new LinkedList(arr);
        ll.display();
        ll.display(removeDuplicates(ll.head));
    }

    private static LinkedList.Node removeDuplicates(LinkedList.Node head) {
        if (head == null) {
            return head;
        }

        LinkedList.Node iterator = head;

        while (iterator.next != null) {
            if (iterator.val == iterator.next.val) {
                // Skip duplicate
                iterator.next = iterator.next.next;
            } else {
                // Include and continue
                iterator = iterator.next;
            }

        }

        return head;
    }

    static class LinkedList {
        Node head;

        LinkedList(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                addLast(arr[i]);
            }
        }

        void addLast(int val) {
            Node node = new Node(val);

            // empty list
            if (this.head == null) {
                this.head = node;
                return;
            }

            Node iterator = this.head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }

            iterator.next = node;
        }

        void display() {
            Node iterator = this.head;
            while (iterator != null) {
                System.out.print(iterator.val + " -> ");
                iterator = iterator.next;
            }
            System.out.println("END");
        }

        void display(Node from) {
            Node iterator = from;
            while (iterator != null) {
                System.out.print(iterator.val + " -> ");
                iterator = iterator.next;
            }
            System.out.println("END");
        }

        public static class Node {
            int val;
            Node next;

            Node() {
            }

            Node(int val) {
                this.val = val;
                this.next = null;
            }

            Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }
        }
    }


}
