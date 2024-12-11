package com.aligorithm.ecommerce.payment;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.EnumType.STRING;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Payment {

    @Id
    @GeneratedValue
    private Integer id;
    private BigDecimal amount;
    @Enumerated(STRING)
    private PaymentMethod paymentMethod;
    private Integer orderId;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;


    public Payment(Integer id, BigDecimal amount, PaymentMethod paymentMethod, Integer orderId, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.orderId = orderId;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Payment() {
    }

    public static PaymentBuilder builder() {
        return new PaymentBuilder();
    }

    public Integer getId() {
        return this.id;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public static class PaymentBuilder {
        private Integer id;
        private BigDecimal amount;
        private PaymentMethod paymentMethod;
        private Integer orderId;
        private LocalDateTime createdDate;
        private LocalDateTime lastModifiedDate;

        PaymentBuilder() {
        }

        public PaymentBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public PaymentBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public PaymentBuilder paymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public PaymentBuilder orderId(Integer orderId) {
            this.orderId = orderId;
            return this;
        }

        public PaymentBuilder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public PaymentBuilder lastModifiedDate(LocalDateTime lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public Payment build() {
            return new Payment(this.id, this.amount, this.paymentMethod, this.orderId, this.createdDate, this.lastModifiedDate);
        }

        public String toString() {
            return "Payment.PaymentBuilder(id=" + this.id + ", amount=" + this.amount + ", paymentMethod=" + this.paymentMethod + ", orderId=" + this.orderId + ", createdDate=" + this.createdDate + ", lastModifiedDate=" + this.lastModifiedDate + ")";
        }
    }
}
