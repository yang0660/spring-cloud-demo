package com.qianfeng.springcloud.feign;

import com.qianfeng.springcloud.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class FeignClient01Hystrix implements FeignClient01 {
    @Override
    public User getOrder(Long id) {
        User user = new User();
        user.setId(300L);
        user.setDate(new Date());
        return user;
    }
}
