package com.rahul.interviews.atlassian;

public class StringParser {

    public static void main(String[] args) {
        String s = validate("|name~|address~|~n|Patrick|patrick@test.com|pat@test.com|~n|Annie|annie@test.com|~n|Zoe|~n");
        System.out.println(s);
    }

    static String validate(String input) {
        //input = input.replaceAll("~|", "|");
        //input = input.replaceAll("~~", "~");
        String[] s = input.split("~n");

        int count = s.length -1;
        int num = 0;
        int[] a = new int[s.length];

        for(int j = 0; j< s.length; j++)  {
            Character last = null;
            int max = 0;
            for(int i =0 ; i< s[j].length(); i++){
                String sj = s[j];
                char ch = sj.charAt(i);
                if(last != null && (ch == '~' || ch == '|') && (last != '~' && last != '|')){
                    max++;
                    if(max> num){
                        num = max;
                    }
                }
                last = ch;
            }
            a[j] = max;
        }

        int empty = 0;
        for(int i =1; i<a.length; i++){
            empty += num - a[i];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count).append(":").append(num).append(":").append(empty).append(":").append("address_").append(num-a[0]);
        return sb.toString();
    }
}
