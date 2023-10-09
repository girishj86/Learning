package com.learning.dsa.arrays;

public class MaxPathSum {
    public static void main(String[] args) {
        int ar1[] = {1,3,5,7,9,11};
        int ar2[] = {0,2,4,6,7,8,10};
        System.out.println(maxPathSum(ar1,ar2));
    }

    static int maxPathSum(int ar1[], int ar2[])
    {
        int cmnVal = 0;
        int n1 = ar1.length, n2 = ar2.length;
        int p1 = 0, p2 = 0;
        while(p1<n1 && p2<n2){
            if(ar1[p1]==ar2[p2]){
                cmnVal = ar1[p1];
                break;
            }
            p1++;p2++;
        }
        int lSum1 = 0, lSum2 = 0;
        int rSum1 = 0, rSum2 = 0;
        for(int i=0;i<p1;i++){
            lSum1 = lSum1 + ar1[i];
        }
        for(int i=0;i<p2;i++){
            lSum2 = lSum2 + ar2[i];
        }
        for(int i=p1+1;i<n1;i++){
            rSum1 = rSum1 + ar1[i];
        }
        for(int i=p2+1;i<n2;i++){
            rSum2 = rSum2 + ar2[i];
        }
        return Math.max(lSum1,lSum2)+cmnVal+Math.max(rSum1,rSum2);
    }
}

