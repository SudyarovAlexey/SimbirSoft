package com.example.demoSul.controller;

import com.example.demoSul.dto.FavoriteDTO;
import com.example.demoSul.model.Favorite;
import com.example.demoSul.service.FavoriteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/favorite")
@Api("Контроллер для работы с избранными товарами")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @ApiOperation("Получение всех списков избранных товаров")
    @GetMapping
    public Map<String, Object> readAll() {
        List<Favorite> favorites = favoriteService.readAll();
        Map<String, Object> response = new HashMap<>();
        if (favorites.isEmpty()) {
            response = Collections.singletonMap("result", "not found");
        }
        response.put("result", "ok");
        response.put("data", favorites);
        return response;
    }

    @ApiOperation("Получение списка избранных товаров по id покупателя")
    @GetMapping("/{idCustomer}")
    public Map<String, Object> readById(@PathVariable("idCustomer") Long customerId) {
        Map<String, Object> response = new HashMap<>();
        FavoriteDTO favoriteDTO = favoriteService.readById(customerId);
        if (favoriteDTO == null) {
            response = Collections.singletonMap("result", "not found");
            return response;
        }
        response.put("result", "ok");
        response.put("data", favoriteDTO);
        return response;
    }

    @ApiOperation("Создание списка избранных товаров")
    @PostMapping
    public Map<String, Object> create(@RequestBody @Validated Favorite favorite) {
        if (favorite.getIdCustomer() == null) {
            return Collections.singletonMap("result", "customer not created");
        }
        favoriteService.create(favorite);
        Map<String, Object> response = new HashMap<>();
        response.put("result", "ok");
        response.put("data", favorite);
        return response;
    }

    @ApiOperation("Обновление данных об избранных товаров")
    @PutMapping
    public Map<String, Object> update(@RequestBody @Validated Favorite favorite) {
        if (favoriteService.readById(favorite.getIdCustomer()) == null) {
            return Collections.singletonMap("result", "customer not exist");
        }
        favoriteService.update(favorite, favorite.getIdCustomer());
        Map<String, Object> response = new HashMap<>();
        response.put("result", "ok");
        response.put("data", favorite);
        return response;
    }

    @ApiOperation("Удаление списка избранных товаро покупателя")
    @DeleteMapping("/{idCustomer}")
    public Map<String, Object> delete(@PathVariable("idCustomer") Long customerId) {
        FavoriteDTO favoriteDTO = favoriteService.readById(customerId);
        if (favoriteDTO == null) {
            return Collections.singletonMap("result", "not found");
        }
        favoriteService.delete(customerId);
        return Collections.singletonMap("result", "ok");
    }
}
