/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heig.amt.webapp.rest.dto;

/**
 *
 * @author antoi
 */
public class UserIdDTO {
    private long id;
    
    public UserIdDTO(){
        
    }

    public UserIdDTO(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
}
