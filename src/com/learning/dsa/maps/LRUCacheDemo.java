package com.learning.dsa.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LRUCacheDemo {

	public static void main(String[] args) {
		LRUCache<Integer, String> lruCache = new LRUCache<>(3);
		lruCache.put(1, "ONE");
		lruCache.put(2, "TWO");
		lruCache.put(3, "THREE");
		lruCache.get(1);
		lruCache.put(4, "FOUR");
		lruCache.display();
		lruCache.remove(1);
		lruCache.display();
		lruCache.put(5, "FIVE");
		lruCache.display();
	}

}

class LRUCache<K, V> {
	HashMap<K, Node> store = new HashMap<>();
	Node<K, V> head, tail;
	int capacity = 0, currentSize = 0;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public void put(K key, V value) {
		Node node = null;
		if (store.containsKey(key)) {
			node = store.get(key);
			node.value = value;
		} else {
			node = new Node();
			node.key = key;
			node.value = value;
			store.put(key, node);
		}
		if (head == null) {
			head = node;
			tail = node;
			currentSize++;
			return;
		}
		makeHeadNode(node);
		if (currentSize == capacity) {
			store.remove(tail.key);
			Node prev = tail.prev;
			prev.after = null;
			tail = prev;
		} else {
			currentSize++;
		}

	}

	private void makeHeadNode(Node node) {
		if (head == null) {
			head = node;
			return;
		}
		node.after = head;
		head.prev = node;
		head = node;
	}

	private void removeNode(Node node) {
		if (node.key.equals(head.key)) {
			head = head.after;
			head.prev = null;
			return;
		}
		if (node.key.equals(tail.key)) {
			tail = tail.prev;
			tail.after = null;
			return;
		}
		Node prev = node.prev;
		Node after = node.after;
		prev.after = after;
		after.prev = prev;
	}

	public V get(K key) {
		Node<K, V> node = null;
		if (!store.containsKey(key)) {
			return null;
		} else {
			node = store.get(key);
		}
		if (key.equals(head.key)) {
			return head.value;
		}
		removeNode(node);
		makeHeadNode(node);
		return node.value;
	}
	
	public V remove(K key) {
		if(!store.containsKey(key)) {
			return null;
		}
		Node<K,V> node = store.remove(key);
		removeNode(node);
		currentSize--;
		return node.value;
	}

	public void display() {
		System.out.println("\nHash Table Entries-----");
		Set<Map.Entry<K, Node>> entries = store.entrySet();
		for (Map.Entry<K, Node> entry : entries) {
			System.out.print("key: " + entry.getKey());
			System.out.println(", Value: " + entry.getValue().value);
		}
		System.out.println("\nHead to Tail entries");
		Node temp = head;
		while (temp != null) {
			System.out.print("[key= " + temp.key.toString() + " ,value= " + temp.value.toString() + "] --> ");
			temp = temp.after;
		}
		System.out.print(" null ");
	}
}

class Node<K, V> {
	K key;
	V value;
	Node prev, after;
}
