package com.scaler.hashing;

import java.util.HashMap;
import java.util.Map;

public class MaxDistSameElement {
    public static int findMaxDistSameElement(int[] A) {
        Map<Integer,Integer> hm = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            if(hm.containsKey(A[i])){
                max = Math.max(max, Math.abs(hm.get(A[i])-i));
            }
            hm.put(A[i], i);
        }
        return max;
    }

    public static int findMinDistSameElement(int[] A) {
        Map<Integer,Integer> hm = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            if(hm.containsKey(A[i])){
                min = Math.min(min, Math.abs(hm.get(A[i])-i));
            }
            hm.put(A[i], i);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] A = {7, 1, 3, 4, 1, 7};
        System.out.println(findMaxDistSameElement(A));
        System.out.println(findMinDistSameElement(A));
    }
}
