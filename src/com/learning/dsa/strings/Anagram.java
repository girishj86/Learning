package com.learning.dsa.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "bcad";
        System.out.println(isAnagramWithoutExtraSpace(s1, s2));
        System.out.println(isAnagramWithExtraSpace(s1, s2));
    }

    public static boolean isAnagramWithoutExtraSpace(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.trim().length() != s2.trim().length()) {
            return false;
        }

        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();
        Arrays.sort(s1CharArray);
        Arrays.sort(s2CharArray);

        return Arrays.equals(s1CharArray,s2CharArray);

    }

    public static boolean isAnagramWithExtraSpace(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.trim().length() != s2.trim().length()) {
            return false;
        }

        Map<Character, Integer> counter = new HashMap<>();
        for (Character ch : s1.toCharArray()) {
            if (counter.containsKey(ch)) {
                counter.put(ch, counter.get(ch) + 1);
            } else {
                counter.put(ch, 1);
            }
        }
        for (Character ch : s2.toCharArray()) {
            if (!counter.containsKey(ch)) {
                return false;
            } else {
                counter.put(ch, counter.get(ch) - 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
