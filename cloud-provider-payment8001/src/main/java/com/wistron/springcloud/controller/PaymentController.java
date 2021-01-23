package com.wistron.springcloud.controller;

import com.wistron.springcloud.pojo.JsonResult;
import com.wistron.springcloud.pojo.Payment;
import com.wistron.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("payment/")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("create")
    public JsonResult create(@RequestBody Payment payment){
        int row = this.paymentService.create(payment);

        if(row>0)
            return new JsonResult(200,"插入成功",row);
        else
            return new JsonResult(400,"添加失败",row);
    }

    @GetMapping("get/{id}")
    public JsonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = this.paymentService.getPaymentById(id);
        log.info(payment+"------ssss--");
        if(payment!=null)
            return new JsonResult(200,"成功"+serverPort,payment);
        else
            return new JsonResult(400,"没有找到该ID： "+id,null);
    }

}
