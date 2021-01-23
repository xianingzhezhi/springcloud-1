package com.wistron.springcloud.controller;

import com.wistron.springcloud.pojo.JsonResult;
import com.wistron.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("consumer/payment/get/{id}")
    public JsonResult getPyamentById(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }
}
