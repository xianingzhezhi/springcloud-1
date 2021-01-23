package com.wistron.springcloud.controller;

import com.wistron.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("payment/info")
    public String paymentInfo(){
        return paymentService.PaymentInfoOk();
    }
}
