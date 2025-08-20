package com.eraytasay.database.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    public int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product product;

    @ManyToOne
    @JoinColumn(name = "purchaser_id")
    public Purchaser purchaser;

    public Purchase(int id, Product product, Purchaser purchaser)
    {
        this.id = id;
        this.product = product;
        this.purchaser = purchaser;
    }

    public Purchase()
    {}
}
