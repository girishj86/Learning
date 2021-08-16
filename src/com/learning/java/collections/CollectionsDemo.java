package com.learning.java.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CollectionsDemo {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"one");
        Map<Integer,String> unmodifiableMap = Collections.unmodifiableMap(map);
        unmodifiableMap.put(2,"two");
        Map<Integer,String> synchronizedMap = Collections.synchronizedMap(map);
        synchronizedMap.put(2,"two");
    }
}
