package com.learning.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindCelebrity {
    static int MATRIX[][] = {
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}
    };

    public static void main(String[] args) {
        System.out.println(findCelebrity(4));
    }

    static boolean knows(int a, int b) {
        return MATRIX[a][b] == 1;
    }

    static int findCelebrity(int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            stack.push(knows(a, b) ? b : a);
        }

        if (stack.isEmpty()) {
            return -1;
        }

        int c = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i == c) continue;
            if (knows(c, i) || !knows(i, c)) {
                return -1;
            }
        }
        return c;
    }
}
