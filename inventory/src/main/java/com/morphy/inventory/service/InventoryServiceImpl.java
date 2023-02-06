package com.morphy.inventory.service;

import com.morphy.inventory.domain.Inventory;
import com.morphy.inventory.dto.InventoryResponse;
import com.morphy.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl  implements  InventoryService{

    @Autowired
    private InventoryRepository repository;

    /**
     * @param code
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> code) {
       return  repository.findByCodeIn(code).stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    private InventoryResponse mapToResponse(Inventory inventory) {
      return  InventoryResponse.builder()
                .code(inventory.getCode())
                .isInStock(inventory.getQuantity()>0)
                .build();
    }
}
