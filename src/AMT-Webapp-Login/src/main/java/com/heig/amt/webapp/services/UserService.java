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
 *
 * @author antoi
 */
@Stateless
public class UserService implements UserServiceLocal {

    Connection connection;
    PreparedStatement pstmt;

    @Resource(lookup = "jdbc/webapp_login")
    private DataSource dataSource;

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

    @Override
    public boolean delete(long id) throws SQLException {
        connection = dataSource.getConnection();
        pstmt = connection.prepareStatement("DELETE FROM users WHERE id=?");
        pstmt.setLong(1, id);

        int rows = pstmt.executeUpdate();

        connection.close();

        return rows > 0;
    }

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
