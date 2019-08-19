package com.rahul;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {

        int[] a = {5,2,5,3,5,3,1,1,3};
        int k = 2;
        System.out.println(topKFrequent(a, k));
    }

    static class Element {
        int val;
        int freq;

        Element(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
    }
    
    public static List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Element> pq = new PriorityQueue<>(k, (a, b) -> Integer.compare(a.freq, b.freq));

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int val = e.getKey();
            int fre = e.getValue();

            if(k-- > 0){
                pq.add(new Element(val, fre));
            } else if(fre > pq.peek().freq) {
                pq.poll();
                pq.add(new Element(val, fre));
            }
        }

        return pq.stream().map(e -> e.val).collect(Collectors.toList());
    }
}

/*class Solution {

    public static void main(String[] args) {

        Solution s = new Solution();
        String[] a = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","g1 act car","a8 act zoo"};
        s.reorderLogFiles(a);
    }

    public String[] reorderLogFiles(String[] logs) {
        
        Set<Node> set = new TreeSet<>();
        
        for(String s : logs){
            String a = s.substring(0, s.indexOf(" "));
            String b = s.substring(s.indexOf(" ") +1);
            
            set.add(new Node(a,b));
            
        }
        System.out.println(set);
        return logs;
    }
}*/

class Node implements Comparable<Node>{
    String a1;
    String a2;
    
    public Node(String s1, String s2) {
        a1 = s1;
        a2 = s2;
    }
    
    public int compareTo(Node n){

        String a = this.a2.substring(this.a2.indexOf(" ")+1);
        boolean isNumber = Character.isDigit(a.charAt(0));

        if(isNumber) {
            return 1;
        }

        String na = n.a2.substring(n.a2.indexOf(" ")+1);
         isNumber = Character.isDigit(na.charAt(0));

        if(isNumber) {
            return -1;
        }

        else {
            if (this.a2.equals(n.a2)){
                int c = this.a1.compareTo(n.a1);
                if(c == 0){
                    return 1;
                }
                return c;
            } else {
                int c = this.a2.compareTo(n.a2);
                if(c == 0){
                    return 1;
                }
                return c;
            }
        }
    }
    
    public String toString(){
        return "a1 : " + a1 + " a2 : " + a2; 
    }
}
