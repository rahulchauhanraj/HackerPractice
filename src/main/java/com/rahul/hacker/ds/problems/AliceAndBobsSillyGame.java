package com.rahul.hacker.ds.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by 212578960 on 5/23/2017.
 */
public class AliceAndBobsSillyGame {

    private static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        int[] a = new int[]{1,2,5};
        int g = 3;
        for(int a0 = 0; a0 < g; a0++){
            int n = a[a0];
            printWinner(n);
        }
    }

    private static void printWinner(int n){
        int l = getPrimeCount(n);

        if(l % 2 == 0){
            System.out.println("Bob");
        }else{
            System.out.println("Alice");
        }
    }

    private static int getPrimeCount(int n){
        if(primes.isEmpty()){
            updatePrimes(1, n);
        }else {
            int last = primes.get(primes.size()-1);
            if(last < n){
                updatePrimes(last, n);
            }
        }
        int size = primes.size();
        int count = 0;
        int num = 0;
        int ind = 0;
        while(num < n && ind < size){
            int val = primes.get(ind);
            if(val <= n){
                count++;
            }
            num = val;
            ind++;
        }
        return count;
    }

    private static void updatePrimes(int s, int e){
        for(int i = s+1; i<=e; i++){
            if(isPrime(i)){
                primes.add(i);
            }
        }
    }

    private static boolean isPrime(int n){
        for(int val : primes){
            if(n % val == 0){
                return false;
            }
        }

        return true;
    }
}
