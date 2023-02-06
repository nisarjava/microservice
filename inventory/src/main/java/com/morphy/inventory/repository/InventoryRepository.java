package com.morphy.inventory.repository;

import com.morphy.inventory.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    List<Inventory> findByCodeIn(List<String> code);
}