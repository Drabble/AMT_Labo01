/*
 * File             : ErrorDTO.java
 * Authors          : Antoine Drabble & Guillaume Serneels
 * Last Modified    : 21.10.2016
 */
package com.heig.amt.webapp.rest.dto;

/**
 * This Data Transfer Object is used to encapsulate an error
 *
 * @author Antoine Drabble antoine.drabble@heig-vd.ch
 * @author Guillaume Serneels guillaume.serneels@heig-vd.ch
 */
public class ErrorDTO {

    private String error;

    public ErrorDTO() {

    }

    /**
     * Create the error's DTO
     *
     * @param error the error name
     */
    public ErrorDTO(String error) {
        this.error = error;
    }

    /**
     * Return the error's name
     *
     * @return the name
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the error's name
     *
     * @param error the name
     */
    public void setError(String error) {
        this.error = error;
    }

}
