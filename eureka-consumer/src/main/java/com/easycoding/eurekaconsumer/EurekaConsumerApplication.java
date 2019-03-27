package com.easycoding.eurekaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


//@EnableDiscoveryClient :启用服务注册与发现
//@EnableFeignClients：启用feign进行远程调用


@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class EurekaConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(EurekaConsumerApplication.class, args);
    }

}
