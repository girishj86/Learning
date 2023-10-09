package com.scaler.maths;

public class IsPrime {
    public static void main(String[] args) {
        System.out.println(solve(67010446483l));
    }

    public static int solve(long A) {
        int i=2, sqrt = (int) Math.sqrt(A);
        while(i<=sqrt){
            if(A%i==0){
                return 0;
            }
            i++;
        }
        return 1;
    }
}
