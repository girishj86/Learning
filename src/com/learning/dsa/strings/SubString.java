package com.learning.dsa.strings;

public class SubString {
    public static void main(String[] args) {
        System.out.println(isSubstring("abcdef", "ef"));
    }

    public static int isSubstring(String word, String subWord) {
        if (word == null || word.trim().isBlank()) {
            return -1;
        }
        if (subWord == null || subWord.trim().isBlank()) {
            return -1;
        }
        int wordLength = word.length(), subWordLength = subWord.length();
        if (subWordLength > wordLength) {
            return -1;
        }
        int m = wordLength - subWordLength;
        for (int i = 0; i <= m; i++) {
            int j;
            for (j = 0; j < subWordLength; j++) {
                if (word.charAt(i + j) != subWord.charAt(j)) {
                    break;
                }
            }
            if (j == subWordLength) {
                return i;
            }
        }

        return -1;
    }
}
