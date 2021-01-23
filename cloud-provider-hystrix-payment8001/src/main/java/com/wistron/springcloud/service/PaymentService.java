package com.wistron.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    @HystrixCommand(fallbackMethod = "paymentFallback",commandProperties = {
            //@HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
           // @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
           // @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
           // @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")//超时降级
    })
    public String PaymentInfoOk(){

        try {
            TimeUnit.SECONDS.sleep(0 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName()+"ok";
    }


    public String paymentFallback(){
        return "服务器繁 忙！";
    }
}
