package com.morphy.product.controller.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private String id;
    private int productId;
    private String name;

}
