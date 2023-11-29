package com.scaler.search.binary;

public class FindSquareRoot {

    public static void main(String[] args) {
        System.out.println(findSquareRoot(2147483647));
    }

    private static int findSquareRoot(int n){
        int low = 0, high = n;
        while(low <= high){
            long mid = (low+high)/2;
            if((int)mid == low || (int)mid == high){
                return (int)mid;
            }
            if(mid*mid == n){
                return (int)mid;
            }
            if(mid*mid < n){
                low = (int)(mid);
            } else {
                high = (int)(mid);
            }
        }
        return high;
    }
}
