/*
 * File             : UserDTO.java
 * Authors          : Antoine Drabble & Guillaume Serneels
 * Last Modified    : 21.10.2016
 */
package com.heig.amt.webapp.rest.dto;

/**
 * The User Data Transfer Object representing an User, this DTO contains only
 * the username, the email adress and the first and last names of the user and 
 * not the password
 * @author Antoine Drabble antoine.drabble@heig-vd.ch
 * @author Guillaume Serneels guillaume.serneels@heig-vd.ch
 */
public class UserDTO {

    private String username;
    private String email;
    private String firstname;
    private String lastname;

    public UserDTO(){
        
    }
    /**
     * Creates the Data Transfer Object
     * @param username the user's chosen username
     * @param email the user's email adress
     * @param firstname the user's first name
     * @param lastname the user's laste name
     */
    public UserDTO(String username, String email, String firstname, String lastname) {
        this.username = username;
        this.email = email;
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
    
}
