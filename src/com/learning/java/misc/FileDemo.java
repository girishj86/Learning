package com.learning.java.misc;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("keyValueStoarge.txt");
        FileWriter fw = new FileWriter(file);

        for(int i=0;i<5;i++){
            fw.write("k"+i+":v"+i+",");
         }
        fw.flush();
        fw.close();

        FileReader fr = new FileReader(file);
        int data;
        StringBuilder sb = new StringBuilder();
        while((data=fr.read()) != -1){
            sb.append((char)data);
        }
        String content = sb.substring(0,sb.length()-1);
        System.out.println(content);
    }
}
