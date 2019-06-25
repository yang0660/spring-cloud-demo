package com.qianfeng.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qianfeng.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
public class OrderController {

    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${user.url}")
    private String url;
//    private String url="http://localhost:7900/user/";

    @GetMapping("/order/{id}")
    @HystrixCommand(fallbackMethod = "fail",commandProperties = {@HystrixProperty(name = "execution.isolation.strategy",value = "SEMAPHORE")})
    public User getOrder(@PathVariable Long id) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("PROVIDER-USER", false);
        String homePageUrl = instanceInfo.getHomePageUrl();
        return restTemplate.getForObject(homePageUrl+"/user/"+id, User.class);

    }

    public User fail(Long id) {
        User user = new User();
        user.setId(-100L);
        user.setDate(new Date());
        return user;
    }

}
