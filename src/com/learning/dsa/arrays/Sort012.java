package com.learning.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int[] a = {1,1,0,2,0,2};
        //1,1,0,2,0,2
        Sort012.sort012(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort012(int a[]){
        int p1 = 0, p2 = 0, p3 = a.length-1;
        while(p2 <= p3) {
            if(a[p2]==0){
                int temp = a[p2];
                a[p2] = a[p1];
                a[p1] = temp;
                p1++;p2++;
            } else if(a[p2]==1)p2++;
            else if(a[p2]==2){
                int temp = a[p2];
                a[p2] = a[p3];
                a[p3] = temp;
                p3--;
            }
        }
    }
}
