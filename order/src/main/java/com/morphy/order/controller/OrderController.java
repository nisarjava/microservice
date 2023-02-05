package com.morphy.order.controller;

import com.morphy.order.dto.OrderRequest;
import com.morphy.order.dto.OrderResponse;
import com.morphy.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService service;
    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
       return  service.createOrder(orderRequest);
    }

    @GetMapping
    public List<OrderResponse> getAllOrders(){
    return service.getAllOrders();
    }


}
