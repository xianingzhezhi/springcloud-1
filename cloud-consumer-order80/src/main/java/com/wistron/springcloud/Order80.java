package com.wistron.springcloud;

import com.wistron.ribbon.MyRibbon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT",configuration = MyRibbon.class)
public class Order80 {

    public static void main(String[] args) {
        SpringApplication.run(Order80.class,args);
    }
}
