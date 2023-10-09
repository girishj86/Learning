package com.scaler.linkedlist;

public class PalindromeList {
    public static void main(String[] args) {
        ListNode A = prepareLinkedList(new int[]{45,50,45,28,43,7,21,45,50,45});
        System.out.println(lPalin(A));
    }

    public static int lPalin(ListNode A) {
        if(A==null) return 0;
        if(A.next == null) return 1;
        if(A.next.next == null){
            if(A.val == A.next.val) {
                return 1;
            } else {
                return 0;
            }
        }
        ListNode slow = A, fast = A.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode sHead = slow;
        ListNode prev = null, cur = sHead, next = sHead;
        while(next != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        sHead = prev;
        ListNode temp1 = A, temp2 = sHead;
        while(temp1 != null && temp2 != null){
            if(temp1.val != temp2.val){
                return 0;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return 1;
    }

    private static ListNode prepareLinkedList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode tmp = head;
       for(int i=1;i<arr.length;i++){
           tmp.next = new ListNode(arr[i]);
           tmp = tmp.next;
       }
       return head;
    }

}
