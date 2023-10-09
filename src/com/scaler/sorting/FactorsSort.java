package com.scaler.sorting;

import java.util.ArrayList;

public class FactorsSort {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2);integers.add(4);integers.add(7);
        System.out.println(factorSort(integers));
    }

    public static ArrayList<Integer> factorSort(ArrayList<Integer> A){
        A.sort((a,b) -> {
            Integer factorsA = findFactors(a);
            Integer factorsB = findFactors(b);
            if(factorsA != factorsB) {
                return factorsA.compareTo(factorsB);
            } else {
                return a.compareTo(b);
            }
        });
        return A;
    }

    private static int findFactors(int n){
       /* int count = 2;
        for(int i=2;i<n-1;i++){
            if(n%i == 0) count++;
        }
        return count;*/
        int count=0;
        for(int i=1;i*i<=n;i++)
        {
            if(n%i==0){
                count++;
                if(i*i!=n) count++;
            }
        }
        return count;
    }
}
