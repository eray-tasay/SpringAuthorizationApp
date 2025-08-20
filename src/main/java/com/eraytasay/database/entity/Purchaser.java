package com.eraytasay.database.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "purchasers")
public class Purchaser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchaser_id")
    public int id;

    public String username;
    public String password;
    public String email;
    public LocalDate birthDate;

    @OneToMany(mappedBy = "purchaser")
    public List<Purchase> purchases;

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof Purchaser p && p.id == id && Objects.equals(p.username, username)
                && Objects.equals(p.email, email) && Objects.equals(p.birthDate, birthDate);
    }

    @Override
    public int hashCode()
    {
        return id;
    }
}
