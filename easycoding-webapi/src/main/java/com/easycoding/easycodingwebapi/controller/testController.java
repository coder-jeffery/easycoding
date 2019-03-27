package com.easycoding.easycodingwebapi.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "EASY SYSTEM 1.0v")
@RestController
@RequestMapping("/easy")
public class testController {


    @ApiOperation(value = "测试接口:index",notes="测试接口:index")
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){


        return "easy run success";
    }
}
