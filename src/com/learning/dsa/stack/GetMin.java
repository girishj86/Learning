package com.learning.dsa.stack;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class GetMin {
    public static void main(String[] args) {
        /*GetMinWithAuxiliaryStack stack = new GetMinWithAuxiliaryStack();
        stack.push(3);
        System.out.println(stack.getMin());
        stack.push(4);
        System.out.println(stack.getMin());
        stack.push(2);
        System.out.println(stack.getMin());
        stack.push(5);
        System.out.println(stack.getMin());
        stack.push(1);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        System.out.println(stack.mainStack);
        System.out.println(stack.auxiliaryStack);*/

        GetMinWithoutAuxStack stack = new GetMinWithoutAuxStack();
        stack.push(3);
        System.out.println(stack.getMin());
        stack.push(4);
        System.out.println(stack.getMin());
        stack.push(2);
        System.out.println(stack.getMin());
        stack.push(5);
        System.out.println(stack.getMin());
        stack.push(1);
        stack.stack.stream().filter(x -> x != 0).forEach(x -> System.out.print(x+" "));
        System.out.println("\n"+stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}

class GetMinWithAuxiliaryStack {
    Deque<Integer> mainStack = new ArrayDeque<>();
    Deque<Integer> auxiliaryStack = new ArrayDeque<>();

    public void push(int num) {
        mainStack.push(num);
        if (auxiliaryStack.isEmpty()) {
            auxiliaryStack.push(num);
        } else {
            int currentMinimum = auxiliaryStack.peek();
            if (num <= currentMinimum) {
                auxiliaryStack.push(num);
            }
        }
    }

    public int pop() {
        int poppedNum = mainStack.pop();
        if (poppedNum == auxiliaryStack.peek()) {
            auxiliaryStack.pop();
        }
        return poppedNum;
    }

    public int getMin() {
        return auxiliaryStack.peek();
    }

}

class GetMinWithoutAuxStack {
    int currentMinimum = -1;

    Deque<Integer> stack = new ArrayDeque<>();

    public void push(int num) {
        if (stack.isEmpty()) {
            stack.push(num);
            currentMinimum = num;
            return;
        }
        if (num > currentMinimum) {
            stack.push(num);
        } else {
            stack.push(2 * num - currentMinimum);
            currentMinimum = num;
        }

    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        if (stack.peek() < currentMinimum) {
            currentMinimum = 2 * currentMinimum - stack.peek();
        }
        return stack.pop();
    }

    public int getMin() {
        return currentMinimum;
    }
}