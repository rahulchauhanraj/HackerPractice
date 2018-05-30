package com.rahul.hacker.ds.heap;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {

    private static final Scanner scanner = ScannerUtil.getScanner();

    private static Comparator<Integer> minComp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
        }
    };

    private static Comparator<Integer> maxComp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o2, o1);
        }
    };

    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>(100, minComp);
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(100, maxComp);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            addElement(aItem);
            System.out.println(getMedian());
        }

        scanner.close();
    }

    private static void addElement(int e) {
        if(!minHeap.isEmpty() && e > minHeap.peek()){
            minHeap.add(e);
        }else {
            maxHeap.add(e);
        }

        if(maxHeap.size() - minHeap.size() > 1){
            minHeap.add(maxHeap.poll());
        } else if(minHeap.size() - maxHeap.size() > 0) {
            maxHeap.add(minHeap.poll());
        }
    }

    private static float getMedian(){
        if (minHeap.size() == maxHeap.size()){
            return ((float)(minHeap.peek() + maxHeap.peek()))/2;
        } else {
            return maxHeap.peek();
        }
    }
}
