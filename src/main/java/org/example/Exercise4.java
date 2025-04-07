package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Exercise4 {

    public static void main(String[] args) {
        String directory = "src" + File.separator + "main" + File.separator + "resources";
        String outputFilePath = "output.txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            listDirectoryTree(directory, 0, writer);
            writer.close();
            System.out.println("Directory tree has been saved to " + outputFilePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
        
        String filePath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "exercici4.txt"; // Modifica amb el nom del teu fitxer
        readTextFile(filePath);
    }

    public static void listDirectoryTree(String directory, int level, BufferedWriter writer) {
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

                    try {
                        writer.write("  ".repeat(level) + type + " " + file + " (Last Modified: " + lastModified + ")");
                        writer.newLine();
                    } catch (IOException e) {
                        System.out.println("An error occurred while writing to the file: " + e.getMessage());
                    }

                    if (currentFile.isDirectory()) {
                        listDirectoryTree(currentFile.getAbsolutePath(), level + 1, writer);
                    }
                }
            } else {
                try {
                    writer.write("The directory is empty");
                    writer.newLine();
                } catch (IOException e) {
                    System.out.println("An error occurred while writing to the file: " + e.getMessage());
                }
            }
        } else {
            try {
                writer.write("The directory " + directory + " doesn't exist");
                writer.newLine();
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file: " + e.getMessage());
            }
        }
    }

    public static void readTextFile(String filePath) {
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("The file " + filePath + " doesn't exist or is not a file.");
        }
    }
}
