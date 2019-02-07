package com.rahul.problems;

import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class WriteToFile {

    public static void main(String[] s) throws Exception {

        String fileName = "/tmp/file.txt";

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), UTF_8))) {

            long start = 68342488;
            int count = 50;
            int index = 0;

            while (index < count) {
                writer.write(String.valueOf(start + index));
                writer.write("\n");
                index++;
            }
        }
    }
}
