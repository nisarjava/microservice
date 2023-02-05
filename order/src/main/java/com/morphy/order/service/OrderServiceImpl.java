package com.morphy.order.service;

import com.morphy.order.domain.Order;
import com.morphy.order.domain.OrderLineItem;
import com.morphy.order.dto.*;
import com.morphy.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    /**
     * @param orderRequest
     */
    @Override
    public String createOrder(OrderRequest orderRequest) {
        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderLineItemsList(orderRequest.getLineItems()
                                    .stream()
                                    .map(this::mapToOrderLineItems)
                                    .collect(Collectors.toList()));

     return repository.save(order).getOrderNumber();

    }

    private OrderLineItem mapToOrderLineItems(OrderLineItemDTO orderLineItemDTO) {
        OrderLineItem lineItem= new OrderLineItem();
        lineItem.setCode(orderLineItemDTO.getCode());
        lineItem.setPrice(orderLineItemDTO.getPrice());
        lineItem.setQuantity(orderLineItemDTO.getQuantity());
        return lineItem;
    }

    /**
     * @return
     */
    @Override
    public List<OrderResponse> getAllOrders() {
        return repository.findAll().stream().map(this::mapResponse).collect(Collectors.toList());
    }

    private OrderResponse mapResponse(Order order) {
     return   OrderResponse.builder()
                .orderNumber(order.getOrderNumber())
                .id(order.getId())
                .build();
    }
}
