package com.example.studentmanagement;

import java.io.Serializable;

public class StudentModel implements Serializable {

    int ID;
    String Name;
    int Age;
    String Address;
    public StudentModel(String name, int age, String address) {
        Name = name;
        Age = age;
        Address = address;
    }

    public StudentModel(int ID, String name, int age, String address) {
        this.ID = ID;
        Name = name;
        Age = age;
        Address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }




}
