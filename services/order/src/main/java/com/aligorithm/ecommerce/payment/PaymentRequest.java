package com.aligorithm.ecommerce.payment;

import com.aligorithm.ecommerce.customer.CustomerResponse;
import com.aligorithm.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}