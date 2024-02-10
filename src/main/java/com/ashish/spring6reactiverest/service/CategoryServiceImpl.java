package com.ashish.spring6reactiverest.service;

import com.ashish.spring6reactiverest.repository.CategoryRepository;
import com.ashish.spring6reactiverest.web.v1.controllers.CategoryController;
import com.ashish.spring6reactiverest.web.v1.mapper.CategoryMapper;
import com.ashish.spring6reactiverest.web.v1.model.CategoryDto;
import com.ashish.spring6reactiverest.web.v1.model.CategoryListDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    @Override
    public Mono<CategoryDto> findCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::convertCategoryToCategoryDto);
    }

    @Override
    public Mono<CategoryListDto> getAllCategories() {
        return getListOfCategories()
                .collectList()
                .map(CategoryListDto::new);
    }

    public Flux<CategoryDto> getListOfCategories() {
        return categoryRepository.findAll()
                .map(category -> {
                    CategoryDto categoryDto = categoryMapper.convertCategoryToCategoryDto(category);
                    categoryDto.setCategoryUrl(getUrl(category.getId()));
                    return categoryDto;
                });
    }

    public String getUrl(Long id){
        return CategoryController.CATEGORY_BASE_URL + "/" + id;
    }



}
