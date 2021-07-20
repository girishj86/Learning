package com.learning.dsa.strings;

public class ReverseWord {
    public static void main(String[] args) {
        System.out.println(reverse("hello"));
        char[] charArray = "hello".toCharArray();
        reverseRecursively(charArray, 0, charArray.length - 1);
        System.out.println(new String(charArray));
    }

    public static String reverse(String word) {
        char[] charArray = word.toCharArray();
        for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        return new String(charArray);
    }

    public static void reverseRecursively(char[] charArray, int start, int end) {
        if (start > end) {
            return;
        }
        char temp = charArray[start];
        charArray[start] = charArray[end];
        charArray[end] = temp;
        reverseRecursively(charArray, ++start, --end);
    }
}
