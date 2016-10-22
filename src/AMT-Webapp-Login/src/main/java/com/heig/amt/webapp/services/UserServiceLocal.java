/*
 * File             :UserServiceLocal .java
 * Authors          : Antoine Drabble & Guillaume Serneels
 * Last Modified    : 21.10.2016
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

    public long create(String username, String password, String email, String firstname, String lastname) throws SQLException, IllegalArgumentException, RuntimeException;

    public long login(String username, String password) throws SQLException, IllegalArgumentException;

    public User get(long id) throws SQLException, IllegalArgumentException;

    public boolean delete(long id) throws SQLException;

    public boolean update(long id, User user) throws SQLException, IllegalArgumentException;

    public List<User> findAll() throws SQLException;
}
