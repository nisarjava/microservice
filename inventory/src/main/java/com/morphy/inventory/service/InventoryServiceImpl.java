package com.morphy.inventory.service;

import com.morphy.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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
    public boolean isInStock(String code) {
       return  repository.findByCode(code).isPresent();
    }
}
