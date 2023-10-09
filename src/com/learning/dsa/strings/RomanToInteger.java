package com.learning.dsa.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {

    }

    public static int romanToDecimal(String str) {
        Map<Character,Integer> romanToInteger = new HashMap<>();
        romanToInteger.put('I',1);
        romanToInteger.put('V',5);
        romanToInteger.put('X',10);
        romanToInteger.put('L',50);
        romanToInteger.put('C',100);
        romanToInteger.put('D',500);
        romanToInteger.put('M',1000);

        str = str.replace("IV","IIII");
        str = str.replace("IX","VIIII");
        str = str.replace("XL","XXXX");
        str= str.replace("CM","DCCCC");
        str= str.replace("CD","CCCC");
        str = str.replace("XC","LXXXX");

        int result = 0;
        for(int i=0;i<str.length();i++){
            result = result + romanToInteger.get(str.charAt(i));
        }
        return result;
    }
}
