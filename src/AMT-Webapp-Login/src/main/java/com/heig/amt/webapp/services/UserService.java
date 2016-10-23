/*
 * File             : UserService.java
 * Authors          : Antoine Drabble & Guillaume Serneels
 * Last Modified    : 21.10.2016
 */
package com.heig.amt.webapp.services;

import com.heig.amt.webapp.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.DuplicateKeyException;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 * This class is the core of the business tier of our application, it represents
 * the service allowing to manage Users and implements the UserServiceLocal 
 * inteface. The annotation @Stateless specifies that the class is a Stateless 
 * session bean EJB and will be instanciated by the application server
 * The class accesses our MySQL databses using JDBC and implement the CRUD 
 * operations and the user Login features
 * @author Antoine Drabble antoine.drabble@heig-vd.ch
 * @author Guillaume Serneels guillaume.serneels@heig-vd.ch
 */
@Stateless
public class UserService implements UserServiceLocal {

    Connection connection;
    PreparedStatement pstmt;

    @Resource(lookup = "jdbc/webapp_login")
    private DataSource dataSource;

    /**
     * This method creates a new user record using JDBC, but before doing so it 
     * verifies that the user input matches the following requirements:
     * - username should be between 3 and 40 characters long
     * - password should be between 3 and 50 characters long
     * - email adress should be between 3 and 40 characters long
     * - first name and last name should be between 3 and 50 characters long
     * It also verifies on the database that the chosen username is not yet taken 
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
    @Override
    public long create(String username, String password, String email, String firstname, String lastname) throws SQLException, IllegalArgumentException, RuntimeException, DuplicateKeyException {
        if(username.length() > 40){
            throw new IllegalArgumentException("Username should be shorter than 40 characters!");
        }
        if(username.length() < 3){
            throw new IllegalArgumentException("Username should have at least 3 characters!");
        }
        if(password.length() > 50){
            throw new IllegalArgumentException("Password should be shorter than 50 characters!");
        }
        if(password.length() < 3){
            throw new IllegalArgumentException("Password should have at least 3 characters!");
        }
        if(email.length() > 40){
            throw new IllegalArgumentException("Email should be shorter than 40 characters!");
        }
        if(email.length() < 3){
            throw new IllegalArgumentException("Email should have at least 3 characters!");
        }
        if(firstname.length() > 50){
            throw new IllegalArgumentException("Firstname should be shorter than 50 characters!");
        }
        if(firstname.length() < 3){
            throw new IllegalArgumentException("Firstname should have at least 3 characters!");
        }
        if(lastname.length() > 50){
            throw new IllegalArgumentException("Lastname should be shorter than 50 characters!");
        }
        if(lastname.length() < 3){
            throw new IllegalArgumentException("Lastname should have at least 3 characters!");
        }
        
        connection = dataSource.getConnection();
        
        // Check if user already exists
        pstmt = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            throw new DuplicateKeyException("Username is already in use!");
        }
        
        // Create new user
        pstmt = connection.prepareStatement("INSERT INTO users (username, password, email, firstname, lastname) VALUE (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        pstmt.setString(3, email);
        pstmt.setString(4, firstname);
        pstmt.setString(5, lastname);

        pstmt.executeUpdate();
        rs = pstmt.getGeneratedKeys();
        connection.close();

        if(rs.next()){
            return rs.getInt(1);
        } else{
            throw new RuntimeException("Internal server error!");
        }
    }
    /**
     * This method verifies the credentials submited by an user in order to log 
     * him in the application. It first checks if the username exists and then 
     * if the correct password has been entered. If it's the case it returns 
     * the user's id otherwise it throws an IllegalArgumentException
     * @param username the provided username
     * @param password the provided password
     * @return the id of the user who just logged in 
     * @throws SQLException In case of SQL error
     * @throws IllegalArgumentException If the provided credentials are not 
     * correct
     */
    @Override
    public long login(String username, String password) throws SQLException, IllegalArgumentException {
        connection = dataSource.getConnection();
        // Check if user exists
        pstmt = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();
        if(!rs.next()){
            throw new IllegalArgumentException("User does not exist");
        }
        // check the password's correctness
        pstmt = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        rs = pstmt.executeQuery();
        connection.close();

        if (rs.next()) {
            return rs.getInt("id");
        } else{
            throw new IllegalArgumentException("Wrong password entered!");
        }  
    }

