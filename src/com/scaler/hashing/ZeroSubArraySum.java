package com.scaler.hashing;

import java.util.*;

public class ZeroSubArraySum {
    public static void main(String[] args) {
        //System.out.println(solve(Arrays.asList(1,-1)));
        //int[] arr = {1, 4, -2, -2, 5, -4, 3};
        int[] arr = {4,2,-3,1,6};
        System.out.println(Arrays.toString(arr));
        System.out.println(findsum(arr, arr.length));
    }
    public static int solve(List<Integer> A) {
        if(A == null || A.size() == 0 || A.size() == 1){
            return 0;
        }
        List<Integer> pSum = new ArrayList<>(A);
        pSum.set(0, A.get(0));
        for(int i=1;i<A.size();i++){
            if(pSum.get(i-1) + A.get(i) == 0){
                return 1;
            }
            pSum.set(i,pSum.get(i-1) + A.get(i));
        }
        Set<Integer> frqMap = new HashSet<>();
        for(int i=0;i<pSum.size();i++){
            if(!frqMap.add(pSum.get(i))){
                return 1;
            }
        }
        return 0;
    }

    private static boolean findsum(int arr[],int n)
    {
        int[] pSum = new int[n];
        pSum[0] = arr[0];
        for(int i=1;i<n;i++){
            pSum[i] = pSum[i-1]+arr[i];
        }
        System.out.println(Arrays.toString(pSum));
        Map<Integer,Integer> frq = new HashMap<>();
        for(int i=0;i<n;i++){
            frq.put(pSum[i],frq.getOrDefault(pSum[i],0)+1);
        }
        System.out.println(frq);
        if(frq.containsKey(0)) return true;
        for(int i=0;i<n;i++){
            if(frq.get(pSum[i]) > 1){
                return true;
            }
        }
        return false;
    }
}
