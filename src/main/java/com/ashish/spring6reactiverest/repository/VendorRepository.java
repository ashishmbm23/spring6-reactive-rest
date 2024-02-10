package com.ashish.spring6reactiverest.repository;

import com.ashish.spring6reactiverest.domain.Vendor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VendorRepository extends ReactiveMongoRepository<Vendor, Long> {
}
