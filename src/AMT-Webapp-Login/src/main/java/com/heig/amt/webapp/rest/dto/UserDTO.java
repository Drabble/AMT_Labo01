/*
 * File             : UserDTO.java
 * Authors          : Antoine Drabble & Guillaume Serneels
 * Last Modified    : 21.10.2016
 */
package com.heig.amt.webapp.rest.dto;

/**
 *
 * @author antoi
 */
public class UserDTO {

    private String username;
    private String email;
    private String firstname;
    private String lastname;

    public UserDTO(){
        
    }
    
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
