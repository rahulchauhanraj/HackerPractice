package com.rahul.interviews.atlassian;

public class ReadAndSay {

    public static void main(String[] args){
        String s = "1222";
        readAndSay(s, 2);
    }

    private static String readAndSay(String s, int count) {
        String str = s;
        for(int i=0; i< count; i++){
            str = readAndSay(str);
            System.out.println(str);
        }
        return str;
    }

    private static String readAndSay(String s) {
        StringBuilder sb = new StringBuilder();
        int l = s.length();
        Character last = null;
        int count = 0;
        for(int i = 0; i< l; i++){
            char ch = s.charAt(i);
            if(last != null && ch != last){
                sb.append(count).append(last);
                count = 0;
            }
            count++;
            last = ch;
        }

        return sb.append(count).append(last).toString();
    }
}
