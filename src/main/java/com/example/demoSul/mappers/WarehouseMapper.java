package com.example.demoSul.mappers;

import com.example.demoSul.dto.WarehouseDTO;
import com.example.demoSul.model.Warehouse;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface WarehouseMapper {
    WarehouseDTO toDTO(Warehouse warehouse);
}


