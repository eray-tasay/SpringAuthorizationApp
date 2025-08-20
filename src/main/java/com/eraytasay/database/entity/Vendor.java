package com.eraytasay.database.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vendors")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id")
    public int id;

    public String username;
    public String password;
    public String company;

    @Column(name = "register_timestamp")
    public LocalDateTime registerDateTime;

    @OneToMany(mappedBy = "vendor")
    public List<Product> products;

    @Override
    public boolean equals(Object o)
    {
        return o instanceof Vendor v && id == v.id && Objects.equals(username, v.username)
                && Objects.equals(company, v.company) && Objects.equals(registerDateTime, v.registerDateTime);
    }

    @Override
    public int hashCode()
    {
        return id;
    }
}
