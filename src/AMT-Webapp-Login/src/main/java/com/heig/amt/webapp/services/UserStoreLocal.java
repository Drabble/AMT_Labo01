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
public interface UserStoreLocal {
    public long saveUser(User user);
    public User loadUser(long id);
    public boolean deleteUser(long id);
    public boolean updateUser(long id, User user);
    public long getUserId(User user);
    public List<User> findAllUsers();
}
