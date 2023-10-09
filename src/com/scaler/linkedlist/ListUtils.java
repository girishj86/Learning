package com.scaler.linkedlist;

public class ListUtils {
    public static void printList(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+" --> ");
            if(temp.next == null){
                System.out.print("null");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
