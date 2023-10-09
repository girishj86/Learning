package com.learning.dsa.strings;

public class ATOI {
    public static void main(String[] args) {
        System.out.println(atoi("2325"));
    }

    static int atoi(String str) {
	    /*List<Character> numbers = new ArrayList<>();
	    numbers.add('-'); numbers.add('0');
	    numbers.add('1'); numbers.add('2');
	    numbers.add('3'); numbers.add('4');
	    numbers.add('5'); numbers.add('6');
	    numbers.add('7'); numbers.add('8');
	    numbers.add('9');*/

        int result = 0, tens = 1;
        boolean isNegative = (str.charAt(0) == '-');
        if(isNegative){
            str = str.substring(1,str.length());
        }
        int len = str.length();
        char[] chars = str.toCharArray();
        for(int i=len-1;i>=0;i--){
            char c = chars[i];
            if(c<'0' || c>'9') return -1;
            int num = c - '0';
            //num = c - 48;
            result = result + (num*tens);
            tens = tens * 10;
        }
        if(isNegative) {
            result = result * -1;
        }
        return result;
    }
}
