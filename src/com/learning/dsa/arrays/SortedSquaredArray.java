package com.learning.dsa.arrays;

import java.util.Arrays;

public class SortedSquaredArray {

	public static void main(String[] args) {
		int[] array = { -10, -5, 0, 5, 10 };
		System.out.println(Arrays.toString(sortedSquaredArray(array)));
	}

	public static int[] sortedSquaredArray(int[] array) {
		if (array.length == 0) {
			return array;
		}
		if (array.length == 1) {
			array[0] = array[0] * array[0];
			return array;
		}
		int i = 0, j = array.length - 1, k = array.length - 1;
		int[] result = new int[array.length];
		while (i <= j) {
			if (Math.abs(array[i]) > Math.abs(array[j])) {
				result[k--] = array[i] * array[i];
				i++;
			} else {
				result[k--] = array[j] * array[j];
				j--;
			}
		}
		return result;
	}
}
