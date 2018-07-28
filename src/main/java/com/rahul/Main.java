package com.rahul;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] s = {"6th Jun 1933"};
        reformatDate(s);

    }



    static String[] reformatDate(String[] dates) {
        Map<String, String> map = new HashMap<>();

        map.put("Jan" , "01");
        map.put("Feb" , "02");
        map.put("Mar" , "03");
        map.put("Apr" , "04");
        map.put("May" , "05");
        map.put("Jun" , "06");
        map.put("Jul" , "07");
        map.put("Aug" , "08");
        map.put("Sep" , "09");
        map.put("Oct" , "10");
        map.put("Nov" , "11");
        map.put("Dec" , "12");


        String[] result = new String[dates.length];
        int index = 0;
        for(String  s : dates) {
            StringBuilder sb = new StringBuilder();

            String[] date = s.split(" ");
            sb.append(date[2]).append("-");
            sb.append(map.get(date[1])).append("-");
            String day = date[0];
            String d1 = day.substring(0, day.length()-2);
            if(d1.length() == 1){
                sb.append("0").append(d1);
            }else {
                sb.append(d1);
            }

            System.out.println(sb.toString());
            result[index] = sb.toString();
            index++;
        }
        return result;
    }


    /**
     *
     * String s = "I am using hackerrank to improve programming";
     String t = "am hackerrank to improve";

     String[] result = missingWords(s, t);

     for(String s1 : result){
     System.out.println(s1);
     }
     //int[] a = {4,3,2,1,8};
     //int[] a = {7,2,3,10,2,4,8,1};
     //System.out.println(maxDifference(a));
     // 4 3 2 1 8
     // 7          2          3         10         2         4         8         1
     * @param s
     * @param t
     * @return
     */
    static String[] missingWords(String s, String t) {
        String[] s1 = s.split(" ");
        String[] t1 = t.split(" ");

        List<String> list = new ArrayList<>();
        for(int i = 0; i< s1.length; i++){
            String w =s1[i];
            if(w.trim().length() > 0){
                list.add(w.trim());
            }
        }

        List<String> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < t1.length && j< list.size()){
            String w =t1[i];
            w = w.trim();
            if(w.length() > 0){
                while(true) {
                    String wl = list.get(j);
                    if (wl.equals(w)) {
                        j++;
                        break;
                    }else {
                        result.add(wl);
                    }
                    j++;
                }
            }
            i++;
        }

        if(i == t1.length){
            for(int l =j ;l<list.size(); l++){
                result.add(list.get(l));
            }
        }

        return result.toArray(new String[result.size()]);
    }

    static int maxDifference(int[] a) {
        if(a == null || a.length < 2){
            return -1;
        }

        int n = a.length;
        int mdiff = 0;
        int cmin = a[0];
        int cmax = a[0];
        int cdiff = 0;

        for(int i=1; i<n; i++){
            int e = a[i];
            if(e < cmin){
                cmin = a[i];
                cmax = a[i];
                cdiff = 0;
            } else if(e > cmax) {
                cdiff = e-cmin;
            }

            if(cdiff > mdiff){
                mdiff = cdiff;
            }
        }

        return mdiff == 0 ? -1 : mdiff;
    }


    private static void parse(){
        String s = "Hello! this is 1a line. It can't be hard to split into \"words\", can it?";
        String[] ss = s.split(" ");
        int count = 0;
        for (String str : ss) {
            boolean match = str.matches("[a-zA-Z]+");
            if(match) {
                count++;
                System.out.println(str);
            }
        }
        System.out.println(count);
    }
}

