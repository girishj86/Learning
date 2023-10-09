package com.scaler.queues;

import java.util.Stack;

public class QueueUsingStacks {
    public static void main(String[] args) {

    }
}

class QueueWithStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(Integer n){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(n);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int pop(){
        if(stack1.isEmpty()) return -1;
        return stack1.pop();
    }

    public int peek(){
        if(stack1.isEmpty()) return -1;
        return stack1.peek();
    }

    public boolean isEmpty(){
        return stack1.isEmpty();
    }
}