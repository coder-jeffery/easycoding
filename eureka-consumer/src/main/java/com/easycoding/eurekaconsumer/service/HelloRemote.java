package com.easycoding.eurekaconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name= "eureka-client")
public interface HelloRemote {



    //需要匹配服务提供者接口名称
    @RequestMapping(value = "/producerHello")
    String sayHello(@RequestParam(value="name") String name);

}
