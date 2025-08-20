package com.eraytasay.database.repository;

import com.eraytasay.database.entity.Purchaser;
import com.eraytasay.database.view.IPurchaserView;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPurchaserRepository extends CrudRepository<Purchaser, Integer> {
    Optional<Purchaser> findPurchaserByUsername(String username);
    Optional<IPurchaserView> findPurchaserViewByUsername(String username);
}
