package com.learning.dsa.linkedlist;

import com.scaler.linkedlist.ListNode;

public class PartitionList {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode five = new ListNode(5);
        ListNode seven = new ListNode(7);
        ListNode eight = new ListNode(8);
        one.next = five;
        five.next = seven;
        seven.next = three;
        three.next = eight;
        eight.next = two;
        printList(one);
        printList(partition(one,4));
    }

    private static void printList(ListNode head) {
        while(head !=null){
            System.out.print(head.val+" --> ");
            head = head.next;
        }
        System.out.print("null\n");
    }

    public static ListNode partition(ListNode A, int B) {
        ListNode tmp = A, p1Head = new ListNode(-1), p2Head = new ListNode(-1), p1 = p1Head, p2 = p2Head;
        while (tmp != null) {
            if (tmp.val < B) {
                p1.next = tmp;
                p1 = p1.next;
            } else {
                p2.next = tmp;
                p2 = p2.next;
            }
            tmp = tmp.next;
        }
        p2.next = null;
        p1.next = p2Head.next;
        return p1Head.next;
    }
}
