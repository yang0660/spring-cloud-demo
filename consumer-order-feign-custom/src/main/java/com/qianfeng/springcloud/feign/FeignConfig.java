package com.qianfeng.springcloud.feign;


import feign.Contract;
import feign.Feign;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeCommentScan
public class FeignConfig {
    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

    @Bean
    Logger.Level feignLoggerLever() {
        return Logger.Level.FULL;
    }
}
