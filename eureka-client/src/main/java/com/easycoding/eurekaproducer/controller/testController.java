package com.easycoding.eurekaproducer.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping("/easy-client")
@RestController
public class testController {


    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String index(){

        return "hi、guys eureka-client run success... "+"/n"+"this eureka-client send first message...";
    }


    @RequestMapping("/producerHello")
    public String hello(@RequestParam("name") String name){


        return "Hello:" + name +", this eureka-client send first message 【生产者】";
    }

}
