package org.example;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Exercise2 {

    public static void main(String[] args) {
        String directory = "src" + File.separator + "main" + File.separator + "resources"; // Modifica si cal
        listDirectoryTree(directory, 0);
    }

    public static void listDirectoryTree(String directory, int level) {
        File path = new File(directory);

        if (path.exists() && path.isDirectory()) {
            String[] files = path.list();
            if (files != null) {
                Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
                for (String file : files) {
                    File currentFile = new File(path, file);
                    String type = currentFile.isDirectory() ? "D" : "F";
                    SimpleDateFormat lastModification = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    String lastModified = lastModification.format(currentFile.lastModified());
                    System.out.println("  ".repeat(level) + type + " " + file + " (Last Modified: " + lastModified + ")");

                    if (currentFile.isDirectory()) {
                        listDirectoryTree(currentFile.getAbsolutePath(), level + 1);
                    }
                }
            } else {
                System.out.println("The directory is empty");
            }
        } else {
            System.out.println("The directory " + directory + " doesn't exist");
        }
    }
}
