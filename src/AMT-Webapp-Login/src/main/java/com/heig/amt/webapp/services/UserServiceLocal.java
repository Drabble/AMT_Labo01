/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heig.amt.webapp.services;

import com.heig.amt.webapp.model.User;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author antoi
 */
@Local
public interface UserServiceLocal {

    public long create(String username, String password) throws SQLException, IllegalArgumentException;

    public long login(String username, String password) throws SQLException, IllegalArgumentException;

    public User get(long id) throws SQLException, IllegalArgumentException;

    public boolean delete(long id) throws SQLException, IllegalArgumentException;

    public boolean update(long id, User user) throws SQLException, IllegalArgumentException;

    public List<User> findAll() throws SQLException, IllegalArgumentException;
}
