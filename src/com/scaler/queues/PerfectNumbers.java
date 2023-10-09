package com.scaler.queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class PerfectNumbers {
    public static void main(String[] args) {
        System.out.println(findAthPerfectNumber(5));
    }

    public static String findAthPerfectNumber(int A){
        String result = "";
        Queue<String> q = new ArrayDeque<>();
        q.offer("1");q.offer("2");
        while(A!=0){
            String s = q.poll();
            StringBuilder sb = new StringBuilder(s);
            result = s + sb.reverse();
            A--;
            q.offer(s+"1");
            q.offer(s+"2");
        }
        return result;
    }


}
