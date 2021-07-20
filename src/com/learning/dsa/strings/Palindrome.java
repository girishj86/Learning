package com.learning.dsa.strings;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("malayalam"));
        String word = "malayalam";
        System.out.println(isPalindrome(word, 0, word.length() - 1));
    }

    public static boolean isPalindrome(String word) {
        for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String word, int start, int end) {
        if (start > end) {
            return true;
        }
        if (word.charAt(start) != word.charAt(end)) {
            return false;
        }
        return isPalindrome(word, ++start, --end);
    }
}
