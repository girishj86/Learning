package com.learning.dsa.arrays;

import java.util.Arrays;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {3,7,2,4,5};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pfxProductArray = new int[n];
        int[] sfxProductArray = new int[n];
        int[] resultArray = new int[n];
        pfxProductArray[0] = 1;
        sfxProductArray[n-1] = 1;
        for(int i=1;i<n;i++){
            pfxProductArray[i] = pfxProductArray[i-1] * nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            sfxProductArray[i] = sfxProductArray[i+1] * nums[i+1];
        }

        for(int i=0;i<n;i++){
            resultArray[i] = pfxProductArray[i] * sfxProductArray[i];
        }
        return resultArray;
    }
}
