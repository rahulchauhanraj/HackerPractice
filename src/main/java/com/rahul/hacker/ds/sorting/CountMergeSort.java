package com.rahul.hacker.ds.sorting;

import com.rahul.hacker.util.ScannerUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CountMergeSort {
    private static long countInversions(int[] a) {
        int ind = 0;
        List<Element> l = new ArrayList<>();
        for(int d : a){
            l.add(new Element(d, ind));
            ind++;
        }
        long count = 0;
        Collections.sort(l);
        ind = 0;
        for(Element e : l){
            count += Math.abs(e.ind - ind);
            ind++;
        }
        return count/2;
    }

    private static long countInversions1(int[] a) {
        int count = 0;
        int l = a.length;

        for(int i = 0; i<l-1; i++){
            for(int j = i+1; j<l; j++){
                if(a[i] > a[j]){
                    count++;
                }
            }
        }
        return count;
    }

    private static long countInversions2(int[] a) {
        long[] count = {0};
        int[] sorted = divideConcur(a, 0, a.length-1, count);
        return count[0];
    }

    private static int[] divideConcur(int[] a, int start, int end, long[] count) {
        if(start == end) {
            int[] a1 = {a[start]};
            return a1;
        }

        int mid = start + (end - start)/2;
        int[] left = divideConcur(a, 0, mid, count);
        int[] right = divideConcur(a, mid+1, end, count);

        return merge(left, right, count);
    }

    private static int[] merge(int[] a, int[] b, long[] count) {
        int[] c = new int[a.length + b.length];
        int left = 0;
        int right = 0;
        int i = 0;
        while(left < a.length && right < b.length){
            if(a[left] <= b[right]){
                c[i] = a[left];
                left++;
            } else {
                count[0] += a.length - left;
                c[i] = b[right];
                right++;
            }
            i++;
        }
        if(left < a.length){
            while(left < a.length){
                c[i] = a[left];
                left++;
                i++;
            }
        }

        if(right < b.length){
            while(right < b.length){
                c[i] = b[right];
                right++;
                i++;
            }
        }

        System.out.println(c);
        return c;
    }


    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            long result = countInversions(arr);
            System.out.println(result);

            long result1 = countInversions1(arr);
            System.out.println(result1);

            long result2 = countInversions2(arr);
            System.out.println(result2);
        }
        in.close();
    }

    static class Element implements Comparable<Element>{
        int data;
        int ind;

        public Element(int data, int ind) {
            this.data = data;
            this.ind = ind;
        }

        @Override
        public int compareTo(Element o) {
            return Integer.compare(this.data, o.data);
        }
    }
}
