package com.scaler.stacks;

import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) {
        System.out.println(isParanthesisBalanced("{}[](}"));
    }

    public static boolean isParanthesisBalanced(String s){
        Stack<Character> stack = new Stack<>();
        for(Character ch:s.toCharArray()){
            if(ch == '{' || ch == '[' || ch == '('){
                stack.push(ch);
                continue;
            }
            if(stack.isEmpty()) return false;
            if(ch == '}' && stack.peek() != '{') return false;
            if(ch == ')' && stack.peek() != '(') return false;
            if(ch == ']' && stack.peek() != '[') return false;
            stack.pop();
        }
        return stack.isEmpty();
    }
}
