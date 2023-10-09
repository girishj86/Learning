package com.scaler.arrays;

public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(MaxSubArray.maxSubarray(9, 78, new int[]{7, 1, 8, 5, 8, 5, 3, 3, 5}));
    }

    public static int maxSubarray(int A, int B, int[] C) {
        int sum = 0, maxSum = 0;
        for(int i=0;i<A;i++){
            for(int j=i;j<A;j++){
                if(sum+C[j] <= B){
                    sum = sum+C[j];
                }
            }
            maxSum = Math.max(sum, maxSum);
            sum = 0;
        }
        return maxSum;
    }
}
