package com.learning.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

	public static void main(String[] args) {
		int[] array = { 12, 3, 1, 2, -6, 5, 0, -8, -1 };
		List<Integer[]> result = threeNumberSum(array, 0);
		result.stream().forEach(x -> System.out.println(Arrays.toString(x)));
	}

	public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		Arrays.sort(array);
		List<Integer[]> result = new ArrayList<>();
		for (int i = 0; i < array.length - 1; i++) {
			int left = i + 1;
			int right = array.length - 1;
			while (left < right) {
				if (targetSum == array[i] + array[left] + array[right]) {
					Integer[] triplet = { array[i], array[left], array[right] };
					result.add(triplet);
					left++;
				}
				if (targetSum > array[i] + array[left] + array[right]) {
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}
}
