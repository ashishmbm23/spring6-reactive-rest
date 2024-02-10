package com.ashish.spring6reactiverest.service;

import com.ashish.spring6reactiverest.web.v1.model.CategoryDto;
import com.ashish.spring6reactiverest.web.v1.model.CategoryListDto;
import reactor.core.publisher.Mono;

public interface CategoryService {
    Mono<CategoryDto> findCategoryById(Long id);

    Mono<CategoryListDto> getAllCategories();
}
