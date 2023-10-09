package com.scaler.hashing;

import java.util.*;

public class SortArrayByFrequency {
    public static void main(String[] args) {
        int[] arr = {4,5,3,3,5,5,4};
        sortByFreq(arr,arr.length);

    }

    private static ArrayList<Integer> sortByFreq(int arr[], int n){
        Map<Integer,Integer> frq = new HashMap<>();
        for(int i=0;i<n;i++){
            frq.put(arr[i], frq.getOrDefault(arr[i],0)+1);
        }
        List<Map.Entry<Integer,Integer>> frequencies = new ArrayList<>(frq.entrySet());
        Collections.sort(frequencies, Map.Entry.comparingByValue());
        Collections.reverse(frequencies);
        Collections.sort(frequencies, ((o1, o2) -> {
            int result = o2.getValue().compareTo(o1.getValue());
            if(result == 0){
                result = o1.getKey().compareTo(o2.getKey());
            }
            return result;
        }));
        System.out.println(frequencies);
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: frequencies){
            for(int i=0;i<entry.getValue();i++) {
                result.add(entry.getKey());
            }
        }
        return null;
    }
}
