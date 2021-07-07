package com.learning.dsa.arrays;

import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {

	public static void main(String[] args) {
		List<Integer> array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
		List<Integer> sequence = Arrays.asList(1, 6, -1, -1);
		System.out.println(isValidSubsequence(array, sequence));

	}

	public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
	    int i = 0, j = 0, arrayLength = array.size(), sequenceLength = sequence.size();
			while (i < arrayLength) {
				if (sequence.get(j) == array.get(i)) {
					j++;
				}
				if (j == sequenceLength) {
					return true;
				}
				i++;
			}
			return false;
	}
}
