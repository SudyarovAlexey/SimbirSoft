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

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<Customer>> readAll() {
        List<Customer> customers = customerService.readAll();
        HttpHeaders headers = new HttpHeaders();
        if (customers.isEmpty()) {
            return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{idCustomer}")
    public Map<String, Object> readById(@PathVariable(name = "idCustomer") Long customerId) {
            Map<String,Object> response = new HashMap<>();
        CustomerDTO customerDTO = customerService.readById(customerId);
        if (customerDTO == null) {
            response = Collections.singletonMap("result", "not found");
            return response;
        }
        response.put("readById", customerDTO);
        return response;
    }

    @PostMapping("")
    public ResponseEntity<Customer> create(@RequestBody @Validated Customer customer) {
        HttpHeaders headers = new HttpHeaders();
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        customerService.create(customer);
        return new ResponseEntity<>(customer, headers, HttpStatus.CREATED);
    }

    @PutMapping("/{idCustomer}")
    public ResponseEntity<Customer> update(@RequestBody @Validated Customer customer, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        customerService.create(customer);
        return new ResponseEntity<>(customer, headers, HttpStatus.OK);
    }

    @DeleteMapping("/{idCustomer}")
    public ResponseEntity<CustomerDTO> delete(@PathVariable(name = "idCustomer") Long customerId) {
        CustomerDTO customerDTO = customerService.readById(customerId);
        if (customerDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerService.delete(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
