/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heig.amt.webapp.services;

import com.heig.amt.webapp.model.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author antoi
 */
@Local
public interface UserServiceLocal {
    
    public long register(String username, String password);
    public long login(String username, String password);
    public User get(long id);
    public boolean delete(long id);
    public boolean update(long id, User user);
    public List<User> findAll();
}
