package com.bridgelabz.streams.StudentDetails;

import java.io.*;

public class StudentsData {
    public static void main(String[] args) {
        String fileName = "src/main/java/com/bridgelabz/streams/StudentDetails/studentsData.bin";

        // Store student details in a binary file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            // Roll Number
            dos.writeInt(1038);
            // Name
            dos.writeUTF("Ankush Sharma");
            // GPA
            dos.writeDouble(4.35);

            dos.writeInt(1009);
            dos.writeUTF("Akshit Chauhan");
            dos.writeDouble(3.87);

            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing data: " + e.getMessage());
        }

        // Retrieve student details from the binary file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.err.println("Error reading data: " + e.getMessage());
        }
    }
}