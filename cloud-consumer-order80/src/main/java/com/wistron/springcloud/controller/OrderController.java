package com.wistron.springcloud.controller;

import com.wistron.springcloud.pojo.JsonResult;
import com.wistron.springcloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("consumer/")
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL="http://CLOUD-PROVIDER-PAYMENT";
    //public static final String PAYMENT_URL="http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("payment/get/{id}")
    public JsonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.info("进来了");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,JsonResult.class);
    }

    @GetMapping("payment/create")
    public JsonResult create (Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,JsonResult.class);
    }
}
