package com.rahul.hacker;

/**
 * Created by 212578960 on 5/23/2017.
 */
public class CartesianCountry {
    static long getMaxBridges(long x1, long y1, long x2, long y2, long xC, long yC){
        long sum = 0;

        int round = 0;

        long lx = xC - 1;
        long ly = yC;

        long rx = xC + 1;
        long ry = yC;

        long ux = xC;
        long uy = yC + 1;

        long dx = xC;
        long dy = yC - 1;

        boolean loop = true;
        int oneSideValue = 0;
        while(loop){
            round++;
            boolean match = false;
            if(isExist(lx, ly , x1, y1, x2, y2)
                    && isExist(rx, ry , x1, y1, x2, y2)
                    && isExist(ux, uy , x1, y1, x2, y2)
                    && isExist(dx, dy , x1, y1, x2, y2)){
                sum += round * 4;
                oneSideValue = round * 2 +1;
                match = true;
            }else if(isExist(lx, ly , x1, y1, x2, y2)
                    && isExist(rx, ry , x1, y1, x2, y2)){
                if(oneSideValue == 0){
                    oneSideValue = 1;
                }
                sum += oneSideValue;
                match = true;
            }else if(isExist(ux, uy , x1, y1, x2, y2)
                    && isExist(dx, dy , x1, y1, x2, y2)){
                if(oneSideValue == 0){
                    oneSideValue = 1;
                }
                sum += oneSideValue;
                match = true;
            }
            lx--;
            dy--;
            rx++;
            uy++;
            loop = match;
        }

        return sum;
    }

    static boolean isExist(long x, long y, long x1, long y1, long x2, long y2){
        if(x >= x1 && x <= x2 && y >= y1 && y <= y2){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        long x1 = 1;
        long y1 = 1;
        long x2 = 5;
        long y2 = 4;
        long xC = 3;
        long yC = 1;
        long result = getMaxBridges(x1, y1, x2, y2, xC, yC);
        System.out.println(result);

       /* long x1 = -100000000;
        long y1 = -10;
        long x2 = 100000000;
        long y2 = 0;
        long xC = -2;
        long yC = -2;
        long result = getMaxBridges(x1, y1, x2, y2, xC, yC);
        System.out.println(result);*/
    }
}
