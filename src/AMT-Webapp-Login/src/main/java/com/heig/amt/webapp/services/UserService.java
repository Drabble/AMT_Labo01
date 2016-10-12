/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
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

    @Resource(lookup="jdbc/webapp_login")
    private DataSource dataSource;
    
    @Override
    public long register(String username, String password){
        try{
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("INSERT INTO users (username, password) VALUE (?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            connection.close();
            
            if(rs.next())
            {
                return rs.getInt(1);
            }
            
        }
        catch(SQLException e){
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }
    
    @Override
    public long login(String username, String password){
        try{
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            connection.close();
            
            if(rs.next()){
                return rs.getInt("id");
            }
        }
        catch(SQLException e){
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }

    @Override
    public User get(long id){
        try{
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            connection.close();
            
            if(rs.next()){
                return new User(rs.getString("username"), rs.getString("password"));
            }
        }
        catch(SQLException e){
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    @Override
    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        try{
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM users");
            ResultSet rs = pstmt.executeQuery();
            connection.close();
            
            while(rs.next()){
                users.add(new User(rs.getString("username"), rs.getString("password")));
            }
        }
        catch(SQLException e){
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, e);
        }
        return users;
    }

    @Override
    public boolean delete(long id) {
        try{
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("DELETE FROM users WHERE id=?");
            pstmt.setLong(1, id);
            
            int rows = pstmt.executeUpdate();
            
            connection.close();
            
            return rows > 0;
        }
        catch(SQLException e){
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean update(long id, User user) {
        try{
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("UPDATE users SET username=?, password=? WHERE id=?");
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setLong(3, (int)id);
            
            int rows = pstmt.executeUpdate();
            
            connection.close();
            
            return rows > 0;
        }
        catch(SQLException e){
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    
}
