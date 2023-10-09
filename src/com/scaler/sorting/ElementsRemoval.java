package com.scaler.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ElementsRemoval {
    public static void main(String[] args) {
        System.out.println(ElementsRemoval.solve(new int[]{2,1}));
    }

    public static int solve(int[] A) {
        sortDescending(A);
        int sum = 0, j = 1;
        for(int i=0;i<A.length;i++){
            sum = sum + (j++ * A[i]);
        }
        return sum;
    }

    private static void sortDescending(int[] A) {
        Arrays.sort(A);
        for(int i = 0, j = A.length-1; i<j; i++,j--){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
}
