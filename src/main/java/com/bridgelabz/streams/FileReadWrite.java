package com.bridgelabz.streams;

import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
        String sourceFile = "src/main/java/com/bridgelabz/streams/input";
        String destinationFile = "src/main/java/com/bridgelabz/streams/output";

        // Attempt to read and write the file
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully from " + sourceFile + " to " + destinationFile);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file " + sourceFile + " not found.");
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred.");
            e.printStackTrace();
        }
    }
}
