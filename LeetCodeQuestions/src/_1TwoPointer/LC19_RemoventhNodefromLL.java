package _1TwoPointer;

// Given the head of a linked list, remove the nth node from the end of the list and return its head. */

/* Approach - take 2 pointers
 * Pointer 1 will start from head, traverse n positions forward
 * Then take Pointer 2.
 * Pointer 2 will also start from head, and 
 * pointer 1 and pointer 2 will traverse along the list until Pointer 1 reaches last node before null
 * Now the node pointer 2 will be pointing to is the previous node of the nth node from last
 * Remove the node, point the previous node to next node
 */

import DataStructures.LinkedList.LinkedListNode;
import DataStructures.LinkedList.LinkedList;


public class LC19_RemoventhNodefromLL {

    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        LinkedListNode right = head; //pointer 1
        LinkedListNode left = head; //pointer 2

        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        if (right == null) {
            return head.next;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return head;
    }

    // Driver Code
    public static void main(String[] args) {
        int[][] inputs = {
                { 23, 89, 10, 5, 67, 39, 70, 28 },
                { 34, 53, 6, 95, 38, 28, 17, 63, 16, 76 },
                { 288, 224, 275, 390, 4, 383, 330, 60, 193 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 69, 8, 49, 106, 116, 112, 104, 129, 39, 14, 27, 12 }
        };

        int[] n = { 4, 1, 6, 9, 11 };

        for (int i = 0; i < inputs.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<Integer>();
            inputLinkedList.createLinkedList(inputs[i]);
            System.out.print((i + 1) + ".\tLinked List:\t\t");
            inputLinkedList.printListWithForwardArrow(inputLinkedList.head);
            System.out.print("\n\tn = " + n[i]);
            System.out.print("\n\tUpdated Linked List:\t");
            inputLinkedList.printListWithForwardArrow(removeNthLastNode(inputLinkedList.head, n[i]));
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}