/*
 * File             : RestApplication.java
 * Authors          : Antoine Drabble & Guillaume Serneels
 * Last Modified    : 21.10.2016
 */
package com.heig.amt.webapp.rest;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * This class sets the root URL of our REST API (REpresentational State Transfer)
 * implemented using JAX-RS. It uses the annotation @ApplicationPath() to set 
 * this base url to "/api"
 * 
 * @author Antoine Drabble antoine.drabble@heig-vd.ch
 * @author Guillaume Serneels guillaume.serneels@heig-vd.ch
 */
@ApplicationPath("/api")
public class RestApplication extends Application {
    /**
     * Using jackson for JSON serialisation
     * @return the properties
     */
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("jersey.config.disableMoxyJson", true);
        return properties;
    }
}
