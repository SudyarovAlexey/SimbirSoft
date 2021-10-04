package com.example.demoSul.service;

import com.example.demoSul.dto.FavoriteDTO;
import com.example.demoSul.model.Favorite;

import java.util.List;

public interface FavoriteService {
    /**
     * Создает сочетание избранного товаров для покупателя
     * @param favorite - товар для включения в список
     */
    void create(Favorite favorite);

    /**
     * Возвращает все сочетания избранных товаров для всех покупателей
     * @return все сочетания изранных товаров
     */
    List<Favorite> readAll();

    /**
     * Возвращает избранное по ID покупателя
     * @param idCustomer - ID клиента
     * @return - избранный товар по заданному ID покупателя
     */
    FavoriteDTO readById(Long idCustomer);

    /**
     * Обновляет избранный товар по заданному ID покупателя
     * @param idCustomer - id клиента список избранного которого нужно обновить
     * @param favorite - товар для добавления в список

     * @return - true если данные были обновлены, иначе false
     */
    void update(Favorite favorite, Long idCustomer);

    /**
     * Удаляет избранны1 товар заданному ID покупателя
     * @param idCustomer - id клиента, список избранного которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    void delete(Long idCustomer);
}
