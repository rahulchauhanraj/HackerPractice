package com.rahul.hacker.ds.problems;

import com.rahul.hacker.util.ScannerUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by 212578960 on 5/27/2017.
 */
public class SimpleFileCommands {

    static Map<String, FileInfo> files = new HashMap<>();
    static class FileInfo{
        String name;
        int lastNumber;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        public FileInfo(String name){
            this.name = name;
            this.lastNumber = 0;
        }

        public int create(){
            if(queue.isEmpty()){
                return lastNumber++;
            }else{
                return queue.remove();
            }
        }

        public void delete(int number){
            queue.add(number);

            if(queue.size() == lastNumber){
                lastNumber = 0;
                queue.clear();
            }
        }
    }

    enum Operation{crt, del, rnm}

    private static String create(String name){
        FileInfo info = files.get(name);
        if(info == null){
            info = new FileInfo(name);
            files.put(name, info);
        }
        int num = info.create();

        if(num == 0){
            return name;
        }else {
            return name + "("+ num+")";
        }
    }

    private static String delete(String name){
        int index =  name.indexOf("(");
        String fileName;
        int number = 0;
        if(index == -1){
            fileName = name;
        }else{
            fileName = name.substring(0, name.indexOf("("));
            number = Integer.parseInt(name.substring(name.indexOf("(")+1, name.indexOf(")")));
        }
        FileInfo info = files.get(fileName);
        info.delete(number);
        return name;
    }

    private static String rename(String oldName, String newName){
        String deleted = delete(oldName);
        String created = create(newName);
        return deleted + " -> " + created;
    }

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String command = in.next();
            Operation opr = Operation.valueOf(command);
            String file = null;
            switch (opr){
                case crt :
                    file = create(in.next());
                    System.out.println("+ " + file);
                    break;
                case del :
                    file = delete(in.next());
                    System.out.println("- " + file);
                    break;
                case rnm :
                    file = rename(in.next(), in.next());
                    System.out.println("r " + file);
                    break;
            }

        }
    }
}
