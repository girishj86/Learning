package com.learning.dsa.searching;

import java.util.Arrays;

public class MaxAndSecondMax {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxAndSecondMax(new int[]{3, 6, 5, 10, 9, 7, 8,9})));
    }

    public static int[] maxAndSecondMax(int[] array) {
        int max = Integer.MIN_VALUE, second_max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(array[i], max);
            if (array[i] < max && array[i] > second_max) {
                second_max = array[i];
            }
        }
        return new int[]{max, second_max};
    }
}
