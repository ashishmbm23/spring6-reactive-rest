package com.ashish.spring6reactiverest.web.v1.mapper;

import com.ashish.spring6reactiverest.domain.Category;
import com.ashish.spring6reactiverest.web.v1.model.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);

    CategoryDto convertCategoryToCategoryDto(Category category);

    Category convertCategortDtoToCategory(CategoryDto categoryDto);

}
