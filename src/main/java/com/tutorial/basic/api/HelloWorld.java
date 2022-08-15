package com.tutorial.basic.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping(value = "/hello")
    public String hello(){
        return  "Hello World";
    }

    @RequestMapping(value = "/independence")
    public String independence(){ return "Happy Independence Day";}
}
