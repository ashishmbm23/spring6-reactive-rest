package com.ashish.spring6reactiverest.service;

import com.ashish.spring6reactiverest.repository.VendorRepository;
import com.ashish.spring6reactiverest.web.v1.controllers.CategoryController;
import com.ashish.spring6reactiverest.web.v1.mapper.VendorMapper;
import com.ashish.spring6reactiverest.web.v1.model.VendorDto;
import com.ashish.spring6reactiverest.web.v1.model.VendorListDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
@Service
@AllArgsConstructor
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;
    @Override
    public Mono<VendorListDto> getAllVendors() {
        return vendorRepository
                .findAll()
                .map(vendor -> {
                    VendorDto vendorDto = vendorMapper.convertVendorToVendorDto(vendor);
                    vendorDto.setVendorUrl(getUrl(vendor.getId()));
                    return vendorDto;
                })
                .collectList()
                .map(VendorListDto::new);
    }

    @Override
    public Mono<VendorDto> getVendorById(Long id) {
        return vendorRepository.findById(id)
                .map(vendorMapper::convertVendorToVendorDto);
    }

    public String getUrl(Long id){
        return CategoryController.CATEGORY_BASE_URL + "/" + id;
    }


}
