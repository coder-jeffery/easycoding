package com.easycoding.eurekaconsumer.controller;

import com.easycoding.eurekaconsumer.service.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/easy-consumer")
public class ConsumerController {

    @Autowired
    private  HelloRemote helloRemote;



    @RequestMapping("/consumerHello/{name}")
    public String index(@PathVariable("name") String name){

        return helloRemote.sayHello(name);
    }


    @RequestMapping("/info")
    public String info(){

        return " Hi,I am a eureka-consumer!";
    }



}
