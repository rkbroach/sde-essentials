package problems.linkedList;

/*
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 * Time: O(n) ; smaller list
 * Space: O(1)
 * */
public class LC21_MergeTwoSortedLists {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4, 4, 4};

        LinkedList ll1 = new LinkedList(arr1);
        LinkedList ll2 = new LinkedList(arr2);
        display(ll1.head);
        display(ll2.head);

        display(mergeTwoLists(ll1.head, ll2.head));
    }

    public static LinkedList.Node mergeTwoLists(LinkedList.Node list1, LinkedList.Node list2) {
        LinkedList.Node dummyHead = new LinkedList.Node();
        LinkedList.Node iterator = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                // Update iterator link and move L1 forward
                iterator.next = list1;
                list1 = list1.next;
            } else {
                // Update iterator link and move L2 forward
                iterator.next = list2;
                list2 = list2.next;
            }

            // Move iterator forward
            iterator = iterator.next;
        }

        // Link remaining node chain
        iterator.next = list1 != null ? list1 : list2;

        // Skip head to head.next as head initial dummy node
        return dummyHead.next;

    }

    static void display(LinkedList.Node node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("END");
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

        static class Node {
            int val;
            Node next;

            Node() {

            }

            Node(int val) {
                this.val = val;
            }
        }
    }
}
