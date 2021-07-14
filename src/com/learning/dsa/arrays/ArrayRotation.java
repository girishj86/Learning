package com.learning.dsa.arrays;

import java.util.Arrays;

public class ArrayRotation {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(leftRotateOnce(new int[] {1,2,3,4,5})));
        System.out.println(Arrays.toString(leftRotateNTimes(new int[] {1,2,3,4,5},2)));
        System.out.println(Arrays.toString(leftRotateWithReverse(new int[] {1,2,3,4,5},1)));
    }

    public static int[] leftRotateOnce(int[] arr){
        int temp = arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = temp;
        return arr;
    }

    public static int[] leftRotateNTimes(int[] arr, int n){
        //{1,2,3,4,5}
        //{3,4,5,1,2}
        int[] temp = new int[n];
        for(int i=0;i<n;i++){
            temp[i] = arr[i];
        }
        //System.out.println(Arrays.toString(temp));
        for(int i=0;i<arr.length-n;i++){
            arr[i] = arr[i+n];
        }
        //System.out.println(Arrays.toString(arr));
        int j=0;
        for(int i=arr.length-n;i<arr.length;i++){
            arr[i] = temp[j++];
        }
        return arr;
    }
    
    public static int[] leftRotateWithReverse(int[] arr, int n) {
    	reverseArray(arr, 0, n);
    	reverseArray(arr,n,arr.length);
    	reverseArray(arr,0,arr.length);
    	return arr;
    	
    }

	private static void reverseArray(int[] array, int start, int end) {
		for(int i=start,j=end-1;i<j;i++,j--) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		
	}
}
