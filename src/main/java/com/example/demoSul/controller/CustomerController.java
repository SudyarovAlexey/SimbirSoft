package com.example.demoSul.controller;

import com.example.demoSul.dto.CustomerDTO;
import com.example.demoSul.model.Customer;
import com.example.demoSul.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public Map<String, Object> readAll() {
        List<Customer> customers = customerService.readAll();
        Map<String, Object> response = new HashMap<>();
        if(customers.isEmpty()) {
            response = Collections.singletonMap("result", "not found");
        }
        response.put("result", "ok");
        response.put("data", customers);
        return response;
    }

    @GetMapping("/{idCustomer}")
    public Map<String, Object> readById(@PathVariable(name = "idCustomer") Long customerId) {
            Map<String,Object> response = new HashMap<>();
        CustomerDTO customerDTO = customerService.readById(customerId);
        if (customerDTO == null) {
            response = Collections.singletonMap("result", "not found");
            return response;
        }
        response.put("result", "ok");
        response.put("data", customerDTO);
        return response;
    }

    @PostMapping
    public Map<String, Object> create(@RequestBody @Validated Customer customer) {
        if (customer.getNameCustomer() == null) {
            return Collections.singletonMap("result", "customer not created");
        }
        customerService.create(customer);
        Map<String, Object> response = new HashMap<>();
        response.put ("result", "ok");
        response.put("data", customer);
        return response;
    }

    @PutMapping
    public Map<String, Object> update(@RequestBody @Validated Customer customer) {
        if (customerService.readById(customer.getIdCustomer()) == null) {
            return Collections.singletonMap("result", "customer not exist");
        }
        customerService.update(customer, customer.getIdCustomer());
        Map<String, Object> response = new HashMap<>();
        response.put("result", "ok");
        response.put("data", customer);
        return response;
    }

    @DeleteMapping("/{idCustomer}")
    public Map<String, Object> delete (@PathVariable (name = "idCustomer") Long customerId) {
        CustomerDTO customerDTO = customerService.readById(customerId);
        if (customerDTO == null) {
            return Collections.singletonMap("result", "not found");
        }
        customerService.delete(customerId);
        return Collections.singletonMap("result", "ok");
    }
}
