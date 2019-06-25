package com.qianfeng.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.qianfeng.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private RestTemplate restTemplate;
//    @Value("${user.url}")
//    private String url;
//    private String url="http://localhost:7900/user/";
@Autowired
    private LoadBalancerClient loadBalancerClient;
    @GetMapping("/order/{id}")
    public User getOrder(@PathVariable Long id) {
//        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("PROVIDER-USER", false);

//        String homePageUrl = instanceInfo.getHomePageUrl();
        User user=restTemplate.getForObject("http://PROVIDER-USER/user/"+id, User.class);
        return user;
    }

    @GetMapping("/test")
    public void test() {
        ServiceInstance serviceInstance=loadBalancerClient.choose("PROVIDER-USER");
        System.err.println("1111"+serviceInstance.getServiceId()+" "+serviceInstance.getHost()+":"+serviceInstance.getPort());
    }
}
