package com.rahul.hacker.ds.problems.string;

public class ImplementStrStr {


    public static void main(String[] args) {
        System.out.println(new ImplementStrStr().strStr("heltesoltesltesto", "test"));
    }

    public int strStr(String h, String n) {

        if (n == null || n.length() == 0) {
            return 0;
        }

        if (h == null || h.length() == 0) {
            return -1;
        }

        int i = 0;

        while (i < h.length()) {

            if (h.charAt(i) == n.charAt(0)) {

                int j = i + 1;
                int k = 1;

                while (j < h.length() && k < n.length()) {
                    if (h.charAt(j) != n.charAt(k)) {
                        break;
                    }
                    j++;
                    k++;
                }

                if(k == n.length()){
                    return i;
                }
            }

            i++;
        }

        return -1;
    }
}
