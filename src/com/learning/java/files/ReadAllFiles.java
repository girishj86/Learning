package com.learning.java.files;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadAllFiles {

    public static void main(String[] args) {
        readAllFiles("C:\\Projects\\microservices-examples\\api-gateway\\src");
    }

    public static void readAllFiles(String path){
        Map<String,List<String>> folderStructure = new HashMap<>();
        File file = new File(path);
        getAllFiles(folderStructure,file);
        for(Map.Entry<String,List<String >> entry:folderStructure.entrySet()){
            System.out.println(entry.getKey()+"=="+entry.getValue());
        }
    }

    public static void getAllFiles(Map<String,List<String>> folderStructure, File folder){
        File[] files = folder.listFiles();
        for (File file : files) {
            if (!file.isDirectory()) {
                List<String> fileNames = null;
                if(folderStructure.containsKey(file.getParent())){
                    fileNames = folderStructure.get(file.getParent());
                    fileNames.add(file.getName());
                } else {
                    fileNames = new ArrayList<>();
                    fileNames.add(file.getName());
                }
                folderStructure.put(file.getParent(),fileNames);
            } else {
                getAllFiles(folderStructure, file);
            }
        }
    }
}
