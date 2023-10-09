package com.learning.dsa.strings;

import java.util.HashSet;
import java.util.Set;

public class ValidIP {
    public static void main(String[] args) {
        System.out.println(isValid("..."));
    }

    public static boolean isValid(String s) {
        int countDots = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='.') countDots++;
            if(countDots > 3) return false;
        }
        if(countDots != 3) return false;
        String[] points = s.split("\\.");
        if(points.length != 4) return false;
        Set<String> validSet = new HashSet<>();
        for(int i=0;i<=255;i++){
            validSet.add(""+i);
        }
        for(String point:points){
            if(!validSet.contains(point)) return false;
        }
        return true;
    }
}
