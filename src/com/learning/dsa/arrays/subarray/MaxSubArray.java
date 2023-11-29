package com.learning.dsa.arrays.subarray;

public class MaxSubArray {
    public static void main(String[] args) {
        /* Given an array Arr[] of N integers.
           Find the contiguous sub-array(containing at least one number)
           which has the maximum sum and return its sum */
        System.out.println(maxSubArray(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
        System.out.println(maxSubArrayBF(new int[]{-9, -5, 3,4,7,-8}));
    }

    public static int maxSubArray(int[] a) {
        int max = Integer.MIN_VALUE, sum = 0;
        int start = 0, end = 0, s = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            if (max < sum) {
                max = sum;
                start = s;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
                s = i + 1;
            }
        }
        System.out.println(start + " " + end);
        return max;
    }

    public static int maxSubArrayBF(int[] a) {
        int max = Integer.MIN_VALUE, start = -1, end = -1;
        for (int i = 0; i < a.length; i++) {
            int curSum = 0;
            for (int j = i; j < a.length; j++) {
                curSum = curSum + a[j];
                if (max < curSum) {
                    max = curSum;
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println(start+" "+end);
        return max;
    }
}
