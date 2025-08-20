package com.eraytasay.database.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    public int id;

    public String name;
    public double price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Purchase> purchases;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    public Vendor vendor;
}
