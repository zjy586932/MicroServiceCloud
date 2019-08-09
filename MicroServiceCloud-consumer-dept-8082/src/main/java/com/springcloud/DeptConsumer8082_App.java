package com.springcloud;

import com.ribbon.DefaultRibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "DEPT-PROVIDER",configuration = DefaultRibbonConfig.class)
public class DeptConsumer8082_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer8082_App.class,args);
    }
}
