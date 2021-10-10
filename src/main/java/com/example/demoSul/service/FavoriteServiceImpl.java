package com.example.demoSul.service;

import com.example.demoSul.dto.FavoriteDTO;
import com.example.demoSul.mappers.FavoriteMapper;
import com.example.demoSul.model.Favorite;
import com.example.demoSul.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final FavoriteMapper favoriteMapper;

    @Override
    public FavoriteDTO readById(Long idCustomer) {
        favoriteRepository.getById(idCustomer);
        return favoriteMapper.toDTO(favoriteRepository.findById(idCustomer).orElse(null));
    }

    @Override
    public List<Favorite> readAll() {
        return favoriteRepository.findAll();
    }

    @Override
    public void create(Favorite favorite) {
        favoriteRepository.save(favorite);
    }

    @Override
    public void update(Favorite favorite, Long idCustomer) {
        favoriteRepository.save(favorite);
    }

    @Override
    public void delete(Long idCustomer) {
        favoriteRepository.deleteById(idCustomer);
    }
}