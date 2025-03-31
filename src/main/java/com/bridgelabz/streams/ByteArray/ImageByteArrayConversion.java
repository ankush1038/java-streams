package com.bridgelabz.streams.ByteArray;

import java.io.*;

public class ImageByteArrayConversion {
    public static void main(String[] args) {
        String inputFile = "input.jpg";   // Ensure this file exists
        String outputFile = "output.jpg"; // Output file

        try {
            byte[] fileBytes = convertFileToByteArray(inputFile);
            convertByteArrayToFile(fileBytes, outputFile);
            System.out.println("File successfully converted to byte array and written back.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static byte[] convertFileToByteArray(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            return baos.toByteArray();
        }
    }

    public static void convertByteArrayToFile(byte[] fileBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(fileBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
