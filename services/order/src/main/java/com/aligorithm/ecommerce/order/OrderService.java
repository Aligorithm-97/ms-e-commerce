package com.aligorithm.ecommerce.order;

import com.aligorithm.ecommerce.customer.CustomerClient;
import com.aligorithm.ecommerce.exception.BusinessException;
import com.aligorithm.ecommerce.kafka.OrderConfirmation;
import com.aligorithm.ecommerce.kafka.OrderProducer;
import com.aligorithm.ecommerce.orderline.OrderLineRequest;
import com.aligorithm.ecommerce.orderline.OrderLineService;
import com.aligorithm.ecommerce.product.ProductClient;
import com.aligorithm.ecommerce.product.PurchaseRequest;
import com.aligorithm.ecommerce.product.PurchaseResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;


    public OrderService(CustomerClient customerClient, ProductClient productClient, OrderRepository repository, OrderMapper mapper, OrderLineService orderLineService, OrderProducer orderProducer) {
        this.customerClient = customerClient;
        this.productClient = productClient;
        this.repository = repository;
        this.mapper = mapper;
        this.orderLineService = orderLineService;
        this.orderProducer = orderProducer;
    }

    public Integer createOrder(OrderRequest request) {
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Customer does not exists !"));

        var purchasedProducts = this.productClient.purchaseProducts(request.products());

        var order = this.repository.save(mapper.toOrder(request));

        for (PurchaseRequest purchaseRequest : request.products()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }
        // todo start payment process

        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getId();
    }

    public List<OrderResponse> findAllOrders() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer id) {
        return this.repository.findById(id)
                .map(this.mapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No order found with the provided ID: %d", id)));
    }
}
