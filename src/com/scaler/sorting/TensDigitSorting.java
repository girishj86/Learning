package com.scaler.sorting;

import java.util.ArrayList;

public class TensDigitSorting {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> tensDigitSorting(ArrayList<Integer> A){
        A.sort((a,b) -> {
            int aDigit = a % 10;
            int bDigit = b % 10;
            if(aDigit != bDigit){
                return aDigit-bDigit;
            } else {
                return a - b;
            }
        });
        return A;
    }
}
