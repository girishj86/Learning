package com.scaler.hashing;

import java.util.HashMap;

public class ArraysEqual {
    public static void main(String[] args) {
        long A[]  = new long[]{1,2,3,4,5,3,5};
        long B[]  = new long[]{1,5,3,4,5,3,2};
        System.out.println(check(A,B,7));
    }

    public static boolean check(long A[],long B[],int N)
    {
        HashMap<Long,Integer> frq = new HashMap<>();
        for(int i=0;i<N;i++){
            frq.put(A[i], frq.getOrDefault(A[i],0)+1);
        }
        for(int i=0;i<N;i++){
            if(frq.containsKey(B[i])){
                frq.put(B[i], frq.get(B[i])-1);
            } else {
                return false;
            }
        }
        for(Integer count: frq.values()){
            if(count !=0l){
                return false;
            }
        }
        return true;
    }
}
