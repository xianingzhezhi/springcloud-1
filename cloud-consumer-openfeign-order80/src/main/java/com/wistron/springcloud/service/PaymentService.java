package com.wistron.springcloud.service;

import com.wistron.springcloud.pojo.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PROVIDER-PAYMENT")
public interface PaymentService {

    @GetMapping("payment/get/{id}")
    public JsonResult getPaymentById(@PathVariable("id") Long id);
}
