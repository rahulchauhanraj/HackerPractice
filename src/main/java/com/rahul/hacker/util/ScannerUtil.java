package com.rahul.hacker.util;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by 212578960 on 5/24/2017.
 */
public class ScannerUtil {

    public static Scanner getScanner(){
        ClassLoader classLoader = new ScannerUtil().getClass().getClassLoader();
        File file = new File(classLoader.getResource("inputs.txt").getFile());

        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return scanner;
    }

    public static void main(String[] args) {
        getScanner();
    }
}
