package com.rahul.hacker;

/**
 * Created by 212578960 on 5/23/2017.
 */
public class DayOfTheProgrammer {

    public static void main(String[] args) {
        int year = 2017;
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String result = solve(year, months);
        System.out.println(result);
    }

    static String solve(int year, int[] months){
        StringBuilder sb = new StringBuilder();

        int leapYearFebDays = 29;
        int day = 256;
        if(year < 1918){
            if(year % 4 == 0){
                months[1] = leapYearFebDays;
            }
        }else if(year == 1918){
            return "26.09.1918";
        }else {
            if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
                months[1] = leapYearFebDays;
            }
        }

        int sum = 0;
        int ind = 0;
        while(sum < day){
            sum += months[ind];
            ind++;
        }

        int finalDay = day - (sum - months[ind -1]);
        String dayStr = finalDay < 10 ? "0" + finalDay : "" + finalDay;
        String monthStr = ind < 10 ?  "0" + ind : "" + ind;
        sb.append(dayStr).append(".").append(monthStr).append(".").append(year);
        return sb.toString();
    }
}
