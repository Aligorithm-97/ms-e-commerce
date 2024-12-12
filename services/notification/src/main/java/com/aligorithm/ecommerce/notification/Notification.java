package com.aligorithm.ecommerce.notification;

import com.aligorithm.ecommerce.kafka.order.OrderConfirmation;
import com.aligorithm.ecommerce.kafka.payment.PaymentConfirmation;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Notification {

    @Id
    private String id;
    private NotificationType type;
    private LocalDateTime notificationDate;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;

    public Notification(String id, NotificationType type, LocalDateTime notificationDate, OrderConfirmation orderConfirmation, PaymentConfirmation paymentConfirmation) {
        this.id = id;
        this.type = type;
        this.notificationDate = notificationDate;
        this.orderConfirmation = orderConfirmation;
        this.paymentConfirmation = paymentConfirmation;
    }

    public Notification() {
    }

    public static NotificationBuilder builder() {
        return new NotificationBuilder();
    }

    public String getId() {
        return this.id;
    }

    public NotificationType getType() {
        return this.type;
    }

    public LocalDateTime getNotificationDate() {
        return this.notificationDate;
    }

    public OrderConfirmation getOrderConfirmation() {
        return this.orderConfirmation;
    }

    public PaymentConfirmation getPaymentConfirmation() {
        return this.paymentConfirmation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public void setNotificationDate(LocalDateTime notificationDate) {
        this.notificationDate = notificationDate;
    }

    public void setOrderConfirmation(OrderConfirmation orderConfirmation) {
        this.orderConfirmation = orderConfirmation;
    }

    public void setPaymentConfirmation(PaymentConfirmation paymentConfirmation) {
        this.paymentConfirmation = paymentConfirmation;
    }

    public static class NotificationBuilder {
        private String id;
        private NotificationType type;
        private LocalDateTime notificationDate;
        private OrderConfirmation orderConfirmation;
        private PaymentConfirmation paymentConfirmation;

        NotificationBuilder() {
        }

        public NotificationBuilder id(String id) {
            this.id = id;
            return this;
        }

        public NotificationBuilder type(NotificationType type) {
            this.type = type;
            return this;
        }

        public NotificationBuilder notificationDate(LocalDateTime notificationDate) {
            this.notificationDate = notificationDate;
            return this;
        }

        public NotificationBuilder orderConfirmation(OrderConfirmation orderConfirmation) {
            this.orderConfirmation = orderConfirmation;
            return this;
        }

        public NotificationBuilder paymentConfirmation(PaymentConfirmation paymentConfirmation) {
            this.paymentConfirmation = paymentConfirmation;
            return this;
        }

        public Notification build() {
            return new Notification(this.id, this.type, this.notificationDate, this.orderConfirmation, this.paymentConfirmation);
        }

        public String toString() {
            return "Notification.NotificationBuilder(id=" + this.id + ", type=" + this.type + ", notificationDate=" + this.notificationDate + ", orderConfirmation=" + this.orderConfirmation + ", paymentConfirmation=" + this.paymentConfirmation + ")";
        }
    }
}
