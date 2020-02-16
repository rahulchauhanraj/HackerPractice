package com.rahul;

import com.rahul.hacker.problems.EncryptDecrypt;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {

    private static String DOT = "\\.";

    private static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        int av = '9';

        System.out.println(av);

        StringBuilder sb = new StringBuilder();
        sb.insert(sb.length(), '-');

        System.out.println(EncryptDecrypt.encrypt("pass123"));
        String val = null;
        System.out.println(Boolean.parseBoolean(val));
        long a = 101;
        long b = 100;

        //System.out.println(a & b);

        IntStream.range(1000, 2000).parallel().forEach(value -> list.add(value));
        //IntStream.range(2000,3000).parallel().forEach(value -> list.add(value));

        //Thread.sleep(2000);
        System.out.println(list.size());

        //System.out.println((long) Math.pow(2, 23));

        /*String level = "A.B";

        String[] levels = level.split(DOT);
        System.out.println(levels);*/
        /*try {
            File file = new File("/tmp/secret-data-with-description.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            List<String> list = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                if(line.trim().length() > 0) {
                    list.add(line);
                }
            }
            fileReader.close();
            System.out.println("Contents of file:");
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    /*public static void main(String[] args) {

        int[] a = {4,6,8};
        int d =5;

        int gcd = new Main().generalizedGCD(d, a);
        System.out.println(gcd);
    }
*/
    public int generalizedGCD(int num, int[] arr)
    {
        int min = Integer.MAX_VALUE;

        for(int i : arr){
            if(i < min) {
                min = i;
            }
        }

        List<Integer> fact = new ArrayList<>();

        fact.add(1);

        for(int i=2; i <= min; i++){
            if(min%i == 0){
                fact.add(i);
            }
        }

        for(int i : arr){

            List<Integer> fact1 = new ArrayList<>();

            for(int f : fact){
                if(i%f == 0){
                    fact1.add(f);
                }
            }
            fact = fact1;
        }
        int r = 1;
        for(int i = 0; i< fact.size(); i++){
            int v = fact.get(i);
            boolean skip = false;
            for(int j = i+1; j< fact.size(); j++){
                if(fact.get(j) % v == 0){
                   skip = true;
                   break;
                }
            }

            if(!skip){
                r *= v;
            }
        }

        return r;
    }


    /*public static void main(String[] args) {

        int[] a = {1,0,0,0,0,1,0,0};
        int d =1;

        List<Integer> state = new Main().cellCompete(a, d);
        System.out.println(state);
        // 1 0 0 0 0 1 0 0
        // 0 0 0 0 0 1 1 0
    }*/

    public List<Integer> cellCompete(int[] st, int days)
    {

        while(days > 0){

            int[] s = new int[8];

            if(st[1] == 0) {
                s[0] = 0;
            }else {
                s[0] = 1;
            }

            if(st[6] == 0) {
                s[7] = 0;
            }else {
                s[7] = 1;
            }

            for(int i=1; i<7;i++){

                if((st[i-1] == 0 && st[i+1] == 0) || (st[i-1] == 1 && st[i+1] == 1)) {
                    s[i] = 0;
                }else {
                    s[i] = 1;
                }
            }

            st = s;
            days--;
        }
        List<Integer> l = new ArrayList<Integer>();
        for(int v : st){
            l.add(v);
        }
        return l;
    }


    public static int compareVersions(String oldVersionStr, String newVersionStr) {
        String[] oldVersionNumbers = oldVersionStr.trim().split(DOT);
        String[] newVersionNumbers = newVersionStr.trim().split(DOT);

        int count = 0;

        for (String oldVersionNumber : oldVersionNumbers) {

            int oldVersion = Integer.parseInt(oldVersionNumber);
            int newVersion = Integer.parseInt(newVersionNumbers[count]);

            if (oldVersion > newVersion) {
                return 1;
            } else if (oldVersion < newVersion) {
                return -1;
            }

            count++;
        }

        if(count < newVersionNumbers.length) {
            return -1;
        }

        return 0;
    }

    private static void testExecutor() throws Exception{
        ExecutorService service = Executors.newFixedThreadPool(2);

        int i = 0;
        while(i != 1000){
            int val = i;
            service.submit(()-> {System.out.println(val);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            i++;
        }

        service.shutdown();
        while(!service.isShutdown()) {
            service.awaitTermination(100, TimeUnit.MILLISECONDS);
        }
        System.out.println("Shutdown Completed ************************");
    }

    static class DecimalData implements Comparable<DecimalData> {
        BigDecimal d;
        String s;

        DecimalData (BigDecimal d, String s) {
            this.d = d;
            this.s = s;
        }

        public int compareTo(DecimalData data) {
            return this.d.compareTo(data.d);
        }
    }

    private static void sortBigDecimal(){
        int n = 5;

        String[] s = {"0.00", "2.10", "0.0", "-100", "2.00"};

        List<DecimalData> l = new ArrayList<>();

        for(int i =0; i < n; i++){
            l.add(new DecimalData(new BigDecimal(s[i]), s[i]));
        }

        Collections.sort(l);

        for(int i =0; i < n; i++){
            l.add(new DecimalData(new BigDecimal(s[i]), s[i]));
        }
    }











    /*public static void main(String[] args) {
        String[] s = {"6th Jun 1933"};
        reformatDate(s);

    }*/


    static String[] reformatDate(String[] dates) {
        Map<String, String> map = new HashMap<>();

        map.put("Jan" , "01");
        map.put("Feb" , "02");
        map.put("Mar" , "03");
        map.put("Apr" , "04");
        map.put("May" , "05");
        map.put("Jun" , "06");
        map.put("Jul" , "07");
        map.put("Aug" , "08");
        map.put("Sep" , "09");
        map.put("Oct" , "10");
        map.put("Nov" , "11");
        map.put("Dec" , "12");


        String[] result = new String[dates.length];
        int index = 0;
        for(String  s : dates) {
            StringBuilder sb = new StringBuilder();

            String[] date = s.split(" ");
            sb.append(date[2]).append("-");
            sb.append(map.get(date[1])).append("-");
            String day = date[0];
            String d1 = day.substring(0, day.length()-2);
            if(d1.length() == 1){
                sb.append("0").append(d1);
            }else {
                sb.append(d1);
            }

            System.out.println(sb.toString());
            result[index] = sb.toString();
            index++;
        }
        return result;
    }


    /**
     *
     * String s = "I am using hackerrank to improve programming";
     String t = "am hackerrank to improve";

     String[] result = missingWords(s, t);

     for(String s1 : result){
     System.out.println(s1);
     }
     //int[] a = {4,3,2,1,8};
     //int[] a = {7,2,3,10,2,4,8,1};
     //System.out.println(maxDifference(a));
     // 4 3 2 1 8
     // 7          2          3         10         2         4         8         1
     * @param s
     * @param t
     * @return
     */
    static String[] missingWords(String s, String t) {
        String[] s1 = s.split(" ");
        String[] t1 = t.split(" ");

        List<String> list = new ArrayList<>();
        for(int i = 0; i< s1.length; i++){
            String w =s1[i];
            if(w.trim().length() > 0){
                list.add(w.trim());
            }
        }

        List<String> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < t1.length && j< list.size()){
            String w =t1[i];
            w = w.trim();
            if(w.length() > 0){
                while(true) {
                    String wl = list.get(j);
                    if (wl.equals(w)) {
                        j++;
                        break;
                    }else {
                        result.add(wl);
                    }
                    j++;
                }
            }
            i++;
        }

        if(i == t1.length){
            for(int l =j ;l<list.size(); l++){
                result.add(list.get(l));
            }
        }

        return result.toArray(new String[result.size()]);
    }

    static int maxDifference(int[] a) {
        if(a == null || a.length < 2){
            return -1;
        }

        int n = a.length;
        int mdiff = 0;
        int cmin = a[0];
        int cmax = a[0];
        int cdiff = 0;

        for(int i=1; i<n; i++){
            int e = a[i];
            if(e < cmin){
                cmin = a[i];
                cmax = a[i];
                cdiff = 0;
            } else if(e > cmax) {
                cdiff = e-cmin;
            }

            if(cdiff > mdiff){
                mdiff = cdiff;
            }
        }

        return mdiff == 0 ? -1 : mdiff;
    }


    private static void parse(){
        String s = "Hello! this is 1a line. It can't be hard to split into \"words\", can it?";
        String[] ss = s.split(" ");
        int count = 0;
        for (String str : ss) {
            boolean match = str.matches("[a-zA-Z]+");
            if(match) {
                count++;
                System.out.println(str);
            }
        }
        System.out.println(count);
    }
}

