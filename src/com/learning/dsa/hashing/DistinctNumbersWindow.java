package com.learning.dsa.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersWindow {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);A.add(2);A.add(1);
        A.add(3);A.add(4);A.add(3);
        System.out.println(dNums(A,3));
    }

    public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        if(A==null || B>A.size()) return new ArrayList<Integer>();
        int n = A.size();
        ArrayList<Integer> resultList = new ArrayList<>();
        Map<Integer,Integer> frq = new HashMap<>();
        for(int i=0;i<B;i++){
            frq.put(A.get(i), frq.getOrDefault(A.get(i),0)+1);
        }
        resultList.add(frq.size());
        for(int i=1;i<n;i++){
            if(frq.containsKey(A.get(i-1)) && frq.get(A.get(i-1)) == 1){
                frq.remove(A.get(i-1));
            } else {
                frq.put(A.get(i-1), frq.getOrDefault(A.get(i-1),0)-1);
            }
            if(i-1+B <n){
                frq.put(A.get(i-1+B),frq.getOrDefault(A.get(i-1+B),0)+1);
                resultList.add(frq.keySet().size());
            } else {
                break;
            }
        }
        return resultList;

    }
}
