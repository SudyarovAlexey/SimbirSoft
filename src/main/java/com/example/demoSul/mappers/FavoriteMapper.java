package com.example.demoSul.mappers;

import com.example.demoSul.dto.FavoriteDTO;
import com.example.demoSul.model.Favorite;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FavoriteMapper {
    FavoriteDTO toDTO(Favorite favorite);
}


