package com.morphy.inventory.service;

import com.morphy.inventory.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {
    public List<InventoryResponse> isInStock(List<String> code);
}
