package com.ashish.spring6reactiverest.service;

import com.ashish.spring6reactiverest.web.v1.model.VendorDto;
import com.ashish.spring6reactiverest.web.v1.model.VendorListDto;
import reactor.core.publisher.Mono;

public interface VendorService {
    Mono<VendorListDto> getAllVendors();

    Mono<VendorDto> getVendorById(Long id);
}
