package com.easycoding.easycodingrpc.controller;

import com.easycoding.easycodingrpc.easyrpc.RpcClient;
import com.easycoding.easycodingrpc.service.HelloService;

import java.io.IOException;
import java.net.InetSocketAddress;

public class RpcTest {


    public static void main(String[] args) throws IOException {

        HelloService service = RpcClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 9094));

        System.out.println(service.say("张三", "新年快乐，大吉大利!"));
    }
}
