package com.oxcentra.quotationmaker.repository;

import com.oxcentra.quotationmaker.model.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem,Integer> {
}
