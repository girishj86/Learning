package com.scaler.arrays;

public class PairsAG {
    public static void main(String[] args) {
        //ABCGAG , 3
        System.out.println(PairsAG.solve("ABCGAG"));
    }

    public static long solve(String A){
        long result = 0, gCount = 0;
        for(int i=A.length()-1;i>=0;i--){
            char c = A.charAt(i);
            if(c=='G'){
                gCount++;
            } else if(c=='A'){
                result = result+gCount;
            }
        }

        return result;
    }
}
