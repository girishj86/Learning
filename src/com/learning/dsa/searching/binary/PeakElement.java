package com.learning.dsa.searching.binary;

import java.util.ArrayList;
import java.util.Arrays;

public class PeakElement {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 3));
        System.out.println(findPeakElement(A));
    }

    public static int findPeakElement(ArrayList<Integer> A) {
        if (A.size() == 1) return A.get(0);
        int l = 0, r = A.size() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (m > 0 && m + 1 <= A.size() - 1 && A.get(m - 1) <= A.get(m) && A.get(m + 1) <= A.get(m)) {
                return A.get(m);
            }
            if (m > 0 && A.get(m) > A.get(m - 1)) {
                l = m + 1;
            } else if (m > 0 && A.get(m) < A.get(m - 1)) {
                r = m - 1;
            } else break;
        }
        if (A.get(0) > A.get(1)) return A.get(0);
        if (A.get(A.size() - 1) > A.get(A.size() - 2)) return A.get(A.size() - 1);
        return -1;
    }
}
