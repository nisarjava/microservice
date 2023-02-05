package com.morphy.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemDTO {
    private Long id;
    private String code;
    private BigDecimal price;
    private Integer quantity;
}
