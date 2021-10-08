package com.example.demoSul.controller;

import com.example.demoSul.dto.CustomerDTO;
import com.example.demoSul.model.Customer;
import com.example.demoSul.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
@Tag(name="Пользователи", description="Управление составом пользователей")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @Operation(summary = "Все покупатели", description = "Получение полного списка покупателей")
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
    @Operation(summary = "Данные одного покупателя", description = "Получение данных одного покупателя по id")
    public Map<String, Object> readById(@PathVariable @RequestPart("idCustomer") @Min(0) @Parameter(description = "Указать id покупателя") Long customerId) {
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
    @Operation(summary = "Ввод данных покупателя", description = "Ввод данных нового покупателя")
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
    @Operation(summary = "Обновление данных покупателя", description = "Обновление данных существующего покупателя по id")
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
    @Operation(summary = "Удаление покупателя", description = "Удаление данных покупателя по id")
    public Map<String, Object> delete (@PathVariable @RequestPart("idCustomer") @Min(0) @Parameter(description = "Указать id покупателя") Long customerId) {
        CustomerDTO customerDTO = customerService.readById(customerId);
        if (customerDTO == null) {
            return Collections.singletonMap("result", "not found");
        }
        customerService.delete(customerId);
        return Collections.singletonMap("result", "ok");
    }
}
