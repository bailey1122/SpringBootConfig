package com.pr.springbootconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// use 'ConfigurationProperties' to pull up some group of properties and when there's a need to get a bean
// use 'Value' to pull up some property
@Configuration // creates this as a bean
// look up from the prefix 'db.'
@ConfigurationProperties("db")
public class DbSettings {

    // if any property matches any of these variables, Spring creates
    // a new instance of this class and injects the values automatically
    private String connection;
    private String host;
    private int port;

    // add getters and setters in order to let Spring inject the values
    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
