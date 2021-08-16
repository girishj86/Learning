package com.learning.dsa.arrays;

import java.util.Arrays;

public class RearrangeNegativePositive {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrange(new int[]{1,2,-1,-3,-2,-4,-5,6,-7})));
    }

    public static int[] rearrange(int[] arr){
        int i=0,j=arr.length-1;
        while(i<j){
            if(arr[i]<0 && arr[j]<0){
                i++;
            } else if(arr[i]>0 && arr[j]>0){
                j--;
            } else if(arr[i]>0 && arr[j]<0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            } else {
                i++;
                j--;
            }
        }
        return arr;
    }
}
