package com.qianfeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableTurbine
public class TurbineApp {
    @Bean
    public RestTemplate getTemp() {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(TurbineApp.class);

    }
}
