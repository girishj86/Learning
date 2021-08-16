package com.learning.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] numbers = new int[]{3,4,1,8,5};
        int[] result = nextGreaterElements(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + " --> " + result[i]);
        }
    }

    public static int[] nextGreaterElements(int[] numbers) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[numbers.length];
        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(numbers[i]);
        }
        return result;
    }
}
