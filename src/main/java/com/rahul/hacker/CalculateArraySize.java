package com.rahul.hacker;

/**
 * Created by 212578960 on 5/23/2017.
 */
public class CalculateArraySize {

    static int getArrayKb(int n, int[] d){
        int kb = 0;
        long total = 4;
        for(int i=0; i<n;i++){
            total *= d[i];
        }


        Double div = (double)total/1024;
        kb = div.intValue();
        return kb;
    }

    public static void main(String[] args) {
        //  Return the size of the multidimensional array in kilobytes. Return only the integer part.
        int n = 3;
        int[] d = new int[]{25, 30, 70};

        int result = getArrayKb(n, d);
        System.out.println(result);
    }
}
