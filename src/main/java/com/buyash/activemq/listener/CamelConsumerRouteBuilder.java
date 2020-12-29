package com.buyash.activemq.listener;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelConsumer extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:standalone.queue")
                .process(System.out::println)
                .end();
    }
}
