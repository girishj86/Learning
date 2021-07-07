package com.learning.dsa.linkedlist;

import com.learning.dsa.linkedlist.common.SingleListNode;

public class MergeSortedList {

    public static void main(String[] args) {
        SingleListNode l1 = new SingleListNode(1);
        l1.next = new SingleListNode(2);
        l1.next.next = new SingleListNode(4);

        SingleListNode l2 = new SingleListNode(1);
        l2.next = new SingleListNode(3);
        l2.next.next = new SingleListNode(4);

        SingleListNode result = mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.print(result.data + " --> ");
            result = result.next;
        }
    }

    public static SingleListNode mergeTwoLists(SingleListNode l1, SingleListNode l2) {
        SingleListNode head = new SingleListNode(0);
        SingleListNode p = head;

        SingleListNode p1 = l1;
        SingleListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.data < p2.data) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return head.next;
    }
}



