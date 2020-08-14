package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.hello.HelloService;
import com.example.hello.HelloServiceFactory;

@SpringBootApplication
public class Application {
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
 
    @Bean(name = "helloServiceFactory")
    public HelloServiceFactory helloFactory() {
    	return new HelloServiceFactory();
    }
    
    @Bean(name = "helloServicePython")
    public HelloService helloServicePython() throws Exception {
        return helloFactory().getObject();
    
 
}
}
