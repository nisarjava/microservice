package com.morphy.product.service;

import com.morphy.product.controller.model.ProductRequest;
import com.morphy.product.controller.model.ProductResponse;
import com.morphy.product.domain.Product;

import java.util.List;

public interface ProductService {
    public boolean create(ProductRequest p);
    public int update(ProductRequest p);
    public int delete(ProductRequest p);
    public List<ProductResponse> getAll();
    public ProductResponse getById(String id);

}
