package com.buyash.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.CsvDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;

public class FileRouteBuilder extends RouteBuilder {
    @Override
    public void configure() {
        getContext().getPropertiesComponent().setLocation("classpath:application.properties");

        // lets shutdown faster in case of in-flight messages stack up
        getContext().getShutdownStrategy().setTimeout(10);

        CsvDataFormat csvDataFormat = new CsvDataFormat();
        csvDataFormat.setDelimiter(",");
        csvDataFormat.setUseMaps("true");

        from("{{file.from}}")
                .unmarshal(csvDataFormat)
                .marshal()
                .json(JsonLibrary.Jackson)
                .to("{{file.to}}");
    }
}
