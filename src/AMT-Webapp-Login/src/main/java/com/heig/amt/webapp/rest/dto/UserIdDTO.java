/*
 * File             : UserIdDTO.java
 * Authors          : Antoine Drabble & Guillaume Serneels
 * Last Modified    : 21.10.2016
 */
package com.heig.amt.webapp.rest.dto;

/**
 * This Data Transfer Object encapsulates the id of an User
 * @author Antoine Drabble antoine.drabble@heig-vd.ch
 * @author Guillaume Serneels guillaume.serneels@heig-vd.ch
 */
public class UserIdDTO {
    private long id;
    
    public UserIdDTO(){
        
    }
    /**
     * Creates the Data Transfer Object 
     * @param id the user's id
     */
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
