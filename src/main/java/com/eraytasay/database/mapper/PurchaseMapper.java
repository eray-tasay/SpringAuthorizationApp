package com.eraytasay.database.mapper;

import com.eraytasay.database.dto.PurchaseDto;
import com.eraytasay.database.entity.Purchase;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {
    public PurchaseDto toPurchaseDto(Purchase purchase)
    {
        var purchaseDto = new PurchaseDto();
        var product = purchase.product;

        purchaseDto.purchaseId = purchase.id;
        purchaseDto.productId = product.id;
        purchaseDto.productName = product.name;
        purchaseDto.productPrice = product.price;
        purchaseDto.vendorUsername = product.vendor.username;

        return purchaseDto;
    }
}
