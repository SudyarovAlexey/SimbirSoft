package com.example.demoSul.controller;

import com.example.demoSul.dto.WarehouseDTO;
import com.example.demoSul.model.Warehouse;
import com.example.demoSul.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping
    public Map<String, Object> readAll() {
        List<Warehouse> products = warehouseService.readAll();
        Map<String, Object> response = new HashMap<>();
        if(products.isEmpty()) {
            response = Collections.singletonMap("result", "not found");
        }
        response.put("result", "ok");
        response.put("data", products);
        return response;
    }

    @GetMapping("/{idProduct}")
    public Map<String, Object> readById(@PathVariable("idProduct") Long productId) {
            Map<String,Object> response = new HashMap<>();
        WarehouseDTO warehouseDTO = warehouseService.readById(productId);
        if (warehouseDTO == null) {
            response = Collections.singletonMap("result", "not found");
            return response;
        }
        response.put("result", "ok");
        response.put("data", warehouseDTO);
        return response;
    }

    @PostMapping
    public Map<String, Object> create(@RequestBody @Validated Warehouse warehouse) {
        if (warehouse.getProductName() == null) {
            return Collections.singletonMap("result", "product not created");
        }
        warehouseService.create(warehouse);
        Map<String, Object> response = new HashMap<>();
        response.put ("result", "ok");
        response.put("data", warehouse);
        return response;
    }

    @PutMapping
    public Map<String, Object> update(@RequestBody @Validated Warehouse warehouse) {
        if (warehouseService.readById(warehouse.getIdPartNumber()) == null) {
            return Collections.singletonMap("result", "product not exist");
        }
        warehouseService.update(warehouse, warehouse.getIdPartNumber());
        Map<String, Object> response = new HashMap<>();
        response.put("result", "ok");
        response.put("data", warehouse);
        return response;
    }

    @DeleteMapping("/{idProduct}")
    public Map<String, Object> delete (@PathVariable ("idProduct") Long productId) {
        WarehouseDTO warehouseDTO = warehouseService.readById(productId);
        if (warehouseDTO == null) {
            return Collections.singletonMap("result", "not found");
        }
        warehouseService.delete(productId);
        return Collections.singletonMap("result", "ok");
    }
}
