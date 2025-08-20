package com.eraytasay.database.dto;

import com.eraytasay.database.entity.Product;

import java.time.LocalDateTime;
import java.util.List;

public class VendorDto {
    public int id;
    public String username;
    public String company;
    public LocalDateTime registerDateTime;
    public List<Product> products;
}
