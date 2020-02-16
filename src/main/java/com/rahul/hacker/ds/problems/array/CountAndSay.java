package com.rahul.hacker.ds.problems.array;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(5));
    }

    public String countAndSay(int n) {

        return countAndSay("1", n);
    }

    private String countAndSay(String s, int n){

        if(n == 1){
            return s;
        }

        Character last = null;
        int count = 1;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);;

            if(last != null){

                if(c == last){
                    count++;
                }else{
                    sb.append(count).append(last);
                    last = c;
                    count = 1;
                }
            }else {
                last = c;
            }
        }

        sb.append(count).append(last);

        return countAndSay(sb.toString(), n-1);
    }
}
