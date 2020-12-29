package com.buyash.activemq;

import com.buyash.activemq.consumer.CamelConsumerRouteBuilder;
import com.buyash.activemq.producer.CamelProducerRouteBuilder;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.Properties;

public class CamelActivemqApplication {

    public static void main(String[] args) throws Exception {
        CamelContext camel = new DefaultCamelContext();
        camel.getPropertiesComponent().setLocation("application.properties");
        Properties properties = camel.getPropertiesComponent().loadProperties();
        camel.addRoutes(new CamelConsumerRouteBuilder(properties.getProperty("activemq.route"), properties.getProperty("file.to")));
        camel.addRoutes(new CamelProducerRouteBuilder(properties.getProperty("file.from"), properties.getProperty("activemq.route")));
        camel.start();

        System.in.read();
        camel.stop();
    }
}
