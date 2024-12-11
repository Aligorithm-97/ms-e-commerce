package com.aligorithm.ecommerce.order;

import com.aligorithm.ecommerce.customer.CustomerClient;
import com.aligorithm.ecommerce.exception.BusinessException;
import com.aligorithm.ecommerce.orderline.OrderLineRequest;
import com.aligorithm.ecommerce.orderline.OrderLineService;
import com.aligorithm.ecommerce.product.ProductClient;
import com.aligorithm.ecommerce.product.PurchaseRequest;
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


    public OrderService(CustomerClient customerClient, ProductClient productClient, OrderRepository repository, OrderMapper mapper, OrderLineService orderLineService) {
        this.customerClient = customerClient;
        this.productClient = productClient;
        this.repository = repository;
        this.mapper = mapper;
        this.orderLineService = orderLineService;
    }

    public Integer createOrder(OrderRequest request) {
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Customer does not exists !"));

        this.productClient.purchaseProducts(request.products());

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

        return null;
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
