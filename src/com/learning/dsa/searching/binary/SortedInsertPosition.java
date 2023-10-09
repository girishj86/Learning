package com.learning.dsa.searching.binary;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedInsertPosition {
    public static void main(String[] args) {
        SortedInsertPosition sortedInsertPosition = new SortedInsertPosition();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(17, 30, 32, 69, 94, 96, 106, 118, 127, 159, 169, 170, 178, 183, 209, 238, 242, 247, 253, 261, 265, 279, 288, 302, 305, 316, 352, 357, 374, 376, 392, 402, 410, 421, 439, 442, 444, 446, 454, 458, 464, 467, 468, 498, 500, 513, 523, 541, 545, 556, 575, 608, 616, 629, 631, 635, 669, 674, 682, 686, 693, 695, 719, 733, 754, 755, 756, 778, 802, 822, 824, 828, 835, 847, 848, 862, 864, 878, 883, 885, 904, 908, 928, 934));
        System.out.println(sortedInsertPosition.searchInsert(A, 104));
        //System.out.println(sortedInsertPosition.recursiveBinarySearch(A,12, 0, A.size()-1));
    }

    public int searchInsert(ArrayList<Integer> A, int B) {
        return iterativeBinarySearch(A, B);
    }

    private int iterativeBinarySearch(ArrayList<Integer> A, int B) {
        int l = 0, r = A.size() - 1, m = 0;
        if(A.get(l) > B){
            return 0;
        }
        if(A.get(r) < B){
            return r+1;
        }
        while (l <= r) {
            m = l + (r - l) / 2;
            System.out.println(l+" "+m+" "+r);
            if (A.get(m) == B) return m;
            if (A.get(m) < B) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if(A.get(m) < B){
            return m-1;
        } else {
            return m;
        }
    }

    private int recursiveBinarySearch(ArrayList<Integer> A, int B, int l, int r) {
        int m = l + (r - l) / 2;
        if (A.get(m) == B) return m;
        if (l > r) return -1;
        if (A.get(m) < B) {
            return recursiveBinarySearch(A, B, m + 1, r);
        } else {
            return recursiveBinarySearch(A, B, l, m - 1);
        }
    }


}
