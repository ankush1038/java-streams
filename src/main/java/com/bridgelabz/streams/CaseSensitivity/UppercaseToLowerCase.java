package com.bridgelabz.streams.CaseSensitivity;

import java.io.*;

public class UppercaseToLowerCase {
    public static void main(String[] args) {
        String inputFile = "src/main/java/com/bridgelabz/streams/caseSensitivity/input";
        String outputFile = "src/main/java/com/bridgelabz/streams/caseSensitivity/output";

        try{
            convertUppercaseToLowerCase(inputFile,outputFile);
            System.out.println("UpperCase converted to lowercase successfully");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void convertUppercaseToLowerCase(String inputFile, String outputFile) throws IOException{
        try(BufferedReader read = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){

                String word;
                while((word = read.readLine()) != null){
                    writer.write(word.toLowerCase());
                    writer.newLine();
                }
            }
    }
}
