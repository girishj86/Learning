package com.learning.dsa.arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }

    public static int maxArea(int[] containerHeights){
        int left = 0;                   // Left pointer starting from the leftmost edge
        int right = containerHeights.length - 1;  // Right pointer starting from the rightmost edge
        int maxWater = 0;               // Initialize the maximum water capacity

        while (left < right) {
            // Calculate the width of the container
            int width = right - left;

            // Calculate the height of the container (the minimum height between the two lines)
            int h = Math.min(containerHeights[left], containerHeights[right]);

            // Calculate the water capacity of the current container
            int water = width * h;

            // Update the maximum water capacity if the current container holds more water
            maxWater = Math.max(maxWater, water);

            // Move the pointers towards each other
            if (containerHeights[left] < containerHeights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
