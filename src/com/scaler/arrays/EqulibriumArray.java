package com.scaler.arrays;

import java.util.Arrays;
import java.util.Set;

public class EqulibriumArray {

    public static void main(String[] args) {
        Set<Integer> a = null;
        System.out.println(EqulibriumArray.solve(new int[]{1,2,3,1,2}));
    }
    public static int solve(int[] A) {
        System.out.println(Arrays.toString(A));
        long[] pfSum = new long[A.length];
        pfSum[0] = A[0];
        for(int i=1;i<A.length;i++){
            pfSum[i]=pfSum[i-1]+A[i];
        }
        for(int i=0;i<A.length;i++){
            long lsum = -1, rsum = -1;
            if(i==0) lsum=0;
            else if(i==A.length-1) rsum=0;
            else {
                lsum = pfSum[i - 1];
                rsum = pfSum[A.length - 1] - pfSum[i];
            }
            if(lsum==rsum) return i;
        }
        return -1;
    }
}

