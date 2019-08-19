package com.rahul.hacker.problems;

public class Power {

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        double val = myPower(x, Math.abs(n));
        if (n < 0) {
            return 1/val;
        }

        return val;
    }

    private double myPower(double a, int b) {
        if ( b == 0)        return 1;
        if ( b == 1)        return a;

        if (isEven(b)) {
            return myPower( a * a, b/2);
        }
        else {
            return a * myPower ( a * a, b/2);
        }
    }

    private boolean isEven(int b) {
        return b % 2 == 0;
    }
}
