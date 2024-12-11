package com.aligorithm.ecommerce.kafka;

import com.aligorithm.ecommerce.customer.CustomerResponse;
import com.aligorithm.ecommerce.order.PaymentMethod;
import com.aligorithm.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
