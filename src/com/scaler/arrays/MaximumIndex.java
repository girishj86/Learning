package com.scaler.arrays;

import java.util.Arrays;

public class MaximumIndex {
    public static void main(String[] args) {
        int[] a = {10,3,8,6,12,4,1,9};
        System.out.println(Arrays.toString(a));
        System.out.println(maximumIndex(a));
    }

    private static int maximumIndex(int a[]){
        int n = a.length;
        int[] lMin = new int[n];
        int[] rMax = new int[n];
        lMin[0] = a[0];
        for(int i=1;i<n;i++){
            lMin[i] = Math.min(lMin[i-1], a[i]);
        }
        System.out.println(Arrays.toString(lMin));
        rMax[n-1] = a[n-1];
        for(int i=n-2;i>=0;i--){
            rMax[i] = Math.max(rMax[i+1], a[i]);
        }
        System.out.println(Arrays.toString(rMax));
        int mDiff = 0;
        for(int i=0,j=0;i<n && j<n;){
            if(lMin[i] <= rMax[j]){
                mDiff = Math.max(mDiff, j-i);
                System.out.println("MaxDiff="+mDiff+", j="+j+",i="+i);
                j++;
            } else {
                i++;
            }
        }
        return mDiff;
    }
}
