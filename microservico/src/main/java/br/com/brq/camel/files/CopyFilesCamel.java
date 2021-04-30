package br.com.brq.camel.files;


import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesCamel {

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();

        camelContext.addRoutes(new RouteBuilder() {
            public void configure() throws Exception {
                from("file:input").
                        to("file:output");
            }
        });

        camelContext.start();
        Thread.sleep(5000);
        camelContext.stop();
        camelContext.close();
    }
}