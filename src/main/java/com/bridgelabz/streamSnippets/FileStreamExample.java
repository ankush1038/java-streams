package com.bridgelabz.streamSnippets;

import java.io.*;

public class FileStreamExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("src/main/java/com/bridgelabz/streamSnippets/input");
             FileOutputStream fos = new FileOutputStream("src/main/java/com/bridgelabz/streamSnippets/output")) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
