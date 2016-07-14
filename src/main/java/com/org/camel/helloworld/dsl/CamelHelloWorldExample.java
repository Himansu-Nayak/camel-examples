package com.org.camel.helloworld.dsl;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Read from queue and send it to stream.
 */
public class CamelHelloWorldExample {
    public static void main(String...args) throws Exception {
        // Create camel context - camel runtime system
        CamelContext context = new DefaultCamelContext();
        try {
            context.addComponent("activemq", ActiveMQComponent.activeMQComponent("vm://localhost?broker.persistent=false"));

            /**
             * Routing rules defined using spring
             1. Read from the queue
             2. Send to output stream
             */
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("activemq:queue:test.queue")
                            .to("stream:out");
                }
            });
            ProducerTemplate template = context.createProducerTemplate();
            context.start();
            template.sendBody("activemq:test.queue", "Hello World");
            Thread.sleep(2000);
        } finally {
            context.stop();
        }
    }
}
