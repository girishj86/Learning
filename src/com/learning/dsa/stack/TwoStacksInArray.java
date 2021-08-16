package com.learning.dsa.stack;

public class TwoStacksInArray {

    public static void main(String[] args) {
        TwoStacks twoStacks = new TwoStacks(4);
        twoStacks.push1(1);
        twoStacks.push2(2);
        twoStacks.push1(3);
        twoStacks.push2(4);
        twoStacks.displayStack1();
        twoStacks.displayStack2();
        System.out.println(twoStacks.pop1());
        twoStacks.push1(5);
        System.out.println(twoStacks.pop2());
        twoStacks.push2(6);
        twoStacks.displayStack1();
        twoStacks.displayStack2();
    }
}

class TwoStacks {

    private int[] stackArray;
    private int stack1Counter, stack2Counter, capacity;

    TwoStacks(int capacity) {
        this.capacity = capacity;
        stackArray = new int[capacity];
        stack1Counter = 0;
        stack2Counter = capacity - 1;
    }

    public void push1(int num) {
        if (stack1Counter <= stack2Counter) {
            stackArray[stack1Counter++] = num;
        } else {
            throw new RuntimeException("Stack1 is full");
        }
    }

    public int pop1() {
        if (stack1Counter != -1) {
            return stackArray[--stack1Counter];
        } else {
            throw new RuntimeException("Stack1 is empty");
        }

    }

    public void push2(int num) {
        if (stack2Counter >= stack1Counter) {
            stackArray[stack2Counter--] = num;
        } else {
            throw new RuntimeException("Stack2 is full");
        }
    }

    public int pop2() {
        if (stack2Counter != capacity) {
            return stackArray[++stack2Counter];
        } else {
            throw new RuntimeException("Stack2 is empty");
        }
    }

    public void displayStack1() {
        System.out.println("First stack");
        for (int i = stack1Counter - 1; i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    public void displayStack2() {
        System.out.println("Second stack");
        for (int i = capacity - 1; i >= stack2Counter + 1; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

}