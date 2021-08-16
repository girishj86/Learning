package com.learning.dsa.arrays;

import java.util.Arrays;

public class ThreeLargestElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(threeLargestNumbers(new int[]{-4,-1,-2,-3})));
    }

    public static int[] threeLargestNumbers(int arr[]) {
        if (arr.length < 3) {
            return null;
        }
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > firstLargest) {
                thirdLargest = secondLargest;
                secondLargest = firstLargest;
                firstLargest = num;
            } else if (num > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = num;
            } else if (num > thirdLargest) {
                thirdLargest = num;
            }

        }
        int[] result = new int[3];
        result[0] = firstLargest;
        result[1] = secondLargest;
        result[2] = thirdLargest;
        return result;
    }
}
