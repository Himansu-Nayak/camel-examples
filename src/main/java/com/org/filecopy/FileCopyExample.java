package com.org.filecopy;

import org.apache.camel.CamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * copies files from source dir to dest
 */
public class FileCopyExample {
    public static void main(String...args) throws Exception {
        try {
            ApplicationContext springContext = new FileSystemXmlApplicationContext("C:\\Mercury\\github\\camel-examples\\src\\main\\resources\\applicationContext.xml");
            CamelContext context = springContext.getBean("camelContext", CamelContext.class);
            context.start();
            Thread.sleep(10000);
            context.stop();
        } catch (Exception exception) {
        }

    }
}
