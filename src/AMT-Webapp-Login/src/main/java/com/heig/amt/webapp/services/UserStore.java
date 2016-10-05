/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heig.amt.webapp.services;

import com.heig.amt.webapp.model.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 *
 * @author antoi
 */
@Singleton
public class UserStore implements UserStoreLocal {
    private long userIdCounter = 0;
    private final Map<Long, User> users = new HashMap<>();

    @Override
    @Lock(LockType.WRITE)
    public long saveUser(User user) {
        if(getUserId(user) == -1){
            userIdCounter++;
            users.put(userIdCounter, user);
            return userIdCounter;
        }
        return -1;
    }

    @Override
    @Lock(LockType.READ)
    public User loadUser(long id) {
        return users.get(id);
    }
    
    @Override
    @Lock(LockType.READ)
    public long getUserId(User user) {
        for(Map.Entry<Long, User> u : users.entrySet()){
            if(user.getUsername().compareTo(u.getValue().getUsername()) == 0 && user.getPassword().compareTo(u.getValue().getPassword()) == 0){
                return u.getKey();
            }
        }
        return -1;
    }
    
    @Override
    @Lock(LockType.READ)
    public List<User> findAllUsers() {
        return new ArrayList<>(users.values());
    }
    
    
    @Override
    public void deleteUser(long id){
        users.remove(id);
    }
    
    @Override
    public void updateUser(long id, User user){
        users.put(id, user);
    }
}
