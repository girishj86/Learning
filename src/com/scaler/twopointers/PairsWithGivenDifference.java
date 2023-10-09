package com.scaler.twopointers;

import java.util.*;

public class PairsWithGivenDifference {
    public static void main(String[] args) {
        System.out.println(pairsWithGivenDiff(new int[]{1, 1, 1, 2, 2}, 0));
    }

    public static int pairsWithGivenDiff(int[] A, int B){
        int count = 0;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<A.length;i++){
            hm.put(A[i], hm.getOrDefault(A[i],0)+1);
        }
        Set<Integer> hs = new HashSet<>();
        for(int i=0;i<A.length;i++){
            hs.add(A[i]);
        }
        List<Integer> list = new ArrayList<>(hs);
        for(int i=0;i<list.size();i++){
            if(B==0){
                if(hm.get(list.get(i))>1){
                    count++;
                }
            } else if(hm.containsKey(B+list.get(i))){
                count++;
            }
        }
        return count;
    }

}
