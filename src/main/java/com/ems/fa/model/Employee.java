package com.ems.fa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;				//Import for date of birth

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;			//Additional labels
    private String department;
    //You can add additional fields here
    
    public enum Department {				//Classifying 3 separate departments
        FRONT_END_DEVELOPER, BACK_END_DEVELOPER, TESTING_ENGINEER
    }
    // Default constructor
    public Employee() {
    }

    // Constructor with all fields
    public Employee(String firstName, String lastName, String email, LocalDate dateOfBirth, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth=dateOfBirth;
        this.department=department.name();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    //Aditional get/sets for new fields
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department.name();
    }

    // Add other methods if necessary (e.g., toString(), equals(), hashCode())
}

