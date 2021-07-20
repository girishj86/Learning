package com.learning.dsa.strings;

public class SubSequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abcdef", "af"));
    }

    public static boolean isSubsequence(String word, String subWord) {
        if (word == null || word.trim().isBlank()) {
            return false;
        }
        if (subWord == null || subWord.trim().isBlank()) {
            return false;
        }
        int wordLength = word.length(), subWordLength = subWord.length();
        if (subWordLength > wordLength) {
            return false;
        }
        int i = 0, j = 0;
        while (i < wordLength && j < subWordLength) {
            if (word.charAt(i) == subWord.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == subWordLength;
    }
}
