/*
 * File             : UserLoginDTO.java
 * Authors          : Antoine Drabble & Guillaume Serneels
 * Last Modified    : 21.10.2016
 */
package com.heig.amt.webapp.rest.dto;

/**
 * The User Data Transfer Object representing an User used for registering and 
 * Login, this DTO contains all the attributes of an user (the username, 
 * the email adress and the first and last names) and also the user's password
 * @author Antoine Drabble antoine.drabble@heig-vd.ch
 * @author Guillaume Serneels guillaume.serneels@heig-vd.ch
 */
public class UserLoginDTO {

    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;

    public UserLoginDTO(){
        
    }
    
    public UserLoginDTO(String username, String password, String email, String firstname, String lastname) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
