package com.learning.dsa.maps;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapLRUDemo {

	public static void main(String[] args) {
		LRULinkedHashMap<Integer,String> lruCache = new LRULinkedHashMap(3);
		lruCache.put(1, "ONE");
		lruCache.put(2, "TWO");
		lruCache.put(3, "THREE");
		System.out.println(lruCache);
		lruCache.put(4, "FOUR");
		lruCache.get(2);
		lruCache.put(5, "FIVE");
		System.out.println(lruCache);
	}

}

class LRULinkedHashMap<K,V> extends LinkedHashMap<K,V> {
	
	private static final long serialVersionUID = 1L;
	
	private int MAX_SIZE;
	
	public LRULinkedHashMap(int size) {
		// accessOrder must be set as true, else insertion order is considered
		super(3, 0.75f, true);
		MAX_SIZE = size;
	}

	protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return this.size() > MAX_SIZE;
    }
	
}