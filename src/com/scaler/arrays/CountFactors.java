package com.scaler.arrays;

public class CountFactors {
    public static void main(String[] args) {
        System.out.println(solve(81));
    }

    public static int solve(int A) {
        int i=1, c=0;
        while(i*i <= A){
            if(A%i==0){
                if(A/i==i){
                    c++;
                } else {
                    c=c+2;
                }
            }
            i++;
        }
        return c;
    }
}

