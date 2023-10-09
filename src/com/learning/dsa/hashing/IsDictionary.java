package com.learning.dsa.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsDictionary {
    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>(Arrays.asList("fine","none","no"));
        String B = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println(isDictionary(A,B));
    }

    public static int isDictionary(ArrayList<String> A, String B) {
        int order = 1;
        Map<Character, Integer> charactersOrder = new HashMap<>();
        for (Character ch : B.toCharArray()) {
            charactersOrder.put(ch, order++);
        }
        for (int i = 0; i < A.size() - 1; i++) {
            String s1 = A.get(i);
            String s2 = A.get(i + 1);
            if (!isSorted(s1, s2, charactersOrder)) {
                return 0;
            }
        }
        return 1;
    }

    private static boolean isSorted(String s1, String s2, Map<Character, Integer> charactersOrder) {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            Character ch1 = s1.charAt(i++);
            Character ch2 = s2.charAt(j++);
            if (charactersOrder.get(ch1) > charactersOrder.get(ch2)) {
                return false;
            }
            if (charactersOrder.get(ch1) < charactersOrder.get(ch2)) {
                return true;
            }
        }
        if(j<=s2.length()) {
            return false;
        }
        return true;
    }
}
