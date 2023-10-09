package com.scaler.recursion;

public class PrintNumbers {
    public static void main(String[] args) {

    }

    public static void print(int num){
        if(num==1){
            System.out.println(1);
            return;
        }
        print(num-1);
    }
}
