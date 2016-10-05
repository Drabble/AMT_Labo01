/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heig.amt.webapp.services;

import com.heig.amt.webapp.model.User;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author antoi
 */
@Stateless
public class UserService implements UserServiceLocal {

    @EJB
    UserStoreLocal userStore;
    
    @Override
    public long register(String username, String password){
        if(!username.isEmpty()){
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
    
    public List<User> findAll(){
        return userStore.findAllUsers();
    }

    @Override
    public void delete(long id) {
        userStore.deleteUser(id);
    }

    @Override
    public void update(long id, User user) {
        userStore.updateUser(id, user);
    }
    
    
}
