package com.learning.dsa.arrays;

import java.util.Arrays;

public class EqulibriumArray {

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 1, 2};
        A = new int[]{7, 8, 3, 2, 4, 5, 4};
        //{7,15,18,20,24,29,33}
        //A = new int[]{4, -2, 1, 1};
        System.out.println(Arrays.toString(A));
        System.out.println(EqulibriumArray.findEquilibriumArray(A));
        System.out.println(findEquilibriumArrayUsingSuffixSum(A));
    }

    public static int findEquilibriumArray(int[] A) {
        int n = A.length;
        long[] pfSum = new long[n];
        pfSum[0] = A[0];
        for (int i = 1; i < n; i++) {
            pfSum[i] = pfSum[i - 1] + A[i];
        }
        for (int i = 0; i < n; i++) {
            long lSum, rSum;
            if (i == 0) {
                lSum = 0;
                rSum = pfSum[n - 1] - pfSum[i];
            } else if (i == n - 1) {
                lSum = pfSum[i - 1];
                rSum = 0;
            } else {
                lSum = pfSum[i - 1];
                rSum = pfSum[n - 1] - pfSum[i];
            }
            if (lSum == rSum) return i;
        }
        return -1;
    }

    static int findEquilibriumArrayUsingSuffixSum(int[] A) {
        int n = A.length;
        long[] pfSum = new long[A.length], sfSum = new long[A.length];
        pfSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            pfSum[i] = pfSum[i - 1] + A[i];
        }
        sfSum[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sfSum[i] = sfSum[i + 1] + A[i];
        }
        for (int i = 0; i < n - 1; i++) {
            long lSum, rSum;
            if (i == 0) {
                lSum = 0;
                rSum = sfSum[i + 1];
            } else if (i == n - 1) {
                lSum = pfSum[i - 1];
                rSum = 0;
            } else {
                lSum = pfSum[i - 1];
                rSum = sfSum[i + 1];
            }
            if (lSum == rSum) {
                return i;
            }
        }
        return -1;
    }
}

