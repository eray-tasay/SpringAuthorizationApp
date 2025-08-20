package com.eraytasay.database.view;

import com.eraytasay.database.entity.Product;

import java.time.LocalDateTime;
import java.util.List;

public interface IVendorView {
    int getId();
    String getUsername();
    String getCompany();
    LocalDateTime getRegisterDateTime();
    List<Product> getProducts();
}
