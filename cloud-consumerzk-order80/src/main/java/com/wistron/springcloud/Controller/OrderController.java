package com.wistron.springcloud.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    public static final String PAYMENTZK_URL="http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("consumer/get/sayHello")
    public String sayHello(){
        String str = restTemplate.getForObject(PAYMENTZK_URL + "/payment/sayHello", String.class);
        return str;
    }
}
