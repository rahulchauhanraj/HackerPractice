package com.rahul.interviews.microsoft;

/**
 * There are set of values assign to number 0 to 9 as mention over the telephone dial pad.
 *  1 -> Nothing ->1
 *  2 -> ABC
 *  3 -> DEF
 *  4 -> GHI
 *  5 -> JKL
 *  6 -> MNO
 *  7 -> PQRS
 *  8 -> TUV
 *  9 -> WXYZ
 *  0 -> Nothing -> 0
 *
 *  For a given String of Integers print all the combination that can be made with each letter of that number.
 *  e.g. 12
 *
 *  1 A
 *  1 B
 *  1 C
 *
 *  e.g. 123
 *
 *  1 A D
 *  1 A E
 *  1 A F
 *  1 B D
 *  1 B E
 *  1 B F
 *  1 C D
 *  1 C E
 *  1 C F
 *
 *  String length could be between 1 to 1000.
 */


public class PrintAllCombination {
    private static char[][] a = {{'0'}, {'1'}, {'A', 'B', 'C'}, {'D','E','F'}, {'G','H','I'}, {'J','K','L'}, {'M','N','O'}, {'P','Q','R','S'}, {'T','U','V'}, {'W','X','Y','Z'}};

    public static void main(String[] args){
        String s = "23761";
        StringBuilder sb = new StringBuilder();
        printAllCombination(s, 0, sb);
    }

    private static void printAllCombination(String s, int index, StringBuilder sb){
        if(index >= s.length()){
            System.out.println(sb);
            return;
        }
        int v = Integer.parseInt(String.valueOf(s.charAt(index)));
        char[] chars = a[v];

        for(char ch : chars) {
            sb.append(ch);
            printAllCombination(s, index + 1, sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
