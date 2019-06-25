package com.qianfeng.springcloud.config;


import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeCommentScan
public class TestConfig {

    //创建负载均衡算法
    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new RandomRule();//返回随机算法
    }
}
