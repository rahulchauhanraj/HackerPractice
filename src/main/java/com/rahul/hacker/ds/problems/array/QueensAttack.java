package com.rahul.hacker.ds.problems.array;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 212578960 on 8/26/2017.
 */
public class QueensAttack {

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();
        int k = in.nextInt();
        int rQueen = in.nextInt() - 1;
        int cQueen = in.nextInt() - 1;

        int left = cQueen;
        int right = n - cQueen -1;
        int up = rQueen;
        int down = n - rQueen -1;

        int leftUp = Math.min(rQueen, cQueen);
        int upRight = Math.min(rQueen, (n-cQueen)-1);
        int rightDown = Math.min((n-rQueen)-1, (n-cQueen)-1);
        int downLeft = Math.min((n-rQueen)-1, cQueen);

        for(int a0 = 0; a0 < k; a0++){
            int rObstacle = in.nextInt() -1;
            int cObstacle = in.nextInt() -1;

            if(rObstacle == rQueen){
                if(cObstacle < cQueen){
                    left = Math.min(left, (cQueen - cObstacle) - 1);
                }else{
                    right = Math.min(right, (cObstacle - cQueen) - 1);
                }
            }else if (cObstacle == cQueen){
                if(rObstacle < rQueen){
                    up = Math.min(up, (rQueen - rObstacle) - 1);
                }else{
                    down = Math.min(down, (rObstacle - rQueen) - 1);
                }
            }else{
                int absDiff1 = Math.abs(rObstacle - rQueen);
                int absDiff2 = Math.abs(cObstacle - cQueen);
                if(absDiff1 == absDiff2){
                    if(rObstacle < rQueen){
                        if(cObstacle < cQueen){
                            leftUp = Math.min(leftUp, absDiff1 - 1);
                        }else{
                            upRight = Math.min(upRight, absDiff1 - 1);
                        }
                    }else{
                        if(cObstacle < cQueen){
                            downLeft = Math.min(downLeft, absDiff1 - 1);
                        }else{
                            rightDown = Math.min(rightDown, absDiff1 - 1);
                        }
                    }
                }
            }
        }

        long count = left + right + up + down + leftUp + upRight+ rightDown + downLeft;
        System.out.println(count);
        in.close();
    }
}
