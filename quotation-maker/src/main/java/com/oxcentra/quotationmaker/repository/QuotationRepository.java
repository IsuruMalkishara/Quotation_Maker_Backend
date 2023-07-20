package com.oxcentra.quotationmaker.repository;

import com.oxcentra.quotationmaker.model.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotationRepository extends JpaRepository<Quotation,Integer> {
}
