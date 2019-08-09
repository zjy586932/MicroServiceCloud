package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class DeptProvider_Hystrix_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_Hystrix_App.class,args);
    }
}
