package com.learning.dsa.arrays;

import java.util.Arrays;

public class WaveArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(waveArray(new int[]{10, 5, 6, 3, 2, 20, 100, 80})));
    }

    public static int[] waveArray(int[] arr){
        for(int i=0,j=1;j<arr.length;i=i+2,j=j+2){
            if(arr[j]>arr[i]){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
}
