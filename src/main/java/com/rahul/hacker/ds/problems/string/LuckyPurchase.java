package com.rahul.hacker.ds.problems.string;

import com.rahul.hacker.util.ScannerUtil;

import java.util.*;

public class LuckyPurchase {
    public static void main(String[] args) {
        char char4 = '4';
        char char7 = '7';

        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();
        Map<String, Integer> values = new HashMap<>();
        for(int a0 = 0; a0 < n; a0++){
            String s = in.next();
            String val = in.next();
            int count4 = 0;
            int count7 = 0;
            boolean complete =  false;
            for(int i = 0; i < val.length(); i++){
                char charVal = val.charAt(i);
                if (charVal == char4) {
                    count4++;
                }
                else if(charVal == char7) {
                    count7++;
                }
                else {
                    complete = false;
                    break;
                }
                if(i == val.length() - 1) {
                    complete = true;
                }
            }

            if(complete) {
                if(count4 == count7) {
                    values.put(s, Integer.valueOf(val));
                }
            }
        }

        String minValueBook = null;
        int minValue = Integer.MAX_VALUE;
        for(Map.Entry<String, Integer> entry : values.entrySet()) {
            Integer value = entry.getValue();
            if (minValue > value) {
                minValue = value;
                minValueBook = entry.getKey();
            }
        }
        if (minValueBook == null) {
            System.out.println("-1");
        } else {
            System.out.println(minValueBook);
        }
        in.close();
    }
}
