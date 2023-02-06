package com.morphy.order.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "t_orderItem")

@Getter
@Setter
public class OrderLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String code;
    private BigDecimal price;
    private Integer quantity;

}
