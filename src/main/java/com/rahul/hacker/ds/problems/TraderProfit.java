package com.rahul.hacker.ds.problems;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;

/**
 * Created by 212578960 on 8/19/2017.
 */
public class TraderProfit {

    static int traderProfit(int k, int n, int[] A) {
        int sum = 0;
        int remainCount = k;
        int tradeOn = A[0];
        int tradeOff = 0;
        int lastTradeOff = 0;
        for(int i=1; i<n; i++){
            if(tradeOff != 0 && remainCount > 1 && A[i] < tradeOff){
                sum += tradeOff - tradeOn;
                tradeOn = A[i];
                lastTradeOff = tradeOff;
                tradeOff = 0;
                remainCount--;
            }

            if(A[i] < tradeOn){
                if(tradeOff > 0 && lastTradeOff < tradeOff){
                    sum += tradeOff - lastTradeOff;
                    lastTradeOff = tradeOff;
                }
                tradeOn = A[i];
                tradeOff = 0;
            }

            if(A[i] > tradeOn && tradeOff < A[i]){
                tradeOff = A[i];
            }
        }

        if(remainCount > 0 && tradeOff > tradeOn){
            sum += tradeOff - tradeOn;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int k = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int result = traderProfit(k, n, arr);
            System.out.println(result);
        }
        in.close();
    }
}
