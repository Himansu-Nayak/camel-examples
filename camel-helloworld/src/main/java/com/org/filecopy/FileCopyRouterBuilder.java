package com.org.filecopy;

import org.apache.camel.builder.RouteBuilder;

public class FileCopyRouterBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        try{
            from( "file:C:\\Windows\\Media\\Savanna")
                    .to("file:C:\\temp");
        }catch(Exception exception){
        }
    }
}