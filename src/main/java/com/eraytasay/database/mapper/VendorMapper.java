package com.eraytasay.database.mapper;

import com.eraytasay.database.dto.VendorDto;
import com.eraytasay.database.dto.VendorSaveDto;
import com.eraytasay.database.entity.Vendor;
import com.eraytasay.database.view.IVendorView;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VendorMapper {
    public VendorDto toVendorDto(IVendorView vendorView)
    {
        var vendorDto = new VendorDto();

        vendorDto.id = vendorView.getId();
        vendorDto.username = vendorView.getUsername();
        vendorDto.company = vendorView.getCompany();
        vendorDto.registerDateTime = vendorView.getRegisterDateTime();
        vendorDto.products = vendorView.getProducts();

        return vendorDto;
    }

    public VendorDto toVendorDto(Vendor vendor)
    {
        var vendorDto = new VendorDto();

        vendorDto.id = vendor.id;
        vendorDto.username = vendor.username;
        vendorDto.company = vendor.company;
        vendorDto.registerDateTime = vendor.registerDateTime;
        vendorDto.products = vendor.products;

        return vendorDto;
    }

    public Vendor toVendor(VendorSaveDto vendorSaveDto, PasswordEncoder passwordEncoder)
    {
        var vendor = new Vendor();

        vendor.username = vendorSaveDto.getUsername();
        vendor.password = passwordEncoder.encode(vendorSaveDto.getPassword());
        vendor.company = vendorSaveDto.getCompany();
        vendor.registerDateTime = LocalDateTime.now();

        return vendor;
    }
}
