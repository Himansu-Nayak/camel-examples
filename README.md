# camel-examples
Introduction to Apache Camel

Camel empowers you to define routing and mediation rules in a variety of domain-specific languages, including a Java-based [Fluent API](http://camel.apache.org/dsl.html), [Spring](http://camel.apache.org/spring.html) or [Blueprint](http://camel.apache.org/using-osgi-blueprint-with-camel.html) [XML Configuration](http://camel.apache.org/xml-configuration.html) files, and a [Scala DSL](http://camel.apache.org/scala-dsl.html). This means you get smart completion of routing rules in your IDE, whether in a Java, Scala or XML editor.

Apache Camel uses [URIs](http://camel.apache.org/uris.html) to work directly with any kind of [Transport](http://camel.apache.org/transport.html) or messaging model such as [HTTP](http://camel.apache.org/http.html), [ActiveMQ](http://camel.apache.org/activemq.html), [JMS](http://camel.apache.org/jms.html), [JBI](http://camel.apache.org/jbi.html), SCA,[MINA](http://camel.apache.org/mina.html) or [CXF](http://camel.apache.org/cxf.html), as well as pluggable [Components](http://camel.apache.org/components.html) and [Data Format](http://camel.apache.org/data-format.html) options. Apache Camel is a small library with minimal[dependencies](http://camel.apache.org/what-are-the-dependencies.html) for easy embedding in any Java application. Apache Camel lets you work with the same [API](http://camel.apache.org/exchange.html) regardless which kind of[Transport](http://camel.apache.org/transport.html) is used - so learn the API once and you can interact with all the [Components](http://camel.apache.org/components.html) provided out-of-box.

Apache Camel provides support for [Bean Binding](http://camel.apache.org/bean-binding.html) and seamless integration with popular frameworks such as [CDI](http://camel.apache.org/cdi.html), [Spring](http://camel.apache.org/spring.html), [Blueprint](http://camel.apache.org/using-osgi-blueprint-with-camel.html)and [Guice](http://camel.apache.org/guice.html). Camel also has extensive support for [unit testing](http://camel.apache.org/testing.html) your routes.

The following projects can leverage Apache Camel as a routing and mediation engine:

- [Apache ServiceMix](http://servicemix.apache.org/) - a popular distributed open source ESB and JBI container
- [Apache ActiveMQ](http://activemq.apache.org/) - a mature, widely used open source message broker
- [Apache CXF](http://cxf.apache.org/) - a smart web services suite (JAX-WS and JAX-RS)
- [Apache Karaf](http://karaf.apache.org/) - a small OSGi based runtime in which applications can be deployed
- [Apache MINA](http://mina.apache.org/) - a high-performance [NIO](http://en.wikipedia.org/wiki/New_I/O)-driven networking framework


### The Camel Terminologies/Classes/Interfaces

#### **Endpoint**

Endpoints are places where the exchange of messages takes place. It may refer to an address, a POJO, email address, webservice uri, queue uri, file etc. In camel an endpoint is implemented by implemented Endpoint interface. The endpoints are wrapped by something called routes.

#### **CamelContext**

CamelContext is at heart of all camel application and it represents Camel run time system.

1. Create camelcontext.
2. Add endpoints or components.
3. Add Routes to connect the endpoints.
4. Invoke camelcontext.start() – This starts all the camel-internal threads which are responsible for receiving, sending and processing messages in the endpoints.
5. Lastly invoking camelcontext.stop() when all the messages are exchanged and processed. This will gracefully stop all the camel-internal threads and endpoints.

#### **CamelTemplate**

This is a thin wrapper around the CamelContext object and it is responsible to sending exchange or messages to an endpoint.

#### **Component**

Component is really an endpoint factory. As camel supports lots of different kind of resources, each of these resources have different kind of endpoints. In practical cases application don’t create endpoints directly using Components. Instead CamelContext decideds which component to instantiate and then uses that component instance to create endpoints. So in app we will have. CamelContext.getEndpoint(“pop3://john.smith@mailserv.example.com?password=myPassword”); Now pop3 in this case is name of the component. CamelContext maps all the component name with the component classes and using the name it instantiates the instance. Once it has handle to the component it instantiates the endpoint by calling. Component.createInstance() method.

#### **Message**

Mesaage represents a single concrete message ie request, reply or exception. All concrete message class impements a message interface for example JmsMessage class.

#### **Exchange**

Exchange is a container of message. It is created when a message is received by a consumer during routing process.

#### **Processor**

Processor interface represents a class that processes a message. It contains a single method public void process(Exchange exchange) throws exception Application developers can implement this interface to preform business logic on the message when message is received by the consumer.

#### **Routes and RouteBuilder**

Route is the step by step movement of message from a source, through arbitrary types of decision by filters or routers to a destination. They are configured by help of DSL (Domain Specific language). Java DSL is created by implementing routebuilder interface. It has single method called configure() which defines the entire route of message. Routes can also be configured via xml file using spring.