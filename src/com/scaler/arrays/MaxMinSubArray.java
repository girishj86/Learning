package com.scaler.arrays;

public class MaxMinSubArray {
    public static void main(String[] args) {
        System.out.println(MaxMinSubArray.solve(new int[]{834, 563, 606, 221, 165}));
    }
    public static int solve(int[] A) {
        int min = A[0], max = A[0];
        int minIndex = -1, maxIndex = -1, result = A.length+1;
        for(int i=1;i<A.length;i++){
            if(A[i]<min){
                min = A[i];
            }
            if(A[i]>max){
                max = A[i];
            }
        }
        for(int i=0;i<A.length;i++){
            if(min==A[i]){
                minIndex = i;
                if(maxIndex != -1){
                    result = Math.min(result, Math.abs(maxIndex-minIndex)+1);
                }
            }
            if(max==A[i]){
                maxIndex = i;
                if(minIndex != -1){
                    result = Math.min(result, Math.abs(maxIndex-minIndex)+1);
                }
            }
        }
        return result;

    }
}
