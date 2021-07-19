package com.learning.java.serialization;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        Employee emp1 = new Employee("A", "B", 23);
        Manager m1 = new Manager("M","N",46, "IT");
        try {
            FileOutputStream fos = new FileOutputStream(new File("manager.ser"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(m1);
            System.out.println(m1);

            FileInputStream fis = new FileInputStream(new File("manager.ser"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            Employee emp2 = (Employee) ois.readObject();
            System.out.println(emp2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


class Employee implements Serializable {
    String firstName, lastName;
    int age;

    public Employee(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

class Manager extends Employee {

    String department;

    public Manager(String firstName, String lastName, int age, String department) {
        super(firstName, lastName, age);
        this.department = department;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        throw new NotSerializableException("Serialization not supported");
    }

    private void readObject(ObjectInputStream ois) throws IOException {
        throw new NotSerializableException("Serialization not supported");
    }

    @Override
    public String toString() {
        return "Manager{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }
}