package com.rahul.hacker.ds;

import java.util.HashMap;
import java.util.Map;

public class Wissen {

    public static void main (String args[]) {

        System.out.println("Test");
    }

    static class Symbol {
        private String type;
        private double price;
        private int tickCount;
        private double average;

        Symbol(String type) {
            this.type = type;
        }

        private synchronized void putNewPrice(double price) {
            this.price = price;
            average = (average*tickCount + price)/(tickCount + 1);
            tickCount++;
        }

        private synchronized double getAveragePrice() {
            return average;
        }

        private synchronized int getTickCount() {
            return tickCount;
        }

    }
    public static class StatisticsAggregatorImpl {
        Map<String, Symbol> symbolMap = new HashMap<>();

        public void putNewPrice(String symbol, double price) {
            Symbol symbolRecord = getSymbol(symbol);
            symbolRecord.putNewPrice(price);
        }

        public double getAveragePrice(String symbol) {
            Symbol symbolRecord = getSymbol(symbol);
            return symbolRecord.getAveragePrice();
        }

        public int getTickCount(String symbol) {
            Symbol symbolRecord = getSymbol(symbol);
            return symbolRecord.getTickCount();
        }

        private Symbol getSymbol(String symbol) {
            Symbol symbolRecord = symbolMap.get(symbol);
            if (symbolRecord == null) {
                synchronized (this) {
                    if (symbolRecord == null) {
                        symbolRecord = new Symbol(symbol);
                        symbolMap.put(symbol, symbolRecord);
                    }
                }
            }
            return symbolRecord;
        }
    }
}
