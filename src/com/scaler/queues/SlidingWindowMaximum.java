package com.scaler.queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1, 9, 8, 12, 6, 4, 2, 3, 7, 5};
        System.out.println(Arrays.toString(slidingWindowMaximum(arr, arr.length, 3)));
    }

    public static int[] slidingWindowMaximum(int arr[], int n, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        // for First K elements
        for (int i = 0; i <= k - 1; i++) {
            while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) {
                // Remove the indices of elements that are smaller than the current elements
                queue.removeLast();
            }
            queue.addLast(i);
        }
        // the element at the front has index of the highest element in the window
        result.add(arr[queue.peekFirst()]);
        // for rest elements
        for (int i = k; i <= n - 1; i++) {
            // drop the elements that are out of window
            while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.removeFirst();
            }
           // remove those elements smaller than the current element from back
            while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            result.add(arr[queue.peekFirst()]);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
