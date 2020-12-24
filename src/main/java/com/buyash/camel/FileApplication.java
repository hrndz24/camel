package com.buyash.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class FileApplication {

    public static void main(String[] args) throws Exception {
        CamelContext camel = new DefaultCamelContext();
        camel.addRoutes(new FileRouteBuilder());
        camel.start();

        while (true){

        }
        //camel.stop();
    }
}
