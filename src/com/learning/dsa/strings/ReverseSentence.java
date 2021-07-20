package com.learning.dsa.strings;

import java.util.ArrayList;
import java.util.List;

public class ReverseSentence {
    public static void main(String[] args) {
        System.out.println(reverseSentence("India is my country"));
        reverseSentenceWithExtraSpace("India is my country");

    }

    public static String reverseSentence(String sentence) {
        int start = 0, end = 0;
        char[] charArray = sentence.toCharArray();
        for (int i = 0; i < sentence.length(); i++) {
            if (charArray[i] == ' ') {
                reverse(charArray, start, end);
                start = end + 1;
            }
            end++;
        }
        //reverse last word
        reverse(charArray, start, charArray.length);
        //reverse whole array
        reverse(charArray, 0, charArray.length);
        return new String(charArray);
    }

    private static void reverse(char[] charArray, int start, int end) {
        for (int i = start, j = end - 1; i < j; i++, j--) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
    }

    public static void reverseSentenceWithExtraSpace(String sentence) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) != ' ') {
                sb.append(sentence.charAt(i));
            } else {
                list.add(sb.toString());
                sb.setLength(0);
            }
        }
        list.add(sb.toString());
        sb.setLength(0);
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
            sb.append(' ');
        }
        System.out.println(sb.toString());
    }
}
