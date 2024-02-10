package com.ashish.spring6reactiverest.bootstrap;

import com.ashish.spring6reactiverest.domain.Category;
import com.ashish.spring6reactiverest.domain.Vendor;
import com.ashish.spring6reactiverest.repository.CategoryRepository;
import com.ashish.spring6reactiverest.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    @Override
    public void run(String... args) throws Exception {
        saveCategory();
        saveVendor();
        log.info("total categories:" + categoryRepository.count().block());
        log.info("total vendors:" + vendorRepository.count().block());
    }

    public void saveCategory(){
        Category wafer = new Category();
        wafer.setId(1l);
        wafer.setName("Wafers");

        Category milkBar = new Category();
        milkBar.setId(2l);
        milkBar.setName("Milk Bar");
        categoryRepository.deleteAll().block();
        categoryRepository.save(wafer).block();
        categoryRepository.save(milkBar).block();
    }

    public void saveVendor()
    {
        Vendor vicko = Vendor.builder().id(1L).firstName("Vajradanti").lastName("Vicko").build();
        Vendor babool = Vendor.builder().id(2L).firstName("Babool").lastName("Waala").build();

        vendorRepository.save(vicko).block();
        vendorRepository.save(babool).block();
    }

}
