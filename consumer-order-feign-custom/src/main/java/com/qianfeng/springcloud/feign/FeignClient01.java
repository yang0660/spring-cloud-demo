package com.qianfeng.springcloud.feign;

import com.qianfeng.springcloud.pojo.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PROVIDER-USER",configuration = FeignConfig.class)
public interface FeignClient01 {
//    @GetMapping("/user/{id}")
    @RequestLine("GET /user/{id}")
    User getOrder(@Param("id") Long id);
}
