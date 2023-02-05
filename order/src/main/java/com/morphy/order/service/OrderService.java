package com.morphy.order.service;

import com.morphy.order.dto.OrderRequest;
import com.morphy.order.dto.OrderResponse;

import java.util.List;

public interface OrderService {

    public String createOrder(OrderRequest orderRequest);
    public List<OrderResponse> getAllOrders();
}
