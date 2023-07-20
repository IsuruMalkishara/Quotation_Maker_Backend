package com.oxcentra.quotationmaker.service;

import com.oxcentra.quotationmaker.model.ProductItem;
import com.oxcentra.quotationmaker.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductItemServiceImpl implements ProductItemService{
    @Autowired
    private ProductItemRepository productItemRepository;

    @Override
    public List<ProductItem> getProductItemList() {
        return productItemRepository.findAll();
    }
}
