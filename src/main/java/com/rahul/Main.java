package com.rahul;

public class Main {


    // Driver program to test above function
    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        System.out.println("Length is: " + longestPalSubstr(str));
    }

    private static int longestPalSubstr(String s) {
        int max = 1;
        int l = s.length();
        for(int i = 1; i < l; i++){
            // palindrom even
            int j = i-1;
            int k = i;
            int cSum = 0;
            while (j >= 0 && k < l){
                if(s.charAt(j) == s.charAt(k)){
                    cSum += 2;
                }else{
                    break;
                }
                j--;
                k++;
            }

            if(cSum > max) {
                max = cSum;
            }
            cSum = 1;
            j = i-1;
            k = i+1;
            // palindrom odd

            while (j >= 0 && k < l){
                if(s.charAt(j) == s.charAt(k)){
                    cSum += 2;
                }else{
                    break;
                }
                j--;
                k++;
            }

            if(cSum > max) {
                max = cSum;
            }
        }

        return max;
    }
}
