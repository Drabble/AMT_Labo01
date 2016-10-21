/*
 * File             : UserLoginDTO.java
 * Authors          : Antoine Drabble & Guillaume Serneels
 * Last Modified    : 21.10.2016
 */
package rest.dto;

/**
 *
 * @author antoi
 */
public class UserLoginDTO {

    private String username;
    private String password;

    public UserLoginDTO() {
    }

    public UserLoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
