package com.scaler.linkedlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    int capacity = 0;
    Map<Integer,Integer> map = new HashMap<>();
    LinkedList<Integer> order = new LinkedList<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        order.remove((Integer)key);
        order.addFirst(key);
        return map.get(key);
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            order.remove((Integer) key);
            order.addFirst(key);
            return;
        }
        if(capacity == order.size()){
            Integer tail = order.removeLast();
            map.remove(tail);
        }
        order.remove((Integer) key);
        order.addFirst(key);
        map.put(key,value);
    }



    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.set(2,6);
        System.out.println(cache.get(1));
        cache.set(1,5);cache.set(1,2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}

