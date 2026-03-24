package com.codewithmosh.store.mapper;

import com.codewithmosh.store.dto.ProductDto;
import com.codewithmosh.store.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source ="category.id", target = "categoryId")
    ProductDto toDto(Product product);
    Product toEntity(ProductDto dto);
    @Mapping(target = "id",  ignore = true)
    void update( ProductDto dto,@MappingTarget Product product);
}
