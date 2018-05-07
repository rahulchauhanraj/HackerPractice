package com.rahul;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        System.out.println(Integer.toHexString(5).toUpperCase());
        System.out.println(Instant.now().toEpochMilli());
        /*List<String> l = new ArrayList<>();
        Map<String, String> d = l.stream().collect(Collectors.toMap(Function.identity(), e -> e));
        Map<Integer, String> a = new HashMap<>();
        a.put(1, "1");
        Map c =  a.entrySet().parallelStream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        System.out.println(Instant.now().toEpochMilli());

        long ms = (1525456700525L -  1525456594226L);
        System.out.println(ms);
        System.out.println(ms / 1000);*/

        //System.out.println(String.format("The total meal cost is %d dollars.", calculateMealCost(10.25, 17, 5)));
    }

    private static int calculateMealCost(double mealCost, int tipInPercent, int taxInPercent){

        double tip = mealCost * tipInPercent * .01;
        double tax = mealCost * taxInPercent * .01;

        Double totalCost = mealCost + tip + tax;
        System.out.println(tip);
        System.out.println(tax);
        System.out.println(totalCost);
        int intVal = totalCost.intValue();
        double v = intVal + 0.5;
        if(v < totalCost) {
            return intVal + 1;
        } else {
            return intVal;
        }
    }

}
