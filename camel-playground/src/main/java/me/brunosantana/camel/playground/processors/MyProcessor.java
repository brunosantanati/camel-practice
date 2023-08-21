package me.brunosantana.camel.playground.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyProcessor implements Processor {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        LOGGER.error("Exception Thrown");
        throw new IllegalArgumentException("An exception happened on purpose");
    }
}
