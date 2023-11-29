package com.scaler.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("4", "13", "5", "/", "+"));
        System.out.println(evalRPN(list));
    }

    public static int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();
        for(String op:A){
            switch (op){
                case "*":
                    int op2 = stack.pop();
                    int op1 = stack.pop();
                    stack.push(op1*op2);
                    break;
                case "/":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1/op2);
                    break;
                case "+":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1+op2);
                    break;
                case "-":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1-op2);
                    break;
                default:
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }
        return stack.pop();
    }
}
