package com.rahul.hacker.problems;

import com.rahul.hacker.util.ScannerUtil;

import java.io.IOException;
import java.util.Scanner;

public class TimeLag {

    // Complete the lagDuration function below.
    static int lagDuration(int h1, int m1, int h2, int m2, int k) {
        int hr1 = h1 + k;

        int diffInMin;
        int diffInHr = hr1 - h2;
        if(m1 < m2){
            diffInMin = 60 - m2;
            diffInMin += m1;
            diffInHr--;
        } else {
            diffInMin = m1-m2;
        }

        diffInMin += diffInHr*60;
        return diffInMin;
    }

    private static final Scanner scanner = ScannerUtil.getScanner();

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] h1M1H2M2 = scanner.nextLine().split(" ");

            int h1 = Integer.parseInt(h1M1H2M2[0]);

            int m1 = Integer.parseInt(h1M1H2M2[1]);

            int h2 = Integer.parseInt(h1M1H2M2[2]);

            int m2 = Integer.parseInt(h1M1H2M2[3]);

            int k = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = lagDuration(h1, m1, h2, m2, k);
            System.out.println(result);
        }


        scanner.close();
    }
}
