package com.scaler.arrays;

public class MaxPossibleSum {
    public static void main(String[] args) {
        System.out.println(MaxPossibleSum.solve(new int[]{1,3,4,2,5,0}, 3));
    }

    public static int solve(int[] A, int B) {
        if(B>A.length) return 0;
        int sum = 0, max = 0;
        for(int i=0;i<B;i++){
            sum=sum+A[i];
        }
        max = sum;
        if(B==A.length) return sum;
        for(int j=0;j<B;j++){
            sum = sum - A[B-1-j] + A[A.length-j-1];
            max = Math.max(max, sum);
        }
        return max;
    }
}
