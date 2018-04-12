package com.rahul.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FutureTest {

    public static void main(String[] args) throws Exception {
        new FutureTest().go();
    }

    private void go() throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(new MakesANetworkCall())
                .whenComplete(new BiConsumer<String, String>() {
                    @Override
                    public void accept(String result, String s) {
                        System.out.println("In accept method");
                        System.out.println(result.toString());
                    }
                })
                .exceptionally(new Function<Exception, Exception>() {
                                   @Override
                                   public Exception apply(Exception e) {
                                       e.printStackTrace();
                                       return e;
                                   }
                               }
                ).thenApplyAsync(new Function<String, String>() {
                    @Override
                    public String apply(String o) {
                        System.out.println("In apply method");
                        System.out.println("Last action of all!");
                        return null;
                    }
                });

        System.out.println("Main thread will sleep");
        Thread.sleep(2500);
        System.out.println("Program over");
    }

    class MakesANetworkCall implements Supplier {

        @Override
        public String get() {
            try {
                System.out.println("Ground control to Major Tom");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new String("Major Tom reporting!");
        }
    }
}
