package com.learning.dsa.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumK {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(9, 4, 20, 3, 10, 5));
        System.out.println(findSubArraysWithSum(A,33));

    }

    public static int findSubArraysWithSum(ArrayList<Integer> A, int B) {
        int count  = 0, sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(Integer num:A){
            sum = sum + num;
            if(map.containsKey(sum-B)){
                count = count + map.get(sum-B);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
