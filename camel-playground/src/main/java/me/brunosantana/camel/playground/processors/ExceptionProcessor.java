package me.brunosantana.camel.playground.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.http.base.HttpOperationFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ExceptionProcessor implements Processor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        final HttpOperationFailedException e =
                exchange.getProperty(Exchange.EXCEPTION_CAUGHT, HttpOperationFailedException.class);
        LOGGER.error("HttpOperationFailedException -> {}",  e.getResponseBody());
    }
}
