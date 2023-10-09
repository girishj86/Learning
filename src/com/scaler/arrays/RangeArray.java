package com.scaler.arrays;

import java.util.Arrays;

public class RangeArray {
    public static void main(String[] args) {
        int[] A = new int[]{100,11,21,3};
        int[][] B = new int[][]{{2,4},{1,3}};
        System.out.println(Arrays.toString(solve(A,B)));
    }

    public static int[] solve(int[] A, int[][] B) {
        int[] countArray = new int[A.length];
        countArray[0]= (A[0]>10)? 1 : 0;
        for(int i=1;i<A.length;i++){
            countArray[i] = countArray[i-1] + ((A[i]>10)? 1 : 0);
        }
        System.out.println(Arrays.toString(countArray));
        int[] result = new int[B.length];
        for(int j=0;j<B.length;j++){
            int start = B[j][0]-1;
            int end = B[j][1]-1;
            if(start>0)
                result[j] = countArray[end]-countArray[start-1];
            else
                result[j] = countArray[end];

        }
        return result;
    }
}
