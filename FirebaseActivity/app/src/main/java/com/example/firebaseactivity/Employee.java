package com.example.firebaseactivity;

public class Employee implements Comparable<Employee> {

    private String lastName, firstName;

    Employee() {
        this.lastName = "empty";
        this.firstName = "empty";
    }

    Employee(String lName, String fName){
        this.lastName = lName;
        this.firstName = fName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Employee emp) {
        if (this.firstName.compareTo(emp.firstName) != 0) {
            return (this.firstName).compareTo(emp.firstName);
        }

        return this.lastName.compareTo(emp.lastName);
    }

    @Override
    public String toString() {
        // return this.lastName + ", " + this.firstName;
        return this.firstName + " " + this.lastName;
    }
}
