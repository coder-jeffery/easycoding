package com.easycoding.easycodingrpc.controller;

import com.easycoding.easycodingrpc.easyrpc.RpcClient;
import com.easycoding.easycodingrpc.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetSocketAddress;

@RestController
public class testController {


    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){


        return  "rpc run success";
    }


    public static void main(String[] args) throws IOException {

        HelloService service = RpcClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 9094));

        System.out.println(service.say("张三", "新年快乐，大吉大利!"));
    }

}
