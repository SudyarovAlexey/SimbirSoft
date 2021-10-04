package com.example.demoSul.service;

import com.example.demoSul.dto.CustomerDTO;
import com.example.demoSul.dto.WarehouseDTO;
import com.example.demoSul.mappers.CustomerMapper;
import com.example.demoSul.mappers.WarehouseMapper;
import com.example.demoSul.model.Customer;
import com.example.demoSul.model.Warehouse;
import com.example.demoSul.repository.CustomerRepository;
import com.example.demoSul.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper warehouseMapper;

    @Override
    public WarehouseDTO readById(Long idPartNumber) {
        return warehouseMapper.toDTO(warehouseRepository.findById(idPartNumber).orElse(null));
    }

    @Override
    public List<Warehouse> readAll() {
        return warehouseRepository.findAll();
    }

    @Override
    public void create(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }

    @Override
    public void update(Warehouse warehouse, Long idPartNumber) {
        warehouseRepository.save(warehouse);
    }

    @Override
    public void delete(Long idPartNumber) {
        warehouseRepository.deleteById(idPartNumber);
    }
}