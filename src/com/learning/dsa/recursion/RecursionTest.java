package com.learning.dsa.recursion;

public class RecursionTest {

    public static void main(String[] args) {
        f1(10); // prints 0,0,1,2,3,4,5,6,7,8,9
        f2(10); // stackoverflow error
    }

    static void f1(int x) {
        if (x > 0) {
            f1(--x);
        }
        System.out.println(x);
    }

    static void f2(int x) {
        if (x > 0) {
            f2(x--);
        }
        System.out.println(x);
    }
}

