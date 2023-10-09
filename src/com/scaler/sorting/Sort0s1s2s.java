package com.scaler.sorting;

import java.util.Arrays;

public class Sort0s1s2s {
    public static void main(String[] args) {
        int[] A = new int[]{1,0,2,1,0,2,1,0};
        System.out.println("Input="+ Arrays.toString(A));
        System.out.println("Output="+ Arrays.toString(sortColors(A)));
    }

    public static int[] sortColors(int[] A) {
        int zeroes = 0, ones = 0, twos = A.length-1;
        while(ones <= twos){
            if(A[ones]==0){
                int temp = A[ones];
                A[ones] = A[zeroes];
                A[zeroes] = temp;
                zeroes++;ones++;
            }  else if(A[ones]==2){
                int temp = A[ones];
                A[ones] = A[twos];
                A[twos] = temp;
                twos--;
            } else ones++;
        }
        return A;
    }
}
