package com.easycoding.easycodingrpc.service;

import com.easycoding.easycodingrpc.easyrpc.IRpcService;

public interface HelloService extends IRpcService {


    String say(String name, String msg);

}
