package com.learning.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("({[]}"));
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> symbolsMap = new HashMap<>();
        symbolsMap.put(')', '(');
        symbolsMap.put('}', '{');
        symbolsMap.put(']', '[');
        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (stack.peek().equals(symbolsMap.get(c))) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}
