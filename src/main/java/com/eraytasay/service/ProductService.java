package com.eraytasay.service;

import com.eraytasay.database.dal.ProductServiceHelper;
import com.eraytasay.database.dto.ProductDto;
import com.eraytasay.database.dto.ProductSaveDto;
import com.eraytasay.database.dto.ProductVendorDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductServiceHelper m_productServiceHelper;

    @Value("${products.page.size}")
    private int m_pageSize;

    public ProductService(ProductServiceHelper productServiceHelper)
    {
        m_productServiceHelper = productServiceHelper;
    }

    public ProductDto saveProduct(ProductSaveDto productSaveDto)
    {
        return m_productServiceHelper.saveProduct(productSaveDto);
    }

    public Page<ProductDto> findProducts(int pageNumber)
    {
        var pageRequest = PageRequest.of(pageNumber, m_pageSize);

        return m_productServiceHelper.findProducts(pageRequest);
    }

    public Page<ProductVendorDto> findVendorProducts(int pageNumber)
    {
        var pageRequest = PageRequest.of(pageNumber, m_pageSize);

        return m_productServiceHelper.findVendorProducts(pageRequest);
    }

    @PreAuthorize("hasPermission(#productId, 'product', 'deleteProduct')")
    public void deleteProduct(int productId)
    {
        m_productServiceHelper.deleteProduct(productId);
    }
}
