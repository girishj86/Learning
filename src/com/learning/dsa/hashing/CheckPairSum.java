package com.learning.dsa.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckPairSum {
    public static void main(String[] args) {
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(9, 10, 7, 10, 9, 1, 5, 1, 5));
        System.out.println(checkPairSum(21,B));
    }

    public static int checkPairSum(int A, ArrayList<Integer> B) {
        Set<Integer> set = new HashSet<>();
        for(Integer num:B){
            if(set.contains(A-num)){
                return 1;
            } else {
                set.add(num);
            }
        }
        return 0;
    }
}
