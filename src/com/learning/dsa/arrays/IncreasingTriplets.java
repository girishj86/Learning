package com.learning.dsa.arrays;

public class IncreasingTriplets {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 3 };

        int n = arr.length;

        System.out.print(countIncreasingTripletsBF(arr, n));
    }

    static int countIncreasingTriplets(int a[], int n)
    {
        return 0;
    }

    static int countIncreasingTripletsBF(int a[], int n)
    {
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(a[i]<a[j] && a[j]<a[k]){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
