package com.scaler.hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = {18, 1, 3, 2, 4, 17, 29, 6, 5, 7, 8, 16, 15};
        System.out.println(findLongestConseqSubseq(arr, arr.length));
    }

    private static int findLongestConseqSubseq(int arr[], int N) {
        Set<Integer> frq = new HashSet<>();
        for (int i = 0; i < N; i++) {
            frq.add(arr[i]);
        }
        int result = 0, count;
        for (int i = 0; i < N; i++) {
            if (frq.contains(arr[i] - 1)) {
                continue;
            } else {
                int next = arr[i] + 1;
                count = 1;
                while (frq.contains(next)) {
                    count++;
                    next++;
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
