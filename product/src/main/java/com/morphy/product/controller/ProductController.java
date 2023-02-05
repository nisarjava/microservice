package com.morphy.product.controller;

import com.morphy.product.controller.model.ProductRequest;
import com.morphy.product.controller.model.ProductResponse;
import com.morphy.product.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void createProduct(@RequestBody ProductRequest product){
         service.create(product);
     }

     @GetMapping
     public List<ProductResponse> getAll(){
        return service.getAll();
     }
}
