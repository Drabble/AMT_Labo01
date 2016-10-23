/*
 * File             : UserLoginDTO.java
 * Authors          : Antoine Drabble & Guillaume Serneels
 * Last Modified    : 21.10.2016
 */
package com.heig.amt.webapp.rest.dto;

/**
 * The User Data Transfer Object representing an User used for registering and
 * Login, this DTO contains all the attributes of an user (the username, the
 * email address and the first and last names) and also the user's password
 *
 * @author Antoine Drabble antoine.drabble@heig-vd.ch
 * @author Guillaume Serneels guillaume.serneels@heig-vd.ch
 */
public class UserLoginDTO {

    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;

    public UserLoginDTO() {

    }

    public UserLoginDTO(String username, String password, String email, String firstname, String lastname) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * Returns the username
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

        /**
         * Set the username
         *
         * @param username the username to set
         */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the email address
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address
     *
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the user's first name
     *
     * @return the first name
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Set the user's first name
     *
     * @param firstname the first name to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Returns the user's last name
     *
     * @return the last name
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Set the user's last name
     *
     * @param lastname the last name to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
