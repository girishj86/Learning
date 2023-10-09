package com.scaler.contest;

public class ConstructBinaryNumber {
    public static void main(String[] args) {
        System.out.println(solve(3,2));

    }

    public static int solve(int A, int B) {
        /*int sum = 0;
        while (A-- > 0){
            sum = (int) (sum + Math.pow(2,B++));
        }
        return sum;*/
        return (1<<(A+B)) - (1<<B);

    }
}
