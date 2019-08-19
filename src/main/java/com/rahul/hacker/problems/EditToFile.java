package com.rahul.hacker.problems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EditToFile {

    public static void main(String[] args) {
        editFile();
    }

    private static void editFile () {

        String PQA_R1_STORE = "14014";
        String PQA_R2_STORE = "5505";
        String QA_R1_STORE = "5505";
        String QA_R2_STORE = "5541";
        String UNKNOWN_STORE = "2203";
        try {
            String filePath = "/Users/r0c01am/Rahul/gif/purge-manager-2.0/records.txt";
            Path path = Paths.get(filePath);
            Stream<String> lines = Files.lines(path);
            List<String> replaced = lines.map(line -> line + "," + QA_R1_STORE).collect(Collectors.toList());
            Files.write(path, replaced);
            lines.close();
            System.out.println("File Edit Completed !!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
