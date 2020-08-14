package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.HelloService;

@RestController
public class HelloController {
 
	@Autowired
	@Qualifier("helloServicePython")
	private HelloService service;
 
	@RequestMapping("/")
	public String index() {
		return service.getHello();
	}
 
}