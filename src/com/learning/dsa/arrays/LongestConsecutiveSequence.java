package com.learning.dsa.arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        int count = 1, maxCount = Integer.MIN_VALUE;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int num : nums) {
            int tmp = num;
            while (set.contains(tmp - 1)) {
                count++;
                tmp--;
            }
            maxCount = Math.max(count, maxCount);
            count = 1;
        }
        return maxCount;
    }
}
