package com.rahul.hacker.ds.problems.array;

import com.rahul.hacker.util.ScannerUtil;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by 212578960 on 8/25/2017.
 */
public class SparseArrays {
    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();

        HashMap<String, Integer> map = new HashMap<>();
        for(int a_i = 0; a_i < n; a_i++){
            String s = in.next();
            Integer val = map.get(s);
            if(val == null){
                map.put(s, 1);
            }else{
                map.put(s, val+1);
            }
        }

        int q = in.nextInt();
        for(int a_i = 0; a_i < q; a_i++){
            String s = in.next();
            Integer val = map.get(s);
            if(val == null){
                val = 0;
            }
            System.out.println(val);
        }
        in.close();
    }
}

