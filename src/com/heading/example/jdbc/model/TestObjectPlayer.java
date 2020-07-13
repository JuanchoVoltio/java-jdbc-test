package com.heading.example.jdbc.model;

public class TestObjectPlayer {

    public String name;
    public String position;
    public int number;
    public int age;
    public int salary;

    @Override
    public String toString(){
        return " Name: " + this.name + " Number: (" + this.number + ")  Position: [" + this.position + "] "
                + "Edad: " + this.age + " Salary: "+ this.salary;
    }
}


