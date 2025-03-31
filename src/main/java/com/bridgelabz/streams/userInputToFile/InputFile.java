package com.bridgelabz.streams.userInputToFile;

import java.io.*;

public class InputFile {
    public static void main(String[] args) {
        String outputFile = "src/main/java/com/bridgelabz/userInputToFile/output";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(outputFile)) {

            System.out.println("Enter your name: ");
            String name = reader.readLine();

            System.out.println("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");

            System.out.println("User data has been saved to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred.");
            e.printStackTrace();
        }
    }
}
