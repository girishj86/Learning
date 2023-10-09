package com.scaler.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrettyNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{9,9,9,9})));
    }

    public static int[] solve(int[] A) {
        int min = Integer.MAX_VALUE, smin = Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            if(A[i] < min){
                smin = min;
                min = A[i];
            } else if(A[i] < smin){
                smin = A[i];
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            if(A[i]>smin) {
                resultList.add(A[i]);
            }
        }
        int[] resultArray = new int[resultList.size()];
        int i =0;
        for(Integer num: resultList){
            resultArray[i++] = num;
        }
        return resultArray;
    }
}
