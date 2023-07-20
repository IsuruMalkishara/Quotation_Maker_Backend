package com.oxcentra.quotationmaker.repository;

import com.oxcentra.quotationmaker.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
