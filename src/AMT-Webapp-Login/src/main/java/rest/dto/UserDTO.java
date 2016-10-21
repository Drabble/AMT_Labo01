/*
 * File             : UserDTO.java
 * Authors          : Antoine Drabble & Guillaume Serneels
 * Last Modified    : 21.10.2016
 */
package rest.dto;

/**
 *
 * @author antoi
 */
public class UserDTO {

    private String username;

    public UserDTO(){
        
    }
    
    public UserDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
