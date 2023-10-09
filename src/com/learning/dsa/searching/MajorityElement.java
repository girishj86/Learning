package com.learning.dsa.searching;

public class MajorityElement {
    public static void main(String[] args) {
        int[] a = {3,1,3,3,2};
        System.out.println(majorityElement(a,a.length));
    }

    static int majorityElement(int a[], int size)
    {
        int majorityIndex = 0, count = 1;
        for(int i=1;i<size;i++){
            if(a[majorityIndex] == a[i]){
                count++;
            } else {
                count--;
            }
            if(count==0){
                majorityIndex = i;
                count = 1;
            }
        }
        int result = a[majorityIndex];
        count = 0;
        for(int i=0;i<size;i++){
            if(a[i]==result){
                count++;
            }
        }
        if(count > (size/2)){
            return result;
        }
        return -1;
    }
}
