package com.rahul.hacker.ds.problems.string;

/**
 * Created by 212578960 on 5/22/2017.
 */
public class AppendAndDelete {

    public static void main(String[] args) {
        String s = "aaaaaaaaaa";
        String t = "aaaaa";

        int k = 7;

        boolean res = isObtainPossible(s, t, k);

        if(res){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }


    static boolean isObtainPossible(String s, String t, int k){
        int sl = s.length();
        int tl = t.length();
        if(sl + tl <= k){
            return true;
        }

        int min = sl < tl ? sl : tl;
        int ind = 0;

        while(ind < min){
            if(s.charAt(ind) != t.charAt(ind)){
                break;
            }
            ind++;
        }
        int change = tl - ind + sl - ind;
        if(change == k || ((k > change) && (k - change) % 2 == 0)){
            return true;
        }
        return false;
    }
}
