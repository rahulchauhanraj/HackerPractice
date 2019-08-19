package com.rahul.hacker.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class JavaCallback {

    public static void main(String args[]) throws Exception{
        List<String> names = new ArrayList<>();


        TimeUnit.SECONDS.sleep(4);
        CompletableFuture<String> f1 = addNameAsync("Rahul", names, 4);
        CompletableFuture<String> f2 = addNameAsync("Anita", names, 1);
        f1.get();
        f2.get();
        System.out.println(names);
        System.out.println("Main completed.");
    }

    private static CompletableFuture<String> addNameAsync(String name1, List<String> names, long timeout) {
        CompletableFuture<String> welcomeText = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(timeout);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("In async call");
            return name1;
        }).thenApply(name -> {
            names.add(name);
            System.out.println("Adding name to list : " + name);
            return "Hello " + name;
        });
        return welcomeText;
    }
}
