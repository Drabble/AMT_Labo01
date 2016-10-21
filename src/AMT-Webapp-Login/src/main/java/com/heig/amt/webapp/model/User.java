/*
 * File             : User.java
 * Authors          : Antoine Drabble & Guillaume Serneels
 * Last Modified    : 21.10.2016
 */
package com.heig.amt.webapp.model;

/**
 * User Model
 * @author Antoine Drabble & Guillaume Serneels
 */
public class User {

    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
