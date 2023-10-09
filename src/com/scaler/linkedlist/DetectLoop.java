package com.scaler.linkedlist;

public class DetectLoop {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(6);
        node5.next = node6;
        ListNode node7 = new ListNode(7);
        node6.next = node7;
        node7.next = node3;
        System.out.println(hasLoop(head));
        breakLoop(head);
        ListUtils.printList(head);

    }

    public static boolean hasLoop(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static ListNode breakLoop(ListNode head){
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return head;
        }
        fast = head;
        while(fast != slow){
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }
        prev.next = null;
        return head;
    }

}
