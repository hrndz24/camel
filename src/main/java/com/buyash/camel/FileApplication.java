package com.buyash.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.Properties;

public class FileApplication {

    public static void main(String[] args) throws Exception {

        CamelContext camel = new DefaultCamelContext();
        camel.getPropertiesComponent().setLocation("application.properties");
        Properties properties = camel.getPropertiesComponent().loadProperties();
        camel.addRoutes(new FileRouteBuilder(properties.getProperty("file.from"), properties.getProperty("file.to")));
        camel.start();

        System.in.read();
        camel.stop();
    }
}
