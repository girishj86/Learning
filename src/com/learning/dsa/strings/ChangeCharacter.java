package com.learning.dsa.strings;

import java.util.*;

public class ChangeCharacter {
    public static void main(String[] args) {
        System.out.println(changeCharacter("a",1));
    }

    static int changeCharacter(String A, int B){
        System.out.println(A);
        Map<Character,Integer> frq = new HashMap<>();
        for(int i=0;i<A.length();i++){
            frq.put(A.charAt(i), frq.getOrDefault(A.charAt(i),0)+1);
        }
        System.out.println(frq);
        List<Integer> frequencies = new ArrayList<>(frq.values());
        Collections.sort(frequencies);
        int result = frequencies.size();
        System.out.println(result);
        for(Integer num:frequencies){
            if(B>=num)
            {
                result--;
                B = B - num;
            } else {
                return result;
            }
        }
        return result;
    }
}
