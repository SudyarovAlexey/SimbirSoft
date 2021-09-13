package com.example.demoSul.mappers;

import com.example.demoSul.dto.CustomerDTO;
import com.example.demoSul.model.Customer;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDTO(Customer customer); //mapStruct сам создаст реализацию
}
