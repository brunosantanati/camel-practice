package me.brunosantana.camel.playground.routes;

import me.brunosantana.camel.playground.processors.MyProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class RouteWithoutExceptionHandler extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("timer:without-handling-exception?period=10000")
                .routeId("without-exception-handling-route")
                .process(new MyProcessor())
                .to("mock:received");
    }
}
