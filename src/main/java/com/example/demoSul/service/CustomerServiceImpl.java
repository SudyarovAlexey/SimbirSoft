package com.example.demoSul.service;

import com.example.demoSul.dto.CustomerDTO;
import com.example.demoSul.mappers.CustomerMapper;
import com.example.demoSul.model.Customer;
import com.example.demoSul.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO readById(Long idCustomer) {
        return customerMapper.toDTO(customerRepository.findById(idCustomer).orElse(null));
    }
    @Override
    public List<Customer> readAll(){
        return customerRepository.findAll();
    }
    @Override
    public void create(Customer customer){
        customerRepository.save(customer);
    }
    @Override
    public void update(Customer customer, Long idCustomer){
        customerRepository.save(customer);
    }
    @Override
    public void delete(Long idCustomer){
        customerRepository.deleteById(idCustomer);
    }
}