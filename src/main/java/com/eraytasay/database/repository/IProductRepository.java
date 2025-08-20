package com.eraytasay.database.repository;

import com.eraytasay.database.dto.ProductDto;
import com.eraytasay.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query("select new com.eraytasay.database.dto.ProductDto(p.id, p.name, p.price) from Product p where p.vendor.username = :username")
    List<ProductDto> findProductsByVendorUsername(String username);

    void deleteById(int id);
}
