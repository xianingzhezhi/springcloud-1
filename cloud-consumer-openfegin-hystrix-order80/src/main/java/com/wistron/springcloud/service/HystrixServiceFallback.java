package com.wistron.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class HystrixServiceFallback  implements  HystrixService{


    @Override
    public String paymentInfo() {
        return "80系统繁忙@！";
    }
}
