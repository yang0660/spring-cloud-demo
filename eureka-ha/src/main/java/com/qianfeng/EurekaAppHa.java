package com.qianfeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableEurekaServer
@EnableEurekaClient
public class EurekaAppHa
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaAppHa.class,args);
    }
}
