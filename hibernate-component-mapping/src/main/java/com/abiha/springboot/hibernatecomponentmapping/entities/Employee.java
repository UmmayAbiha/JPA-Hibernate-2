package com.abiha.springboot.hibernatecomponentmapping.entities;

//Component Mapping:
//Implement and demonstrate Embedded mapping using employee table having following fields: id, firstName, lastName, age,
// basicSalary, bonusSalary, taxAmount, specialAllowanceSalary.

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    @Embedded
    private Salary salary;

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
