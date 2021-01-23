package com.wistron.springcloud.service.impl;

import com.wistron.springcloud.dao.PaymentDao;
import com.wistron.springcloud.pojo.Payment;
import com.wistron.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return  this.paymentDao.create(payment);
    }

    public Payment getPaymentById(@Param("id") Long id){
        return this.paymentDao.getPaymentById(id);
    }
}
