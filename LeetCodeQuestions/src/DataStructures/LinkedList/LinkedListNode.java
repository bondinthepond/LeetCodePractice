package DataStructures.LinkedList;

public class LinkedListNode {
        int val;
        public LinkedListNode next;
        LinkedListNode() {}
        LinkedListNode(int val) { this.val = val; }
        LinkedListNode(int val, LinkedListNode next) {this.val = val; this.next = next; }
    }