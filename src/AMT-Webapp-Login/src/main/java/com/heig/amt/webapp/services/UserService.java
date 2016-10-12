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

    @Resource(lookup="jdbc/webapp_login")
    private DataSource dataSource;
    
    @Override
    public long register(String username, String password){

        return -1;
    }
    
    @Override
    public long login(String username, String password){
        return 1;
    }

    @Override
    public User get(long id){
        return new User("","");
    }
    
    @Override
    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                users.add(new User(rs.getString("username"), rs.getString("password")));
            }
            connection.close();
        }
        catch(SQLException e){
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, e);
        }
        return users;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean update(long id, User user) {
        return false;
    }
    
    
}
