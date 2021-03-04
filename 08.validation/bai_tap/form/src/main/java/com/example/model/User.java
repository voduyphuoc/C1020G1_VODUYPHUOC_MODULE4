package com.example.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity(name = "user")
public class  User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "firstName not null")
    @Size(min = 1,max = 45)
    private String firstName;

    @NotEmpty(message = "lastName not null")
    @Size(min = 1,max = 45)
    private String lastName;

    @NotEmpty(message = "phoneNumber not null")
    @Pattern(regexp = "(09)\\d{8}",message = "phoneNumber wrong form 09********")
    private String phoneNumber;

    @NotEmpty(message = "age not null")
    @Min(18)
    private String age;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
