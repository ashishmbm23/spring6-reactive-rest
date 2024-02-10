package com.ashish.spring6reactiverest.web.v1.mapper;

import com.ashish.spring6reactiverest.domain.Vendor;
import com.ashish.spring6reactiverest.web.v1.model.VendorDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VendorMapper {
    VendorMapper VENDOR_MAPPER = Mappers.getMapper(VendorMapper.class);

    VendorDto convertVendorToVendorDto(Vendor vendor);

    Vendor convertVendorDtoToVendor(VendorDto vendorDto);
}
