package com.scaler.arrays;

import java.util.Arrays;

public class UniqueElements {
    public static void main(String[] args) {
        System.out.println(makeArrayUnique(new int[]{1, 1, 2, 2, 3}));
    }

    private static int makeArrayUnique(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] == A[i]) {
                A[i] = A[i] + 1;
                count++;
            } else if (A[i - 1] > A[i]) {
                count = count + A[i - 1] - A[i] + 1;
                A[i] = A[i - 1] + 1;
            }
        }
        System.out.println(Arrays.toString(A));
        return count;
    }
}
