package com.ashish.spring6reactiverest.web.v1.controllers;

import com.ashish.spring6reactiverest.service.VendorService;
import com.ashish.spring6reactiverest.web.v1.model.VendorDto;
import com.ashish.spring6reactiverest.web.v1.model.VendorListDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(VendorController.VENDOR_BASE_URL)
@AllArgsConstructor
@Slf4j
public class VendorController {
    public static final String VENDOR_BASE_URL = "/api/v1/vendor";
    private final VendorService vendorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<VendorListDto> getAllVendors(){
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<VendorDto> findVendorById(@PathVariable Long id){
        return vendorService.getVendorById(id);
    }


}
