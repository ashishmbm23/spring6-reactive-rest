package com.ashish.spring6reactiverest.repository;

import com.ashish.spring6reactiverest.domain.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category, Long> {
}
