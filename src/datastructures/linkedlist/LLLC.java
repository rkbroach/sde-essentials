package datastructures.linkedlist;

public class LLLC {
    class MyLinkedList {
        // Linked List Node
        class ListNode {
            int val;
            ListNode next;

            ListNode(int val) {
                this.val = val;
                this.next = null;
            }
        }

        // keep track of head, tail and length of Linked List
        private ListNode head;
        private ListNode tail;
        private int length;

        public MyLinkedList() {
            // initialize
            this.head = null;
            this.tail = null;
            this.length = 0;
        }

        // helper function to get the node at a given index
        private ListNode getNode(int index) {
            // check if index is valid
            if (index < 0 || index >= this.length) return null;
            ListNode node = this.head;
            for (int i = 0; i < index && node != null; i++)
                node = node.next;
            return node;
        }

        public int get(int index) {
            ListNode node = getNode(index);
            return (node == null) ? -1 : node.val;
        }

        public void addAtHead(int val) {
            ListNode newNode = new ListNode(val);
            newNode.next = this.head;
            // update tail if Linked List is empty
            if (this.head == null) this.tail = newNode;
            // update head
            this.head = newNode;
            this.length += 1;
        }

        public void addAtTail(int val) {
            if (this.head == null) {
                addAtHead(val);
                return;
            }
            ListNode newNode = new ListNode(val);
            this.tail.next = newNode;
            // update tail
            this.tail = newNode;
            this.length += 1;
        }

        public void addAtIndex(int index, int val) {
            // check if index is valid
            if (index < 0 || index > this.length) return;
            // add at beginning of Linked List
            if (index == 0) {
                addAtHead(val);
                return;
            }
            // add at end of Linked List
            if (index == this.length) {
                addAtTail(val);
                return;
            }
            ListNode node = getNode(index - 1);
            if (node == null) return;
            ListNode newNode = new ListNode(val);
            newNode.next = node.next;
            node.next = newNode;
            this.length += 1;
        }

        public void deleteAtIndex(int index) {
            // check if index is valid
            if (index < 0 || index >= this.length) return;
            // delete at beginning of Linked List
            if (index == 0) {
                this.head = this.head.next;
                this.length -= 1;
                return;
            }
            ListNode node = getNode(index - 1);
            if (node == null || node.next == null) return;
            node.next = node.next.next;
            // update tail if deleting at end of Linked List
            if (node.next == null) this.tail = node;
            this.length -= 1;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
