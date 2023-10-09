package me.brunosantana.camel.playground.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RouteThatCallsApi extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("timer:start-handling-exception?period=10000")
                .routeId("route-that-calls-api")
                //.doTry()
                    .toD("http://localhost:3000/")
                //.doCatch(Exception.class)
                //    .to("mock:caught")
        ;
    }
}
