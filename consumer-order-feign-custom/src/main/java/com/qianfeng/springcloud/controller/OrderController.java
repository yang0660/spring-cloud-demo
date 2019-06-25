package com.qianfeng.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.qianfeng.springcloud.feign.FeignClient01;
import com.qianfeng.springcloud.pojo.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private FeignClient01 feignClient01;

    @GetMapping("/order/{id}")
//    @RequestLine("GET /order/{id}")
    public User getOrder(@PathVariable("id") Long id) {
        return feignClient01.getOrder(id);
    }

}
