package com.learning.dsa.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumSolution {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		Arrays.stream(twoSumUsingMap(nums, 9)).forEach(s -> System.out.print(s + " "));
		Arrays.stream(twoSumUsingSorting(nums, 13)).forEach(s -> System.out.print(s + " "));

	}

	public static int[] twoSumUsingMap(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				int[] solution = new int[2];
				solution[0] = map.get(target - nums[i]);
				solution[1] = i;
				return solution;
			} else {
				map.put(nums[i], i);
			}
		}
		return new int[0];
	}
	
	public static int[] twoSumUsingSorting(int[] nums, int target) {
		Arrays.sort(nums);
		int left = 0, right = nums.length-1;
		while(left < right) {
			if(nums[left]+nums[right] == target) {
				int[] solution = new int[2];
				solution[0] = left;
				solution[1] = right;
				return solution;
			}
			if(nums[left]+nums[right] > target) {
				right--;
			} else {
				left++;
			}
		}
		return new int[0];
	}

}
