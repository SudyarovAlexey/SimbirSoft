package com.example.demoSul.service;

import com.example.demoSul.dto.CustomerDTO;
import com.example.demoSul.mappers.CustomerMapper;
import com.example.demoSul.model.Customer;
import com.example.demoSul.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO readById(Long idCustomer) {
//        log.info("IN CustomerServiceImpl readById {}", idCustomer);
        return customerMapper.toDTO(customerRepository.findById(idCustomer).get());
    }
    @Override
    public List<Customer> readAll(){
//        log.info("IN CustomerServiceImpl readAll");
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

//@Service
//public class CustomerService {
//
//    private final CustomerRepository customerRepository;
//
//    public CustomerService(CustomerRepository customerRepository){
//        this.customerRepository = customerRepository;
//    }
//
//    public Customer findById(Long idCustomer){
//        return customerRepository.getOne(idCustomer);
//}
