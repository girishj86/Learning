package com.scaler.arrays.matrix;

public class MaximumSubmatrixSum {
    public static void main(String[] args) {
        int[][] A = new int[3][3];
        A[0]=new int[]{1,2,3};
        A[1]=new int[]{4,5,6};
        A[2]=new int[]{7,8,9};
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length;j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(findMaximumSubmatrixSum(A));
    }

    public static long findMaximumSubmatrixSum(int[][] A) {
        int n = A.length, m = A[0].length;
        long maxSum = Long.MIN_VALUE;
        int end = m;
        for(int start = 0; start < end ; start++){
            long[] sum = new long[n];
            for(int i = start ; i < m; i++){
                for(int j = 0; j < n; j++){
                    sum[j] = sum[j] + A[j][i];
                }
                long max = findMaxUsingKadanes(sum);
                maxSum = Math.max(maxSum, max);
            }
        }
        return maxSum;
    }

    public static long findMaxUsingKadanes(long[] arr){
        long max = Long.MIN_VALUE;
        long sum = 0;
        for(int i = 0 ; i < arr.length; i++){
            sum += arr[i];
            if(sum > max){
                max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}
