package com.learning.dsa.arrays;

public class MissingInteger {

    public static void main(String[] args) {
        int[] A = {3, -8, 5, 2, 17, 1, 6};
        System.out.println(firstMissingPositive(A));
    }

    public static int firstMissingPositive(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] == i + 1 || A[i] <= 0 || A[i] > n) {
                continue;
            }
            int index = A[i] - 1;
            if (A[index] != A[i]) {
                int temp = A[i];
                A[i] = A[index];
                A[index] = temp;
                i--;
            } else {
                i++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
