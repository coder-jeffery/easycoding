package com.easycoding.easycodingweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/easy")
public class demoController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){


        return  "easycoding run success...";

    }
}
