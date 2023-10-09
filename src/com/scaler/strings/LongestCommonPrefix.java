package com.scaler.strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String A = "abc";
        A = A.concat(A);
        System.out.println(A);

        //System.out.println(longestCommonPrefix(new String[]{"abcdefgh", "aefghijk", "abcefgh"}));
    }

    public static String longestCommonPrefix(String[] A) {
        if(A.length == 0){
            return "";
        }
        if(A.length == 1){
            return A[0];
        }
        String first = A[0];
        for(int i=0;i<first.length();i++){
            char c = first.charAt(i);
            for(int j=1;j<A.length;j++){
                if(i > A[j].length()-1 || c != A[j].charAt(i)){
                    return first.substring(0,i);
                }
            }
        }
        return first;
    }
}
