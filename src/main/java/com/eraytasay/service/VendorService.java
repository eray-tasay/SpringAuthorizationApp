package com.eraytasay.service;

import com.eraytasay.database.dal.VendorServiceHelper;
import com.eraytasay.database.dto.ProductDto;
import com.eraytasay.database.dto.VendorDto;
import com.eraytasay.database.dto.VendorSaveDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {
    private final VendorServiceHelper m_vendorServiceHelper;

    public VendorService(VendorServiceHelper vendorServiceHelper)
    {
        m_vendorServiceHelper = vendorServiceHelper;
    }

    public VendorDto saveVendor(VendorSaveDto vendorSaveDto)
    {
        return m_vendorServiceHelper.saveVendor(vendorSaveDto);
    }

    public Optional<VendorDto> findVendorByUsername(String username)
    {
        return m_vendorServiceHelper.findVendorByUsername(username);
    }

    public List<ProductDto> findProductsByVendorUsername(String username)
    {
        return m_vendorServiceHelper.findProductsByVendorUsername(username);
    }
}
