/*
 * File             :UserServiceLocal .java
 * Authors          : Antoine Drabble & Guillaume Serneels
 * Last Modified    : 21.10.2016
 */
package com.heig.amt.webapp.services;

import com.heig.amt.webapp.model.User;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;

/**
 * This interface determines the methods used by the UserService, which is the
 * core class of the business tier of our application. The annotation @Local
 * specifies that the interface will be implemented by an EJB which will be
 * instanciated by the application server
 *
 * @author Antoine Drabble antoine.drabble@heig-vd.ch
 * @author Guillaume Serneels guillaume.serneels@heig-vd.ch
 */
@Local
public interface UserServiceLocal {

    /**
     * This method creates a new user record using JDBC, but before doing so it
     * verifies that the user input matches the following requirements: -
     * username should be between 3 and 40 characters long - password should be
     * between 3 and 50 characters long - email adress should be between 3 and
     * 40 characters long - first name and last name should be between 3 and 50
     * characters long It also verifies on the database that the chosen username
     * is not yet taken
     *
     * If all the requirements are met, it executes an INSERT MySQL query to
     * register the user.
     *
     * @param username the user's username
     * @param password the user's password
     * @param email the user's email adress
     * @param firstname the user's first name
     * @param lastname the user's last name
     * @return the id of the newly registered user
     * @throws SQLException In case of SQL error
     * @throws IllegalArgumentException If the provided credentials do not match
     * the requirements
     * @throws RuntimeException If the newly registered user can't be found on
     * the database
     * @throws DuplicateKeyException If the username has already been registered
     */
    public long create(String username, String password, String email, String firstname, String lastname) throws SQLException, IllegalArgumentException, RuntimeException, DuplicateKeyException;

    /**
     * This method verifies the credentials submited by an user in order to log
     * him in the application. It first checks if the username exists and then
     * if the correct password has been entered. If it's the case it returns the
     * user's id otherwise it throws an IllegalArgumentException
     *
     * @param username the provided username
     * @param password the provided password
     * @return the id of the user who just logged in
     * @throws SQLException In case of SQL error
     * @throws IllegalArgumentException If the provided credentials are not
     * correct
     */
    public long login(String username, String password) throws SQLException, IllegalArgumentException;

    /**
     * Returns a specified User
     *
     * @param id the id of the User to return
     * @return the User object
     * @throws SQLException In case of SQL error
     * @throws IllegalArgumentException If the requested user id doesn't exists
     */
    public User get(long id) throws SQLException, IllegalArgumentException;

    /**
     * Deletes a specified User
     *
     * @param id the id of the User to delete
     * @return true if the user has been correctly deleted
     * @throws SQLException In case of SQL error
     */
    public boolean delete(long id) throws SQLException;

    /**
     * This method is used to update an User record on the databse, it firdt
     * verifies that the user input matches the following requirements: -
     * username should be between 3 and 40 characters long - password should be
     * between 3 and 50 characters long - email adress should be between 3 and
     * 40 characters long - first name and last name should be between 3 and 50
     * characters long It also verifies on the database that the chosen username
     * is not yet taken
     *
     * @param id the user's id to update
     * @param user the new User information to set for the provided user id
     * @return true if the user has been successfully updated, false otherwise
     * @throws SQLException In case of SQL error
     * @throws IllegalArgumentException If the provided credentials do not match
     * the requirements
     * @throws DuplicateKeyException If the username has already been registered
     */
    public boolean update(long id, User user) throws SQLException, IllegalArgumentException, DuplicateKeyException;

    /**
     * Returns a List of every registered User
     *
     * @return the list of User objects
     * @throws SQLException In case of SQL error
     */
    public List<User> findAll() throws SQLException;
}
