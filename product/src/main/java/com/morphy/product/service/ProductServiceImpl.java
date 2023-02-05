package com.morphy.product.service;

import com.morphy.product.controller.model.ProductRequest;
import com.morphy.product.controller.model.ProductResponse;
import com.morphy.product.domain.Product;
import com.morphy.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository repository;
    /**
     * @param
     * @return
     */
    @Override
    public boolean create(ProductRequest productRequest) {
     Product product=   Product.builder()
                .name(productRequest.getName())
             .productId(productRequest.getProductId())
             .description(productRequest.getDescription())
             .price(productRequest.getPrice())
                .build();

     repository.save(product);
    log.info("Product {} saved successfully",product.getId());



        return false;
    }

    /**
     * @param p
     * @return
     */
    @Override
    public int update(ProductRequest p) {
        return 0;
    }

    /**
     * @param p
     * @return
     */
    @Override
    public int delete(ProductRequest p) {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public List<ProductResponse> getAll() {
        return repository.findAll().stream().map(this::mapToProductResponse).collect(Collectors.toList());

    }

    private ProductResponse mapToProductResponse(Product product) {
       return ProductResponse.builder()
               .id(product.getId())
               .productId(product.getProductId())
               .name(product.getName())
               .build();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ProductResponse getById(String id) {
        return null;
    }
}
