package com.rahul.interviews.atlassian;

public class RobotFillingBoxes {

    public static void main(String[] args) {
        print("PMLPLPMMLPMMLPMMLPMMLPMMLPMMLPMMLPMMLPMMLPMMLPMMLPMMLPMMLPMMLPMMLPMML");
    }

    private static void print(String s){
        int[] a = new int[10];
        int ind = 0;
        boolean hold = false;
        for (int i =0; i< s.length(); i++){
            char ch = s.charAt(i);

            switch (ch){
                case 'P' :
                    hold = true;
                    ind = 0;
                    break;
                case 'M' :
                    if(ind < 9){
                        ind++;
                    }
                    break;
                case 'L' :
                    if(hold && a[ind] != 15) {
                        a[ind] += 1;
                        hold = false;
                    }
                    break;
                default:
                    break;
            }
        }

        for (int i = 0; i<a.length; i++){
            System.out.print(Integer.toHexString(a[i]).toUpperCase());
        }
    }
}
