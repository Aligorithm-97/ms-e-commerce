package com.aligorithm.ecommerce.order;

import com.aligorithm.ecommerce.orderline.OrderLine;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue
    private Integer id;
    private String reference;
    private BigDecimal totalAmount;
    @Enumerated(STRING)
    private PaymentMethod paymentMethod;
    private String customerId;
    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public Order(Integer id, String reference, BigDecimal totalAmount, PaymentMethod paymentMethod, String customerId, List<OrderLine> orderLines, LocalDateTime createdAt, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.reference = reference;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.customerId = customerId;
        this.orderLines = orderLines;
        this.createdAt = createdAt;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Order() {
    }

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    public Integer getId() {
        return this.id;
    }

    public String getReference() {
        return this.reference;
    }

    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public List<OrderLine> getOrderLines() {
        return this.orderLines;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public static class OrderBuilder {
        private Integer id;
        private String reference;
        private BigDecimal totalAmount;
        private PaymentMethod paymentMethod;
        private String customerId;
        private List<OrderLine> orderLines;
        private LocalDateTime createdAt;
        private LocalDateTime lastModifiedDate;

        OrderBuilder() {
        }

        public OrderBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public OrderBuilder reference(String reference) {
            this.reference = reference;
            return this;
        }

        public OrderBuilder totalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public OrderBuilder paymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public OrderBuilder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public OrderBuilder orderLines(List<OrderLine> orderLines) {
            this.orderLines = orderLines;
            return this;
        }

        public OrderBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public OrderBuilder lastModifiedDate(LocalDateTime lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public Order build() {
            return new Order(this.id, this.reference, this.totalAmount, this.paymentMethod, this.customerId, this.orderLines, this.createdAt, this.lastModifiedDate);
        }

        public String toString() {
            return "Order.OrderBuilder(id=" + this.id + ", reference=" + this.reference + ", totalAmount=" + this.totalAmount + ", paymentMethod=" + this.paymentMethod + ", customerId=" + this.customerId + ", orderLines=" + this.orderLines + ", createdAt=" + this.createdAt + ", lastModifiedDate=" + this.lastModifiedDate + ")";
        }
    }
}
