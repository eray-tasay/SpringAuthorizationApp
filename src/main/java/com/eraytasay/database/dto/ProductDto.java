package com.eraytasay.database.dto;

public class ProductDto {
    public int id;
    public String name;
    public double price;

    public ProductDto(int id, String name, double price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductDto()
    {}
}
