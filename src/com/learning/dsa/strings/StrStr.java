package com.learning.dsa.strings;

public class StrStr {
    public static void main(String[] args) {
        System.out.println(strstr("abcdef","ef"));
    }

    static int strstr(String s, String x)
    {
        int slen = s.length(), xlen = x.length();
        for(int i=0;i<slen;i++){
            if(s.charAt(i) != x.charAt(0)) continue;
            int j = 0;
            for(int k=i;k<slen && j<xlen;k++,j++){
                if(s.charAt(k) != x.charAt(j)) break;
            }
            if(j==xlen) return i;
        }
        return -1;
    }
}
