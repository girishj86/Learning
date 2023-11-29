package com.learning.dsa.arrays;

import java.util.HashMap;

public class TwoSumPairsCount {
    public static void main(String[] args) {
        int[] arr = {1,1,1};
        System.out.println(getPairsCount(arr,2));
    }

    public static int getPairsCount(int arr[], int k){
        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            if (m.containsKey(k - arr[i])) {
                count = count + m.get(k - arr[i]);
            }
            if (m.containsKey(arr[i])) {
                m.put(arr[i], m.get(arr[i]) + 1);
            }
            else {
                m.put(arr[i], 1);
            }
        }
        return count;
    }
}
