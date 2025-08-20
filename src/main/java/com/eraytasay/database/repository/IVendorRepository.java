package com.eraytasay.database.repository;

import com.eraytasay.database.entity.Vendor;
import com.eraytasay.database.view.IVendorView;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IVendorRepository extends CrudRepository<Vendor, Integer> {
    Optional<Vendor> findVendorByUsername(String username);
    Optional<IVendorView> findVendorViewByUsername(String username);
}
