package com.rahul.hacker.ds.problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 212578960 on 6/11/2017.
 */
public class DivisorExploration {
    static List<Integer> primes = new ArrayList<>(Arrays.asList(new Integer[]{2}));

    static int divisorExploration(int m, int a, int d){
        BigInteger n = calculateN(m, a);
        System.out.println("N value is : " + n);
        //BigInteger t = new BigInteger("25325");
        //[1, 5, 25, 1013, 5065, 25325]
        List<BigInteger> allLeafDivisors = getAllLeafDivisors(d, n);
        //List<BigInteger> allLeafDivisors = getAllLeafDivisors(1, t);
        System.out.println(allLeafDivisors.size());
        System.out.println(allLeafDivisors);
        return calculateMagicSum(allLeafDivisors);
        //return 1;
    }

    private static int calculateMagicSum(List<BigInteger> allLeafDivisors){
        Map<String, BigInteger> magicValues = new HashMap<>();
        BigInteger sum = new BigInteger("0");

        for (BigInteger div : allLeafDivisors) {
            sum = sum.add(getMagicValue(div, magicValues));
        }

        return sum.remainder(new BigInteger("1000000007")).intValue();
    }

    private static BigInteger getMagicValue(BigInteger divisor, Map<String, BigInteger> magicValues){
        String key = divisor.toString();
        if(magicValues.containsKey(key)){
            return magicValues.get(key);
        }

        BigInteger magicValue = new BigInteger("1");
        BigInteger inc = new BigInteger("1");
        BigInteger num = new BigInteger("2");

        while(num.compareTo(divisor) < 1){
            BigInteger gcd = divisor.gcd(num);
            if(gcd.compareTo(inc) < 1){
                magicValue = magicValue.add(inc);
            }
            num = num.add(inc);
        }
        magicValues.put(key, magicValue);
        return magicValue;
    }

    private static List<BigInteger> getAllLeafDivisors(int d, BigInteger n){
        int start = 0;
        List<BigInteger> divisor = new ArrayList<>();
        divisor.add(n);
        Map<String, List<BigInteger>> divisors = new HashMap<>();
        while(start != d){
            List<BigInteger> newDivisor = new ArrayList<>();
            for(BigInteger div : divisor){
                newDivisor.addAll(getListOfDivisors(div, divisors));
            }
            divisor = newDivisor;
            start++;
        }
        return divisor;
    }

    static BigInteger calculateN(int m, int a){
        BigInteger n = new BigInteger("1");

        List<List<Integer>> leafs = new ArrayList<>();
        leafs.add(new ArrayList(Arrays.asList(new Integer[]{1})));
        for(int i=1; i <= m; i++){
            updatePrimes(i);
            int prime = primes.get(i-1);
            //System.out.println(prime);
            long num = 1;
            List<List<Integer>> leafsIn = new ArrayList<>();
            for(int j =1; j<=a+i; j++){
                num = num*prime;
                List<Integer> leafIn2 = new ArrayList<>();
                for(int k = 0;k<j; k++){
                    leafIn2.add(prime);
                }
                leafsIn.add(leafIn2);
                /*for(List<Integer> leaf : leafs){
                    for(List<Integer> leafIn : leafsIn){
                        leafIn.addAll(leaf);
                    }
                }
                leafsIn.add(leafIn2);*/
            }

            List<List<Integer>> newLeafs = new ArrayList<>();
            for(List<Integer> leaf : leafs){
                for(List<Integer> leafIn : leafsIn){
                    List<Integer> newLeaf = new ArrayList<>();
                    newLeaf.addAll(leaf);
                    newLeaf.addAll(leafIn);
                    newLeafs.add(newLeaf);
                }
            }

            leafs.addAll(newLeafs);
            BigInteger bi = new BigInteger(String.valueOf(prime));
            bi = bi.pow(a+i);
            n = n.multiply(bi);
        }

        System.out.println("Leafs Size : " + leafs.size());
        System.out.println(leafs);
        return n;
    }

    private static List<BigInteger> getListOfDivisors(BigInteger n, Map<String, List<BigInteger>> divisors){
        String key = n.toString();
        if(divisors.containsKey(key)){
            return divisors.get(key);
        }
        List<BigInteger> divisor = new ArrayList<>(Arrays.asList(new BigInteger("1")));
        BigInteger inc = new BigInteger("1");
        BigInteger index = new BigInteger("2");
        String zero = "0";
        while(index.compareTo(n) < 1){

            BigInteger div = n.remainder(index);
            if(zero.equals(div.toString())){
                divisor.add(index);
            }
            index = index.add(inc);
        }
        divisors.put(key, divisor);
        return divisor;
    }

    private static void updatePrimes(int c){
        int size = primes.size();
        int last = primes.get(size-1);
        int i = last + 1;
        while(size < c){
            if(isPrime(i)){
                primes.add(i);
                size++;
            }
            i++;
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

    public static void main(String[] args) {
        int m = 2;
        int a = 0;
        int d = 2;
        int result = divisorExploration(m, a, d);
        System.out.println(result);
    }

}
