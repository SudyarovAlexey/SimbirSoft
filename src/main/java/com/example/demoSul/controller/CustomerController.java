package com.example.demoSul.controller;

import com.example.demoSul.dto.CustomerDTO;
import com.example.demoSul.model.Customer;
import com.example.demoSul.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
@Api("Контроллер для работы с покупателями")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation("Получание списка всех покупателей")
    @GetMapping
    public Map<String, Object> readAll() {
        List<Customer> customers = customerService.readAll();
        Map<String, Object> response = new HashMap<>();
        if (customers.isEmpty()) {
            response = Collections.singletonMap("result", "not found");
        }
        response.put("result", "ok");
        response.put("data", customers);
        return response;
    }

    @ApiOperation("Получение данных о покупателе по id")
    @GetMapping("/{idCustomer}")
    public Map<String, Object> readById(@PathVariable("idCustomer") Long customerId) {
        Map<String, Object> response = new HashMap<>();
        CustomerDTO customerDTO = customerService.readById(customerId);
        if (customerDTO == null) {
            response = Collections.singletonMap("result", "not found");
            return response;
        }
        response.put("result", "ok");
        response.put("data", customerDTO);
        return response;
    }

    @ApiOperation("Внесение данных о новом покупателе")
    @PostMapping
    public Map<String, Object> create(@RequestBody @Validated Customer customer) {
        if (customer.getNameCustomer() == null) {
            return Collections.singletonMap("result", "customer not created");
        }
        customerService.create(customer);
        Map<String, Object> response = new HashMap<>();
        response.put("result", "ok");
        response.put("data", customer);
        return response;
    }

    @ApiOperation("Обновление данных о покупателе")
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

    @ApiOperation("Удаление данных о покупателе")
    @DeleteMapping("/{idCustomer}")
    public Map<String, Object> delete(@PathVariable("idCustomer") Long customerId) {
        CustomerDTO customerDTO = customerService.readById(customerId);
        if (customerDTO == null) {
            return Collections.singletonMap("result", "not found");
        }
        customerService.delete(customerId);
        return Collections.singletonMap("result", "ok");
    }
}
