package com.aligorithm.ecommerce.orderline;

import com.aligorithm.ecommerce.order.Order;
import jakarta.persistence.*;

@Entity
public class OrderLine {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private Integer productId;
    private double quantity;

    public OrderLine(Integer id, Order order, Integer productId, double quantity) {
        this.id = id;
        this.order = order;
        this.productId = productId;
        this.quantity = quantity;
    }

    public OrderLine() {
    }

    public static OrderLineBuilder builder() {
        return new OrderLineBuilder();
    }

    public Integer getId() {
        return this.id;
    }

    public Order getOrder() {
        return this.order;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public static class OrderLineBuilder {
        private Integer id;
        private Order order;
        private Integer productId;
        private double quantity;

        OrderLineBuilder() {
        }

        public OrderLineBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public OrderLineBuilder order(Order order) {
            this.order = order;
            return this;
        }

        public OrderLineBuilder productId(Integer productId) {
            this.productId = productId;
            return this;
        }

        public OrderLineBuilder quantity(double quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderLine build() {
            return new OrderLine(this.id, this.order, this.productId, this.quantity);
        }

        public String toString() {
            return "OrderLine.OrderLineBuilder(id=" + this.id + ", order=" + this.order + ", productId=" + this.productId + ", quantity=" + this.quantity + ")";
        }
    }
}
