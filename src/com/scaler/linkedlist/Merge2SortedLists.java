package com.scaler.linkedlist;

public class Merge2SortedLists {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        head1.next = node3;
        ListNode node5 = new ListNode(5);
        node3.next = node5;
        ListNode node7 = new ListNode(7);
        node5.next = node7;
        ListNode head2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        head2.next = node4;
        ListNode node6 = new ListNode(6);
        node4.next = node6;
        ListNode node8 = new ListNode(8);
        node6.next = node8;
        ListNode node10 = new ListNode(10);
        node8.next = node10;
        ListNode node12 = new ListNode(12);
        node10.next = node12;
        ListUtils.printList(head1);
        ListUtils.printList(head2);
        ListUtils.printList(mergeTwoSortedLists(head1,head2));
    }

    public static ListNode mergeTwoSortedLists(ListNode head1, ListNode head2){
        ListNode p1 = head1, p2 = head2, m = null;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                if(m==null){
                    m = new ListNode(p1.val);
                    continue;
                } else {
                    m.next = new ListNode(p1.val);
                }
                p1 = p1.next;
            } else {
                if(m==null){
                    m = new ListNode(p2.val);
                    continue;
                } else {
                    m.next = new ListNode(p2.val);
                }
                p2 = p2.next;
            }
        }
        if(p1==null && p2!=null){
            m.next = new ListNode(p2.val);
        }
        if(p2==null && p1!=null){
            m.next = new ListNode(p1.val);
        }
        return m;
    }
}
