package com.wistron.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wistron.springcloud.service.HystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private HystrixService hystrixService;

    @GetMapping("comsumer/paymentInfo")
    @HystrixCommand(fallbackMethod = "timeoutFallback",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000000")
    })
    public String PaymentInfo(){
        System.out.println("进来了");
        return hystrixService.paymentInfo();
    }


    public String gloabFallback(){
        return "全局异常";
    }
    public String timeoutFallback(){
        return "超时异常";
    }
}
