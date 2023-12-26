package com.ems.fa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;				//Import for date of birth
import java.time.format.DateTimeFormatter;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String middleName;//NEW
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;			//Additional labels
    private String department;

    //additional fields here
    
    public enum Department {				//Classifying 3 separate departments
        FRONT_END_DEVELOPER("Front End Developer"),
        BACK_END_DEVELOPER("Back End Developer"),
        TESTING_ENGINEER("Testing Engineer");
    	
    	private final String displayName;
    	Department(String displayName){
    		this.displayName=displayName;
    	}
    	public String getDisplayName() {
    		return displayName;
    	}
        // Static method to get enum from display name
        public static Department fromDisplayName(String displayName) {
            for (Department dept : Department.values()) {
                if (dept.getDisplayName().equalsIgnoreCase(displayName)) {
                    return dept;
                }
            }
            throw new IllegalArgumentException("No department with display name " + displayName);
        }
   
    }
    // Default constructor
    public Employee() {
    }
    
    // Constructor with all fields
    public Employee(String firstName,String middleName, String lastName,
    		String email, LocalDate dateOfBirth, String department) {
    	
        this.firstName = firstName;
        this.middleName=middleName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth=dateOfBirth;
        this.department=department;
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

    public String getMiddleName() {
    	return middleName;
    }
    
    public void setMiddleName(String middleName) {
    	this.middleName=middleName;
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
    //Defining DOB Format
    public String getFormattedDateOfBirth() {
        if (this.dateOfBirth == null) {
            return null;
        }
        return this.dateOfBirth.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    // Add other methods if necessary (e.g., toString(), equals(), hashCode())
}

