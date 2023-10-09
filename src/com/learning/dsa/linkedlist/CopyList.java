package com.learning.dsa.linkedlist;

import com.learning.dsa.linkedlist.common.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class CopyList {
    public static void main(String[] args) {
        RandomListNode one = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        RandomListNode three = new RandomListNode(3);
        one.next = two;
        two.next = three;
        one.random = three;
        two.random = one;
        three.random = one;
        printList(one);
        System.out.println();
        printList(copyRandomListUsingHashMap(one));
    }

    public static RandomListNode copyRandomListUsingHashMap(RandomListNode head) {
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode temp = head;
        while(temp != null){
            RandomListNode newNode = new RandomListNode(temp.data);
            map.put(temp, newNode);
            temp = temp.next;
        }

        RandomListNode headA = head, tempA = head, tempB = null, headB = null;
        while(tempA != null){
            tempB = map.get(tempA);
            if(headB == null){
                headB = map.get(headA);
            }
            tempB.next = map.get(tempA.next);
            tempB.random = map.get(tempA.random);
            tempA = tempA.next;
        }

        return headB;
    }

    public static void printList(RandomListNode head){
        RandomListNode temp = head;
        while(temp != null){
            System.out.print("["+temp.data+","+temp.random.data+"] --> ");
            temp = temp.next;
        }
    }
}
