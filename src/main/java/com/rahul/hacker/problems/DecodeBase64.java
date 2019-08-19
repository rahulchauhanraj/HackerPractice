package com.rahul.hacker.problems;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

public class DecodeBase64 {

    public static void main(String args[]) {
        String data = "WF3WN3vIzUAcQXzqZp0lQg";
        byte[] b = data.getBytes(UTF_8);
        byte[] encoded = Base64.getEncoder().encode(b);
        String string = new String(encoded, StandardCharsets.UTF_8);
        System.out.println(string);

        byte[] decoded = Base64.getDecoder().decode(encoded);

        string = new String(decoded, StandardCharsets.UTF_8);
        System.out.println(string);

    }
}
