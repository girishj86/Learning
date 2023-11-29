package com.scaler.stacks;

import java.util.Stack;

public class MinStack {

    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();
    public static void main(String[] args) {
        /*push(1);
        push(2);
        push(-2);
        System.out.println(getMin());
        pop();
        System.out.println(getMin());
        System.out.println(top());*/
        System.out.println(getMin());
        pop();
        System.out.println(top());
    }

    public static void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
            return;
        }
        if(minStack.peek() > x){
            minStack.push(x);
        }
    }

    public static void pop() {
        if(stack.empty()){
            return;
        }
        int n = stack.pop();
        if(minStack.peek() == n){
            minStack.pop();
        }
    }

    public static int top() {
        if(stack.empty()){
            return -1;
        }
        return stack.peek();
    }

    public static int getMin() {
        if(stack.empty()){
            return -1;
        }
        return minStack.peek();
    }
}
