/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heig.amt.webapp.services;

import com.heig.amt.webapp.model.User;
import java.util.ArrayList;

/**
 *
 * @author antoi
 */
public class UserManager {
    private static UserManager instance = null;
    private final ArrayList<User> users = new ArrayList<>();
    
    private UserManager(){
    
    }
    
    public static UserManager getInstance(){
        if(instance == null){
            instance = new UserManager();
        }
        return instance;
    }
    public boolean registerUser(String username, String password){
        boolean userExists = false;
        for(User user : users){
            if(user.getUsername().compareTo(username) == 0){
                userExists = true;
            }
        }
        if(!password.isEmpty() && !username.isEmpty() && !userExists){
            users.add(new User(username, password));
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean loginUser(String username, String password){
        for(User user : users){
            if(user.getUsername().compareTo(username) == 0){
                if(user.getPassword().compareTo(password) == 0){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }

    public User getUser(String username) {
        for(User user : users){
            if(user.getUsername().compareTo(username) == 0){
                return user;
            }
        }
        return null;
    }
}
