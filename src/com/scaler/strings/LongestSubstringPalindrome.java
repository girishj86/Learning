package com.scaler.strings;

public class LongestSubstringPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcdefghgfem"));

    }

    public static int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int result = 0, start = 0, end = 0;
        for (int i = 0; i < chars.length; i++) {
            int p1 = i, p2 = i;
            while (p1 >= 0 && p2 < chars.length && chars[p1] == chars[p2]) {
                p1--;
                p2++;
            }
            if(result < (p2 - p1 - 1)){
                result = p2 - p1 - 1;
                end = p2;
                start = p1;
            }
        }
        for (int i = 0; i < chars.length - 1; i++) {
            int p1 = i, p2 = i + 1;
            while (p1 >= 0 && p2 < chars.length && chars[p1] == chars[p2]) {
                p1--;
                p2++;
            }
            if(result < (p2 - p1 - 1)){
                result = p2 - p1 - 1;
                end = p2;
                start = p1;
            }
        }
        start++;
        System.out.println(s.substring(start,end));
        return result;
    }
}

