package com.rahul.hacker.problems;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import static java.nio.charset.StandardCharsets.UTF_8;

public class WriteToFile {

    public static void main(String[] s) throws Exception {

        String PQA_R1_STORE = "14014";
        String PQA_R2_STORE = "5505";
        String QA_R1_STORE = "5505";
        String QA_R2_STORE = "5541";
        String UNKNOWN_STORE = "2203";

        String fileName = "/Users/r0c01am/Rahul/gif/purge-manager-2.0/records.txt";

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), UTF_8))) {

            long start = 47642354L;
            int count = 10;
            int index = 0;

            while (index < count) {
                writer.write("" + start + index);
                //writer.write(start + index + "," + QA_R1_STORE);
                writer.write("\n");
                index++;
            }
        }
    }

}
