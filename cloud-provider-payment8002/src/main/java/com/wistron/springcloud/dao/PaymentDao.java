package com.wistron.springcloud.dao;

import com.wistron.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
