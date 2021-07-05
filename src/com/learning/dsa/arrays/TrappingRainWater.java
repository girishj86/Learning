package com.learning.dsa.arrays;

import static java.lang.Integer.*;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] blocks = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapMaxRainWater(blocks));

    }
    public static int trapMaxRainWater(int[] blocks){
        int n = blocks.length;
        int leftMax = blocks[0], rightMax = blocks[n-1];
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=0;i<n;i++){
        	leftMax = max(leftMax,blocks[i]);
            left[i] = leftMax;
        }
        for(int i=n-1;i>=0;i--){
        	rightMax = max(rightMax,blocks[i]);
            right[i] = rightMax;
        }
        int maxWater = 0;
        for(int i=0;i<n;i++){
            int minLeftRight = min(left[i],right[i]);
            maxWater = maxWater + minLeftRight-blocks[i];
        }
        return maxWater;
    }
}
