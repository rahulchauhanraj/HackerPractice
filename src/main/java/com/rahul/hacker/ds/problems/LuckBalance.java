package com.rahul.hacker.ds.problems;

import com.rahul.hacker.util.ScannerUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 212578960 on 7/4/2017.
 */
public class LuckBalance {
    public static void main(String[] args) {
        Scanner sc = ScannerUtil.getScanner();

        int n = sc.nextInt();
        int k = sc.nextInt();

        long sum = 0;
        List<Integer> importantContests = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int l = sc.nextInt();
            int t = sc.nextInt();
            sum += l;
            if(t == 1){
                importantContests.add(l);
            }
        }

        int size = importantContests.size();
        int win = size - k;
        Collections.sort(importantContests);
        for(int i = 0; i< win; i++){
            sum -= importantContests.get(i)*2;
        }

        System.out.println(sum);
    }
}
