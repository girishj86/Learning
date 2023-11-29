package com.learning.dsa.hashing;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        topKFrequent(new int[]{1,1,1,2,2,3},2);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num:nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        List<Integer> keys = new ArrayList<>(freqMap.keySet());
        Collections.sort(keys, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return freqMap.get(b) - freqMap.get(a);
            }
        });
        for(int i=0;i<k;i++){
            result[i] = keys.get(i);
        }
        return result;
    }
}
