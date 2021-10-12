package com.example.demoSul.service;

import com.example.demoSul.dto.CustomerDTO;
import com.example.demoSul.model.Customer;

import java.util.List;

public interface CustomerService {
    /**
     * Создает нового клиента
     *
     * @param customer - клиент для создания
     */
    void create(Customer customer);

    /**
     * Возвращает список всех имеющихся клиентов
     *
     * @return список клиентов
     */
    List<Customer> readAll();

    /**
     * Возвращает клиента по его ID
     *
     * @param idCustomer - ID клиента
     * @return - объект клиента с заданным ID
     */
    CustomerDTO readById(Long idCustomer);

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     *
     * @param customer   - клиент в соответсвии с которым нужно обновить данные
     * @param idCustomer - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    void update(Customer customer, Long idCustomer);

    /**
     * Удаляет клиента с заданным ID
     *
     * @param idCustomer - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    void delete(Long idCustomer);
}
