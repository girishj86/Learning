package com.scaler.arrays;

public class MaxCount {
    public static void main(String[] args) {
        int[] arr = {1,3,2,7,5,6,9,4,9};
        System.out.println(arr.length);
        int count = 0, max = arr[0];
        for(int i=1;i<arr.length;i++) {
            if(arr[i]==max){
                count++;
            } else if(arr[i] > max){
                max = arr[i];
                count=1;
            }
        }
        System.out.println(count);
    }
}
