package com.example.demoSul.service;

import com.example.demoSul.model.Customer;
import com.example.demoSul.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(Long idCustomer){
        return customerRepository.getOne(idCustomer);
    }
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer){
       return customerRepository.save(customer);
    }
    public void deleteById(Long idCustomer){
        customerRepository.deleteById(idCustomer);
    }
}
