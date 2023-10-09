package com.scaler.sorting;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] input = new int[]{6,7,3,4,9,5,3,2,1,8,9,7};
        System.out.println(Arrays.toString(input));
        countSort(input);
    }

    public static int[] countSort(int[] A){
        int max = 0;
        for(int i=0;i<A.length;i++){
            max = Math.max(max,A[i]);
        }
        System.out.println(max);
        int[] frqArray = new int[max+1];
        for(int i=0;i<A.length;i++){
            frqArray[A[i]] = frqArray[A[i]] + 1;
        }
        System.out.println(Arrays.toString(frqArray));
        for(int i=0,j=0;i<frqArray.length;i++){
            if(frqArray[i] > 0){
                for(int k=0;k<frqArray[i];k++){
                    A[j++] = i;
                }
            }
        }
        System.out.println(Arrays.toString(A));
        return A;
    }
}
