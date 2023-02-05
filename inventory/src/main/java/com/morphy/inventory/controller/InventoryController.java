package com.morphy.inventory.controller;

import com.morphy.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("code") String code) {
        return service.isInStock(code);
    }
}
