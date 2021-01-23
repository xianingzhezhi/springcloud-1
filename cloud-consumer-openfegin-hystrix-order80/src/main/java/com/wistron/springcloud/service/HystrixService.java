package com.wistron.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient( value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT" )
public interface HystrixService {

    @GetMapping("payment/info")
    public String paymentInfo();



}
