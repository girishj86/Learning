package com.scaler.hashing;

import java.util.*;

public class ZeroSubArraySumCount {
    public static void main(String[] args) {
        long[] arr = new long[]{0, 0, 5, 5, 0, 0};
        System.out.println(Arrays.toString(arr));
        System.out.println(findSubArray(arr, arr.length));
    }

    public static long findSubArray(long[] arr, int n) {
        HashMap<Long, List<Integer>> frq = new HashMap<>();
        int result = 0;
        long[] pSum = new long[n];
        pSum[0] = arr[0];
        for(int i=1;i<n;i++){
            pSum[i] = pSum[i-1]+arr[i];
        }
        for (int i = 0; i < n; i++) {
            if (pSum[i] == 0) {
                result++;
            }
            if (frq.containsKey(pSum[i])) {
                List<Integer> indices = frq.get(pSum[i]);
                indices.add(i);
                frq.put(pSum[i], indices);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                frq.put(pSum[i], indices);
            }
        }
        for(Map.Entry<Long,List<Integer>> entry: frq.entrySet()){
            int size = entry.getValue().size();
            result = result + (size * (size-1) / 2);
        }
        return result;
    }
}
