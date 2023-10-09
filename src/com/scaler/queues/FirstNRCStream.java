package com.scaler.queues;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class FirstNRCStream {
    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharactersStream("abcabc"));
    }

    public static String firstNonRepeatingCharactersStream(String s){
        Map<Character,Integer> freqMap = new HashMap<>();
        Queue<Character> queue = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        for(int i=0;i<s.length();i++){
            Character ch = s.charAt(i);
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
            queue.offer(ch);
            while(!queue.isEmpty() && freqMap.get(queue.peek()) > 1){
                queue.poll();
            }
            if(!queue.isEmpty()) {
                result.append(queue.peek());
            } else {
                result.append('#');
            }
        }
        return result.toString();
    }
}
