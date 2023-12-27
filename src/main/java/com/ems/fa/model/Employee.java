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
    private String gender;
    private String address_streetAddress;
    private String address_city;
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
    public enum Gender {
        MALE("Male"),
        FEMALE("Female"),
        NON_BINARY("Non-Binary");
    	
    	private final String displayName;
    	Gender(String displayName){
    		this.displayName=displayName;
    	}
    	public String getDisplayName() {
    		return displayName;
    	}
        // Static method to get enum from display name
        public static Gender fromDisplayName(String displayName) {
            for (Gender gender : Gender.values()) {
                if (gender.getDisplayName().equalsIgnoreCase(displayName)) {
                    return gender;
                }
            }
            throw new IllegalArgumentException("Illegal argument " + displayName);
        }
   
    }    
    
    
    // Default constructor
    public Employee() {
    }
    
    // Constructor with all fields
    public Employee(String firstName,String middleName, String lastName,
    		String email, LocalDate dateOfBirth, String department,String gender, String address_streetAddress,
            String address_city) {
    	
        this.firstName = firstName;
        this.middleName=middleName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth=dateOfBirth;
        this.department=department;
        this.gender=gender;
        this.address_streetAddress=address_streetAddress;
        this.address_city=address_city;
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
    
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getAddress_streetAddress() { return address_streetAddress;}
    public void setAddress_streetAddress(String address_streetAddress){this.address_streetAddress=address_streetAddress;}

    public String getAddress_city() { return address_city;}
    public void setAddress_city(String address_city){ this.address_city=address_city;}

    // Add other methods if necessary (e.g., toString(), equals(), hashCode())
}

