package com.easycoding.easycodingrpc.service.impl;

import com.easycoding.easycodingrpc.service.HelloService;

public class HelloServiceImpl implements HelloService {

    private static final long serialVersionUID = 1L;


    public String say(String name, String msg) {

        return new StringBuffer()
                .append("hi~! ")
                .append(name).append(",")
                .append(msg).toString();
    }
}
