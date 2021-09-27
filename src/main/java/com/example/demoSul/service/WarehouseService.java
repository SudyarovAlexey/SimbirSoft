package com.example.demoSul.service;

import com.example.demoSul.dto.CustomerDTO;
import com.example.demoSul.dto.WarehouseDTO;
import com.example.demoSul.model.Customer;
import com.example.demoSul.model.Warehouse;

import java.util.List;

public interface WarehouseService {
    /**
     * Создает нового клиента
     * @param warehouse - заказ для создания
     */
    void create(Warehouse warehouse);

    /**
     * Возвращает список всех имеющихся клиентов
     * @return список товаров
     */
    List<Warehouse> readAll();

    /**
     * Возвращает клиента по его ID
     * @param idPartNumber - ID товара
     * @return - объект товара с заданным ID
     */
    WarehouseDTO readById(Long idPartNumber);

    /**
     * Обновляет товар с заданным ID,
     * в соответствии с переданным товаром
     * @param warehouse - клиент в соответсвии с которым нужно обновить данные
     * @param idPartNumber - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    void update(Warehouse warehouse, Long idPartNumber);

    /**
     * Удаляет товар с заданным ID
     * @param idPartNumber - id товара, который нужно удалить
     * @return - true если товар был удален, иначе false
     */
    void delete(Long idPartNumber);
}
