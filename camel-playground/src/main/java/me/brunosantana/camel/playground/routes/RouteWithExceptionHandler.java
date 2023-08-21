package me.brunosantana.camel.playground.routes;

import me.brunosantana.camel.playground.processors.MyProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RouteWithExceptionHandler extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("timer:start-handling-exception?period=10000")
                .routeId("exception-handling-route")
                .doTry()
                    .process(new MyProcessor())
                    .to("mock:received")
                .doCatch(IOException.class, IllegalArgumentException.class)
                    .to("mock:caught")
                .doFinally()
                    .to("mock:finally")
                .end();
    }
}
