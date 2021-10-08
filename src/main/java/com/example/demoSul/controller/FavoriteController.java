package com.example.demoSul.controller;

import com.example.demoSul.dto.FavoriteDTO;
import com.example.demoSul.model.Favorite;
import com.example.demoSul.service.FavoriteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/favorite")
@Tag(name="Избранное", description="Управление списками избранных товаров")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping
    @Operation(summary = "Все списки избранного", description = "Получение полного перечня покупателей и их избранных товаров")
    public Map<String, Object> readAll() {
        List<Favorite> favorites = favoriteService.readAll();
        Map<String, Object> response = new HashMap<>();
        if(favorites.isEmpty()) {
            response = Collections.singletonMap("result", "not found");
        }
        response.put("result", "ok");
        response.put("data", favorites);
        return response;
    }

    @GetMapping("/{idCustomer}")
    @Operation(summary = "Списко избранного покупателя", description = "Получение списка избранного одного по id покупателя")
    public Map<String, Object> readById(@PathVariable("idCustomer") Long customerId) {
            Map<String,Object> response = new HashMap<>();
        FavoriteDTO favoriteDTO = favoriteService.readById(customerId);
        if (favoriteDTO == null) {
            response = Collections.singletonMap("result", "not found");
            return response;
        }
        response.put("result", "ok");
        response.put("data", favoriteDTO);
        return response;
    }

    @PostMapping
    @Operation(summary = "Создание списка избранных товаров", description = "Создание взаимосвязи покупатель - избранный товар")
    public Map<String, Object> create(@RequestBody @Validated Favorite favorite) {
        if (favorite.getIdCustomer() == null) {
            return Collections.singletonMap("result", "customer not created");
        }
        favoriteService.create(favorite);
        Map<String, Object> response = new HashMap<>();
        response.put ("result", "ok");
        response.put("data", favorite);
        return response;
    }

    @PutMapping
    @Operation(summary = "Обновление списка избранных товаров", description = "Обновление списка избранных товаров по id покупателя")
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

    @Operation(summary = "Удаление списка избранных товаров", description = "Удаление списка избранных товаров по id покупателя")
    @DeleteMapping("/{idCustomer}")
    public Map<String, Object> delete (@PathVariable ("idCustomer") Long customerId) {
        FavoriteDTO favoriteDTO = favoriteService.readById(customerId);
        if (favoriteDTO == null) {
            return Collections.singletonMap("result", "not found");
        }
        favoriteService.delete(customerId);
        return Collections.singletonMap("result", "ok");
    }
}
