package com.buyash.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.CsvDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;

public class FileRouteBuilder extends RouteBuilder {

    private String from;
    private String to;

    public FileRouteBuilder(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void configure() {
        CsvDataFormat csvDataFormat = new CsvDataFormat();
        csvDataFormat.setDelimiter(",");
        csvDataFormat.setUseMaps("true");

        from(from)
                .unmarshal(csvDataFormat)
                .marshal()
                .json(JsonLibrary.Jackson)
                .to(to);
    }
}
