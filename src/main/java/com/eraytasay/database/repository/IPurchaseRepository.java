package com.eraytasay.database.repository;

import com.eraytasay.database.entity.Purchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPurchaseRepository extends CrudRepository<Purchase, Integer> {
    @Query("select new com.eraytasay.database.entity.Purchase(p.id, p.product, p.purchaser) from Purchase p where p.purchaser.username = :username")
    List<Purchase> findPurchasesByPurchaserUsername(String username);
}
