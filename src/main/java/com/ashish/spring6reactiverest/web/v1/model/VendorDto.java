package com.ashish.spring6reactiverest.web.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDto {
    private Long id;
    private String firstName;
    private String lastName;
    @JsonProperty("vendor_url")
    private String vendorUrl;
}
