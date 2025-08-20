package com.eraytasay.database.dal;

import com.eraytasay.database.dto.ProductDto;
import com.eraytasay.database.mapper.ProductMapper;
import com.eraytasay.database.repository.IProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class VendorProductServiceHelper {
    private final IProductRepository m_productRepository;
    private final ProductMapper m_productMapper;

    public VendorProductServiceHelper(IProductRepository productRepository, ProductMapper productMapper)
    {
        m_productRepository = productRepository;
        m_productMapper = productMapper;
    }

    public Page<ProductDto> findProducts(Pageable pageable)
    {
        return m_productRepository.findAll(pageable).map(m_productMapper::toProductDto);
    }
}
