package org.example;

import java.io.File;
import java.util.Arrays;

public class Exercise1 {

    public static void main(String[] args){

        String directory = "src" + File.separator + "main" + File.separator + "resources";
        alphabeticallyOrderedList(directory);
    }

    public static void alphabeticallyOrderedList(String directory) {
        File path = new File(directory);

        if (path.exists() && path.isDirectory()) {
            String[] files = path.list();
            if (files != null) {
                Arrays.sort(files , String.CASE_INSENSITIVE_ORDER);
                System.out.println("Directory content:");
                for (String file : files) {
                    System.out.println(file);
                }
            }else{
                System.out.println("The directory is empty");
            }
        } else {
            System.out.println("The directory " + directory + " doesn't exist");
        }
    }
}