package com.eraytasay.database.mapper;

import com.eraytasay.database.dto.ProductDto;
import com.eraytasay.database.dto.ProductSaveDto;
import com.eraytasay.database.dto.ProductVendorDto;
import com.eraytasay.database.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toProduct(ProductSaveDto productSaveDto)
    {
        var product = new Product();

        product.name = productSaveDto.getName();
        product.price = productSaveDto.getPrice();

        return product;
    }

    public ProductDto toProductDto(Product product)
    {
        var productDto = new ProductDto();

        productDto.id = product.id;
        productDto.name = product.name;
        productDto.price = product.price;

        return productDto;
    }

    public ProductVendorDto toProductVendorDto(Product product)
    {
        var productVendorDto = new ProductVendorDto();

        productVendorDto.id = product.id;
        productVendorDto.name = product.name;
        productVendorDto.price = product.price;
        productVendorDto.vendorUsername = product.vendor.username;

        return productVendorDto;
    }
}
