package com.epam.java8.ExerciseOne;

public class Employee implements Comparable<Employee>{

    private String name;
    private Integer empNumber;
    private String department;

    public Employee() {
    }

    public Employee(Integer empNumber,String name,  String department) {
        this.name       = name;
        this.empNumber  = empNumber;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(Integer empNumber) {
        this.empNumber = empNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", empNumber=" + empNumber +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return o.getName().compareTo(this.getName());
    }
}
