/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heig.amt.webapp.services;

import com.heig.amt.webapp.model.User;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author antoi
 */
@Stateless
public class UserService implements UserServiceLocal {

    @EJB
    UserStore userStore;
    
    @Override
    public long register(String username, String password){
        if(!password.isEmpty() && !username.isEmpty()){
            
            return userStore.saveUser(new User(username, password));
        }
        return -1;
    }
    
    @Override
    public long login(String username, String password){
        return userStore.getUserId(new User(username, password));
    }

    @Override
    public User get(long id){
        return userStore.loadUser(id);
    }
}
