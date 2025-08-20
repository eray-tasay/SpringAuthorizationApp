package com.eraytasay.database.dal;

import com.eraytasay.database.dto.ProductDto;
import com.eraytasay.database.dto.VendorDto;
import com.eraytasay.database.dto.VendorSaveDto;
import com.eraytasay.database.mapper.VendorMapper;
import com.eraytasay.database.repository.IProductRepository;
import com.eraytasay.database.repository.IVendorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VendorServiceHelper {
    private final IVendorRepository m_vendorRepository;
    private final IProductRepository m_productRepository;
    private final VendorMapper m_vendorMapper;
    private final PasswordEncoder m_passwordEncoder;

    public VendorServiceHelper(IVendorRepository vendorRepository, IProductRepository productRepository, VendorMapper vendorMapper, PasswordEncoder passwordEncoder)
    {
        m_vendorRepository = vendorRepository;
        m_productRepository = productRepository;
        m_vendorMapper = vendorMapper;
        m_passwordEncoder = passwordEncoder;
    }

    public Optional<VendorDto> findVendorByUsername(String username)
    {
        return m_vendorRepository.findVendorByUsername(username).map(m_vendorMapper::toVendorDto);
    }

    public VendorDto saveVendor(VendorSaveDto vendorSaveDto)
    {
        var purchaser = m_vendorMapper.toVendor(vendorSaveDto, m_passwordEncoder);

         return m_vendorMapper.toVendorDto(m_vendorRepository.save(purchaser));
    }
    public List<ProductDto> findProductsByVendorUsername(String username)
    {
        return m_productRepository.findProductsByVendorUsername(username);
    }
}
