package com.eraytasay.database.dal;

import com.eraytasay.database.dto.ProductDto;
import com.eraytasay.database.dto.ProductSaveDto;
import com.eraytasay.database.dto.ProductVendorDto;
import com.eraytasay.database.mapper.ProductMapper;
import com.eraytasay.database.repository.IProductRepository;
import com.eraytasay.database.repository.IVendorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceHelper {
    private final IProductRepository m_productRepository;
    private final IVendorRepository m_vendorRepository;
    private final ProductMapper m_productMapper;

    public ProductServiceHelper(IProductRepository productRepository, IVendorRepository vendorRepository, ProductMapper productMapper)
    {
        m_productRepository = productRepository;
        m_vendorRepository = vendorRepository;
        m_productMapper = productMapper;
    }

    public List<ProductDto> findProductsByVendorUsername(String username)
    {
        return m_productRepository.findProductsByVendorUsername(username);
    }

    public ProductDto saveProduct(ProductSaveDto productSaveDto)
    {
        var product = m_productMapper.toProduct(productSaveDto);
        var vendor = m_vendorRepository.findVendorByUsername(productSaveDto.getVendorUsername());

        assert(vendor.isPresent());

        product.vendor = vendor.get();

        return m_productMapper.toProductDto(m_productRepository.save(product));
    }

    public Page<ProductDto> findProducts(Pageable pageable)
    {
        return m_productRepository.findAll(pageable).map(m_productMapper::toProductDto);
    }

    public Page<ProductVendorDto> findVendorProducts(Pageable pageable)
    {
        return m_productRepository.findAll(pageable).map(m_productMapper::toProductVendorDto);
    }

    public void deleteProduct(int productId)
    {
        m_productRepository.deleteById(productId);
    }
}
