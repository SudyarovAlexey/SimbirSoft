package com.example.demoSul.controller;

import com.example.demoSul.model.Customer;
import com.example.demoSul.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String findAll(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customer-list";
    }
    @GetMapping("/customer-create")
    public String createCustomerForm (Customer customer){
        return "customer-create";
    }
    @PostMapping("/customer-create")
    public String createCustomer(Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
    @GetMapping("/customer-delete/{idCustomer}")
    public String deleteCustomer (@PathVariable("idCustomer") Long idCustomer) {
        customerService.deleteById(idCustomer);
        return "redirect:/customers";
    }
    @GetMapping("/customer-update/{idCustomer}")
    public String updateCustomerForm(@PathVariable("idCustomer") Long idCustomer, Model model){
        Customer customer = customerService.findById(idCustomer);
        model.addAttribute("customer", customer);
        return "customer-update";
    }
    @PostMapping("/customer-update")
    public String updateCustomer (Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
}
