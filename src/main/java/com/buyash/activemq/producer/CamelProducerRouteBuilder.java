package com.buyash.activemq.producer;

import org.apache.camel.builder.RouteBuilder;

public class CamelProducerRouteBuilder extends RouteBuilder {

    private String from;
    private String to;

    public CamelProducerRouteBuilder(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void configure() {
        from(from)
                .to(to);
    }
}
