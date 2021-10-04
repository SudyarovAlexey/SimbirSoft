package com.example.demoSul.controller;

import com.example.demoSul.dto.CustomerDTO;
import com.example.demoSul.dto.FavoriteDTO;
import com.example.demoSul.model.Customer;
import com.example.demoSul.model.Favorite;
import com.example.demoSul.service.FavoriteService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping
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
