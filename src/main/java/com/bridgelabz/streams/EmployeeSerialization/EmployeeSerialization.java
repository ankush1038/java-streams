package com.bridgelabz.streams.EmployeeSerialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Employee class implementing Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Display employee details
    public void displayEmployee() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: Rs." + salary);
    }
}

public class EmployeeSerialization {
    private static final String FILE_NAME = "src/main/java/com/bridgelabz/streams/employees.ser";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //List of employees
        List<Employee> l = new ArrayList<>();

        // User input for employee details
        System.out.print("Enter number of employees: ");
        int count = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Enter details for Employee " + (i + 1));
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Department: ");
            String department = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            l.add(new Employee(id, name, department, salary));
        }

        // Serialize employee list
        serializeEmployees(l);

        // Deserialize and display employees
        List<Employee> deserializedEmployees = deserializeEmployees();
        if (deserializedEmployees != null) {
            System.out.println("\nDeserialized Employees:");
            for (Employee emp : deserializedEmployees) {
                emp.displayEmployee();
            }
        }
    }

    // Method to serialize employees
    public static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("\nEmployees serialized successfully.");
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }
    }

    // Method to deserialize employees
    public static List<Employee> deserializeEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
            return null;
        }
    }
}