    /**
     * Returns a specified User
     * @param id the id of the User to return
     * @return the User object
     * @throws SQLException In case of SQL error
     * @throws IllegalArgumentException If the requested user id doesn't exists
     */
    @Override
    public User get(long id) throws SQLException, IllegalArgumentException {
        connection = dataSource.getConnection();
        pstmt = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
        pstmt.setLong(1, id);
        ResultSet rs = pstmt.executeQuery();
        connection.close();

        if (rs.next()) {
            return new User(rs.getString("username"), rs.getString("password"), 
                    rs.getString("email"), rs.getString("firstname"), 
                    rs.getString("lastname"));
        }
        
        throw new IllegalArgumentException("User doesn't exist");
    }
    /**
     * Returns a List of every registered User
     * @return the list of User objects
     * @throws SQLException In case of SQL error
     */
    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        connection = dataSource.getConnection();
        pstmt = connection.prepareStatement("SELECT * FROM users");
        ResultSet rs = pstmt.executeQuery();
        connection.close();

        while (rs.next()) {
            users.add(new User(rs.getString("username"), rs.getString("password"), 
                    rs.getString("email"), rs.getString("firstname"), 
                    rs.getString("lastname")));
        }
        return users;
    }
    /**
     * Deletes a specified User
     * @param id the id of the User to delete
     * @return true if the user has been correctly deleted
     * @throws SQLException In case of SQL error
     */
    @Override
    public boolean delete(long id) throws SQLException {
        connection = dataSource.getConnection();
        pstmt = connection.prepareStatement("DELETE FROM users WHERE id=?");
        pstmt.setLong(1, id);

        int rows = pstmt.executeUpdate();

        connection.close();

        return rows > 0;
    }
   
    /**
     * This method is used to update an User record on the databse, it firdt
     * verifies that the user input matches the following requirements:
     * - username should be between 3 and 40 characters long
     * - password should be between 3 and 50 characters long
     * - email adress should be between 3 and 40 characters long
     * - first name and last name should be between 3 and 50 characters long
     * It also verifies on the database that the chosen username is not yet taken 
     * @param id the user's id to update
     * @param user the new User information to set for the provided user id
     * @return true if the user has been successfully updated, false otherwise
     * @throws SQLException In case of SQL error
     * @throws IllegalArgumentException  If the provided credentials do not match 
     * the requirements
     * @throws DuplicateKeyException If the username has already been registered
     */
    @Override
    public boolean update(long id, User user) throws SQLException, IllegalArgumentException, DuplicateKeyException {
        if(user.getUsername().length() > 40){
            throw new IllegalArgumentException("Username should be shorter than 40 characters!");
        }
        if(user.getUsername().length() < 3){
            throw new IllegalArgumentException("Username should have at least 3 characters!");
        }
        if(user.getPassword().length() > 50){
            throw new IllegalArgumentException("Password should be shorter than 50 characters!");
        }
        if(user.getPassword().length() < 3){
            throw new IllegalArgumentException("Password should have at least 3 characters!");
        }
        if(user.getEmail().length() > 40){
            throw new IllegalArgumentException("Email should be shorter than 40 characters!");
        }
        if(user.getEmail().length() < 3){
            throw new IllegalArgumentException("Email should have at least 3 characters!");
        }
        if(user.getFirstname().length() > 50){
            throw new IllegalArgumentException("Firstname should be shorter than 50 characters!");
        }
        if(user.getFirstname().length() < 3){
            throw new IllegalArgumentException("Firstname should have at least 3 characters!");
        }
        if(user.getLastname().length() > 50){
            throw new IllegalArgumentException("Lastname should be shorter than 50 characters!");
        }
        if(user.getLastname().length() < 3){
            throw new IllegalArgumentException("Lastname should have at least 3 characters!");
        }
        
        connection = dataSource.getConnection();
        
        // Check if username already exists
        pstmt = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND id != ?");
        pstmt.setString(1, user.getUsername());
        pstmt.setLong(2, id);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            throw new DuplicateKeyException("Username is already in use!");
        }
        
        pstmt = connection.prepareStatement("UPDATE users SET username=?, password=?, "
                + "email=?, firstname=?, lastname=? WHERE id=?");
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getEmail());
        pstmt.setString(4, user.getFirstname());
        pstmt.setString(5, user.getLastname());
        pstmt.setLong(6, (int) id);

        int rows = pstmt.executeUpdate();

        connection.close();

        return rows > 0;
    }
}
