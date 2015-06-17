package com.jpm.spt.situ.sandbox.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * Created by v545192 on 6/12/2015.
 */
@SpringBootApplication
public class MyApp {
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return new MyCustomizer();
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
