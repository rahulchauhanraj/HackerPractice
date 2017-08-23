package com.rahul.hacker.ds.problems;

import com.rahul.hacker.util.ScannerUtil;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 212578960 on 8/20/2017.
 *
 * A time series is a series of data points indexed in time order. They are commonly used in the financial world, especially in stock markets.

 In this challenge you are working with a time series of stock prices. You are given  historical records  where the stock at time  had a price . You have to answer  types of  queries of the form :

 For type , given a value , when was the first time that the price of the stock was at least ?
 For type , given a value , what's the maximum price of the stock at a time greater or equal to ?
 If for any of these queries the answer is not defined, i.e. there are no historical records that match the query, the answer is .

 Input Format

 In the first line, there are two space-separated integers  and  denoting the number of historical records and the number of queries, respectively.
 The second line contains  space-separated integers denoting the time-stamps . The next line contains  space-separated integers denoting the price of stock , where  value corresponds to the  time-stamp.
 Next,  lines follow and each of them describes a single query. Each query is given as two space-separated integers. The first of them is either  or  and denotes the type of the query followed by a single integer  denoting the value to be queried.

 Constraints

 for
 Output Format

 For each of the  queries, print the answer on a new line. If the answer is not defined, print .

 Sample Input 0

 5 5
 1 2 4 8 10
 5 3 12 1 10
 1 10
 1 4
 2 8
 2 3
 1 13
 Sample Output 0

 4
 1
 10
 12
 -1
 Explanation 0

 In the sample, there are  data records and  queries to answer. At time  the price was , at time  the price was , at time  the price was , at time  the price was , and finally, at time  the price was .

 In the first query, we are asked for the minimum time at which the price was at least . The answer is  because at this time the price was  and there is no earlier time with a price at least .

 In the second query, we are asked for the minimum time at which the price was at least . The answer is  because the price at this time was  which is greater than .

 In the third query, we are asked for the maximum price at time  or greater. The answer is  because there are two data records with time at least  and the highest price among them is .

 In the fourth query, we are asked for the maximum price at time  or greater. The answer here is .

 In the last query, we are asked for the minimum time at which the price was at least . Since there is no data record with price  or greater, the answer is -1.
 */
public class TimeSeriesQueries1 {

    static class TimeSeriesNode {
        int time;
        int price;
        int maxPriceSoFar;

        public void setMaxPriceRemaining(int maxPriceRemaining) {
            this.maxPriceRemaining = maxPriceRemaining;
        }

        int maxPriceRemaining;

        TimeSeriesNode(int time, int price, int maxPriceSoFar){
            this.time = time;
            this.price = price;
            this.maxPriceSoFar = maxPriceSoFar;
        }

        @Override
        public String toString() {
            return "TimeSeriesNode{" +
                    "time=" + time +
                    ", price=" + price +
                    '}';
        }
    }

    static TimeSeriesNode[] timeSeriesNodes;

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();
        int q = in.nextInt();
        int[] t = new int[n];
        for(int t_i = 0; t_i < n; t_i++){
            t[t_i] = in.nextInt();
        }
        int[] p = new int[n];
        for(int p_i = 0; p_i < n; p_i++){
            p[p_i] = in.nextInt();
        }

        int maxPrice = 0;
        timeSeriesNodes = new TimeSeriesNode[n];
        for(int a = 0; a < n; a++){
            int time = t[a];
            int price = p[a];
            if(price > maxPrice){
                maxPrice = price;
            }
            TimeSeriesNode node = new TimeSeriesNode(time, price, maxPrice);
            timeSeriesNodes[a] = node;
        }

        Integer max = -1;
        for(int i = n-1; i >= 0; i--){
            TimeSeriesNode node = timeSeriesNodes[i];

            if (max <= node.price) {
                max = node.price;
            }

            node.setMaxPriceRemaining(max);
        }

        for(int a0 = 0; a0 < q; a0++){
            int type = in.nextInt();
            int v = in.nextInt();
            if(type == 1){
                int value = getMinTimeIndexForPrice(v);
                if(value != -1) {
                    value = timeSeriesNodes[value].time;
                }
                System.out.println(value);
            }else {
                int value = getMaxValueIndexForPrice(v);
                if(value != -1) {
                    value = timeSeriesNodes[value].maxPriceRemaining;
                }
                System.out.println(value);
            }
        }
        in.close();
    }

    private static int getMaxValueIndexForPrice(int value){
        return findMaxValueIndex(0, timeSeriesNodes.length-1, value);
    }

    private static int findMaxValueIndex(int start, int end, int value){
        while(end >= start){
            if(start == end){
                if(timeSeriesNodes[start].time < value){
                    return -1;
                }else {
                    return start;
                }
            }

            if(start+1 == end){
                if(timeSeriesNodes[start].time >= value){
                    return start;
                }
                if(timeSeriesNodes[start].time < value && timeSeriesNodes[end].time >= value){
                    return end;
                }
                return -1;
            }

            int mid = (start + end) / 2;

            if(timeSeriesNodes[mid].time < value){
                return findMaxValueIndex(mid, end, value);
            }else{
                return findMaxValueIndex(start, mid, value);
            }
        }
        return -1;
    }

    private static int getMinTimeIndexForPrice(int value){
        return findMinTimeIndex(0, timeSeriesNodes.length-1, value);
    }

    private static int findMinTimeIndex(int start, int end, int value){
        while(end >= start){
            if(start == end){
                if(timeSeriesNodes[start].maxPriceSoFar < value){
                    return -1;
                }else {
                    return start;
                }
            }

            if(start+1 == end){
                if(timeSeriesNodes[start].maxPriceSoFar >= value){
                    return start;
                }
                if(timeSeriesNodes[start].maxPriceSoFar < value && timeSeriesNodes[end].maxPriceSoFar >= value){
                    return end;
                }
                return -1;
            }

            int mid = (start + end) / 2;

            if(timeSeriesNodes[mid].maxPriceSoFar < value){
                return findMinTimeIndex(mid, end, value);
            }else{
                return findMinTimeIndex(start, mid, value);
            }
        }
        return -1;
    }
}
