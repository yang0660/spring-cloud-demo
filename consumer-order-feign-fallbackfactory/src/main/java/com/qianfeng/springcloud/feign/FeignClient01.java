package com.qianfeng.springcloud.feign;

import com.qianfeng.springcloud.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PROVIDER-USER",fallbackFactory = FeignClient01Factory.class)
public interface FeignClient01 {
    @GetMapping("/user/{id}")
    User getOrder(@PathVariable Long id);
}
