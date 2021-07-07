package com.learning.dsa.arrays;

import java.util.Arrays;

public class SmallestDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
		Arrays.parallelSort(arrayOne);
		Arrays.parallelSort(arrayTwo);
		int arrayOneLength = arrayOne.length-1;
		int arrayTwoLength = arrayTwo.length-1;
		int arrayLength = Math.min(arrayOneLength, arrayOneLength);
		
		int smallestDifference = 0;
		int i=0,j=0;
		while( i<arrayLength && j<arrayLength) {
			if(Math.abs(arrayOne[i]-arrayTwo[j]) == 0) {
				return new int[] {arrayOne[i],arrayTwo[j]};
			}
		}
		
		return new int[] {};
	}
}
