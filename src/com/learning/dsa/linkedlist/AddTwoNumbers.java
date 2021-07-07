package com.learning.dsa.linkedlist;

import com.learning.dsa.linkedlist.common.SingleListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        SingleListNode l1 = new SingleListNode(2);
        l1.next = new SingleListNode(4);
        l1.next.next = new SingleListNode(3);

        SingleListNode l2 = new SingleListNode(5);
        l2.next = new SingleListNode(6);
        l2.next.next = new SingleListNode(4);

        SingleListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.data + " --> ");
            result = result.next;
        }

    }

    public static SingleListNode addTwoNumbers(SingleListNode l1, SingleListNode l2) {
        SingleListNode head = new SingleListNode(0), result = head;
        int remainder = 0;
        while (l1 != null && l2 != null) {
            int temp = l1.data+ + l2.data;
            if (remainder > 0) {
                temp = temp + remainder;
            }
            int sum = temp;
            if (temp > 9) {
                remainder = 1;
                sum = sum % 10;
            } else {
                remainder = 0;
            }
            result.next = new SingleListNode(sum);
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (remainder > 0) {
            result.next = new SingleListNode(remainder);
        }
        return head.next;
    }
}
