/*
 * File             : RestApplication.java
 * Authors          : Antoine Drabble & Guillaume Serneels
 * Last Modified    : 21.10.2016
 */
package rest;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author antoi
 */
@ApplicationPath("/api")
public class RestApplication extends Application {

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("jersey.config.disableMoxyJson", true);
        return properties;
    }
}
