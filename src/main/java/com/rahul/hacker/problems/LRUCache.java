package com.rahul.hacker.problems;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private Cache cache;
    private int capacity;
    
    class Cache extends LinkedHashMap<Integer, Integer> {
        
        Cache(int capacity) {
            super(capacity, 0.75f, true);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            
            return cache.size() > capacity;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new Cache(capacity);
    }
    
    public int get(int key) {
        Integer v = cache.get(key);
        if(v == null){
            return -1;
        }
        else {
            return v;
        }
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {

        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        int v = obj.get(1);
        System.out.println(v);
        obj.put(3,3);
        v = obj.get(2);
        System.out.println(v);
        obj.put(4,4);
        v = obj.get(1);
        System.out.println(v);
        v = obj.get(3);
        System.out.println(v);
        v = obj.get(4);
        System.out.println(v);
    }
}
