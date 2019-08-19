package com.rahul;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestMain {

    public static void main(String[] args) {

        System.out.println(Integer.valueOf('a'));
        System.out.println(Integer.valueOf('z'));
        int[] a = {1,2,3,4,5,6,7,8};
        List<Integer> l = Arrays.stream(a).boxed().collect(Collectors.toList());

        String s = StringUtils.join(l, ",");
        System.out.println(s);
    }

    public int sum(int a, int b) {
        return a+b;
    }

    public long sum(long a, long b) {
        return a+b;
    }
}
