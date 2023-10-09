package me.brunosantana.camel.playground.routes;

import me.brunosantana.camel.playground.processors.ExceptionProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteThatCallsApi extends RouteBuilder {

    @Autowired
    private ExceptionProcessor exceptionProcessor;

    @Override
    public void configure() throws Exception {

        from("timer:start-handling-exception?period=10000")
                .routeId("route-that-calls-api")
                .doTry()
                    .toD("http://localhost:3000/")
                .doCatch(Exception.class)
                .process(exceptionProcessor)
        ;
    }
}
