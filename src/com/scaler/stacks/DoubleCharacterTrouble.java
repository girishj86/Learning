package com.scaler.stacks;

import java.util.Stack;

public class DoubleCharacterTrouble {
    public static void main(String[] args) {
        System.out.println(removeIdenticalPairs("fabccbad"));
    }

    public static String removeIdenticalPairs(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            Character ch = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(ch);
                continue;
            }
            if(stack.peek() == ch){
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character ch:stack){
            sb.append(ch);
        }
        return sb.toString();
    }
}
