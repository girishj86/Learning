package com.scaler.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(8);A.add(89);
        System.out.println(largestNumber(A));
    }

    public static String largestNumber(ArrayList<Integer> A) {
        A.sort(Comparator.comparing(a -> (a + "")));
        Collections.reverse(A);
        StringBuilder result = new StringBuilder();
        for(Integer num:A){
            result.append(num+"");
        }
        return result.toString();
    }
}
