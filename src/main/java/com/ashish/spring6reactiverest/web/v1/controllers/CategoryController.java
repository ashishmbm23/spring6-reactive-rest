package com.ashish.spring6reactiverest.web.v1.controllers;

import com.ashish.spring6reactiverest.service.CategoryService;
import com.ashish.spring6reactiverest.web.v1.model.CategoryDto;
import com.ashish.spring6reactiverest.web.v1.model.CategoryListDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(CategoryController.CATEGORY_BASE_URL)
@AllArgsConstructor
public class CategoryController {
    public static final String CATEGORY_BASE_URL = "/api/v1/category";
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Mono<CategoryListDto>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<CategoryDto>> getAllCategories(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.findCategoryById(id), HttpStatus.OK);
    }

}
