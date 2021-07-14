package com.learning.dsa.arrays;

public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
    }

    public static int maxSubArray(int[] a) {
        int max_till_now = Integer.MIN_VALUE, max_end_now = 0;
        int start = 0, end = 0, s = 0;
        for (int i = 0; i < a.length; i++) {
            max_end_now = max_end_now + a[i];
            if(max_till_now < max_end_now){
                max_till_now = max_end_now;
                start = s;
                end = i;
            }
            if (max_end_now < 0) {
                max_end_now = 0;
                s = i+1;
            }
        }
        System.out.println(start+" "+end);
        return max_till_now;
    }
}
