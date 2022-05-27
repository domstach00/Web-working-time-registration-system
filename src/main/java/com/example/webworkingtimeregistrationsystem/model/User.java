package com.example.webworkingtimeregistrationsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class User {
    private int idU;
    @Pattern(regexp=".+@.+\\.[a-z]+", message="Invalid email address!")
    private String email;
    @NotBlank
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNr;
    private Integer fk_role = 1;

    public User(@JsonProperty("email") String email,
                @JsonProperty("password") String password,
                @JsonProperty("firstName") String firstName,
                @JsonProperty("lastName") String lastName,
                @JsonProperty("phoneNr") String phoneNr,
                @JsonProperty("fk_role") Integer fk_role) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNr = phoneNr;
        if (fk_role == null)
            fk_role = 1;
        this.fk_role = fk_role;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public void setFk_role(Integer fk_role) {
        this.fk_role = fk_role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public int getFk_role() {
        return fk_role;
    }

    public void setFk_role(int fk_role) {
        this.fk_role = fk_role;
    }
}
