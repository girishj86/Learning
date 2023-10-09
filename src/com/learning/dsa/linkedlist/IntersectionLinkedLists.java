package com.learning.dsa.linkedlist;

import com.scaler.linkedlist.ListNode;

public class IntersectionLinkedLists {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode eight = new ListNode(8);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        eight.next = four;

        System.out.println(getIntersectionNode(one, eight).val);
    }

    public static ListNode getIntersectionNode(ListNode A, ListNode B) {
        ListNode tempA = A, tempB = B;
        int lenA = 0, lenB = 0;
        while (tempA != null) {
            lenA++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            lenB++;
            tempB = tempB.next;
        }
        if (lenA > lenB) {
            tempA = A;
            tempB = B;
            int diff = lenA - lenB;
            while (diff > 0) {
                tempA = tempA.next;
                diff--;
            }
            while (tempA != tempB) {
                tempA = tempA.next;
                tempB = tempB.next;
            }
            return tempA;
        } else {
            tempA = A;
            tempB = B;
            int diff = lenB - lenA;
            while (diff > 0) {
                tempB = tempB.next;
                diff--;
            }
            while (tempA != tempB) {
                tempA = tempA.next;
                tempB = tempB.next;
            }
            return tempA;
        }
    }
}
